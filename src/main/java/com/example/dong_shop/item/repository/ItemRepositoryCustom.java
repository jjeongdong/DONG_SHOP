package com.example.dong_shop.item.repository;

import com.example.dong_shop.item.dto.ItemSearchDto;
import com.example.dong_shop.item.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
