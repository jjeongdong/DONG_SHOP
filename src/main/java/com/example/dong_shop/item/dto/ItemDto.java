package com.example.dong_shop.item.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemDto {
    private Long id;            // 상품 코드

    private String itemNm;      // 상품 이름

    private int price;          // 상품 가격

    private int stockNumber;    // 상품 수량

    private String itemSellStatus;

    private String itemDetail;  // 상품 상세 설명

    private LocalDateTime regTime;  // 등록 시간

    private LocalDateTime updateTime;  // 등록 시간
}
