package com.example.dong_shop.order.service;

import com.example.dong_shop.item.entity.Item;
import com.example.dong_shop.item.repository.ItemRepository;
import com.example.dong_shop.member.entity.Member;
import com.example.dong_shop.member.repository.MemberRepository;
import com.example.dong_shop.order.dto.OrderDto;
import com.example.dong_shop.order.entity.Order;
import com.example.dong_shop.order.entity.OrderItem;
import com.example.dong_shop.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    public Long order(OrderDto orderDto, String email) {
        Item item = itemRepository.findById(orderDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email);

        List<OrderItem> orderItemList = new ArrayList<>();

        OrderItem orderItem = OrderItem.createOrderItem(item, orderDto.getCount());
        orderItemList.add(orderItem);

        Order order = Order.createOrder(member, orderItemList);
        orderRepository.save(order);

        return order.getId();
    }
}
