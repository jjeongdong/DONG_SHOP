package com.example.dong_shop.item.dto;

import com.example.dong_shop.item.entity.ItemImg;
import com.example.dong_shop.utils.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
public class ItemImgDto {
    private Long id;

    private String imgName;     // 설정된 이름

    private String oriImgName;  // 원본 이름

    private String imgUrl;

    private String repImgYn;    // 대표 이미지 사용여부

    private static ModelMapper modelMapper = new ModelMapper();

    // Entity to Dto
    public static ItemImgDto of(ItemImg itemImg) {
        return modelMapper.map(itemImg, ItemImgDto.class);
    }
}
