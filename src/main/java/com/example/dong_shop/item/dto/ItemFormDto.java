package com.example.dong_shop.item.dto;

import com.example.dong_shop.item.constant.ItemSellStatus;
import com.example.dong_shop.item.entity.Item;
import com.example.dong_shop.item.entity.ItemImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ItemFormDto {

    private Long id;            // 상품 코드

    @NotBlank(message = "상품명은 필수 항목 입니다.")
    private String itemNm;      // 상품 이름

    @NotNull(message = "가격은 필수 항목 입니다.")
    private int price;          // 상품 가격

    @NotNull(message = "재고는 필수 항목 입니다.")
    private int stockNumber;    // 상품 수량

    private ItemSellStatus itemSellStatus;

    @NotBlank(message = "상품 설명은 필수 항목 입니다.")
    private String itemDetail;  // 상품 상세 설명

    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();

    private List<Long> itemImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public Item createItem() {
        return modelMapper.map(this, Item.class);
    }

    public static ItemFormDto of(Item item) {
        return modelMapper.map(item, ItemFormDto.class);
    }
}
