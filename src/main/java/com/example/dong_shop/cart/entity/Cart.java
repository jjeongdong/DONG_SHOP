package com.example.dong_shop.cart.entity;

import com.example.dong_shop.member.entity.Member;
import com.example.dong_shop.utils.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    public static Cart createCart(Member member) {
        Cart cart = new Cart();
        cart.setMember(member);

        return cart;
    }
}
