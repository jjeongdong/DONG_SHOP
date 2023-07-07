package com.example.dong_shop.item.repository;

import com.example.dong_shop.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNm(String itemNm);

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    @Query("select i from Item i where i.itemDetail like %:itemDetail% " +
            "order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
}
