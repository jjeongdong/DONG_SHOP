package com.example.dong_shop.cart.repository;


import com.example.dong_shop.cart.entity.Cart;
import com.example.dong_shop.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findByCartIdAndItemId(Long cartId, Long itemId);
}
