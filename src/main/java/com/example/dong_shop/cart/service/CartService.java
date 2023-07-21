package com.example.dong_shop.cart.service;

import com.example.dong_shop.cart.dto.CartItemDto;
import com.example.dong_shop.cart.entity.Cart;
import com.example.dong_shop.cart.entity.CartItem;
import com.example.dong_shop.cart.repository.CartItemRepository;
import com.example.dong_shop.cart.repository.CartRepository;
import com.example.dong_shop.item.entity.Item;
import com.example.dong_shop.item.repository.ItemRepository;
import com.example.dong_shop.member.entity.Member;
import com.example.dong_shop.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;


    public Long addCart(CartItemDto cartItemDto, String email) {
        Item item = itemRepository.findById(cartItemDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email);

        Cart cart = cartRepository.findByMemberId(member.getId());
        if (cart == null) {
            cart = Cart.createCart(member);
            cartRepository.save(cart);
        }

        CartItem savedCartItem = cartItemRepository.findByCartIdAndItemId(cart.getId(), item.getId());

        if (savedCartItem != null) {
            savedCartItem.addCount(cartItemDto.getCount());
            return savedCartItem.getId();
        } else {
            CartItem cartItem = CartItem.createCartItem(cart, item, cartItemDto.getCount());
            cartItemRepository.save(cartItem);
            return cartItem.getId();
        }
    }
}
