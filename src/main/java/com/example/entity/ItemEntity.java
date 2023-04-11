package com.example.entity;


import com.example.dto.ItemDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "item_table")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence")
    @Column(name = "id")
    private long id;

    @Column
    private String itemName;


    @Column
    private int itemPrice;

    @Column
    private String itemImage1;

    @Column
    private String itemImage2;

    @Column
    private String itemImage3;

    @Column
    private String itemImage4;
    @Column
    private String itemVideo;

    @Column
    private String itemContent1;

    @Column
    private String itemContent2;

    @Column
    private String itemCategory1;

    @Column
    private String itemCategory2;

    @Column
    private String itemCategory3;

    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date itemDate;

    @Column
    private String itemSeller;

    @Column int itemSellerid;


    public static ItemEntity toItemEntity(ItemDTO itemDTO) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItemName(itemDTO.getItemName());
        itemEntity.setItemPrice(itemDTO.getItemPrice());
        itemEntity.setItemImage1(itemDTO.getItemImage1());
        itemEntity.setItemImage2(itemDTO.getItemImage2());
        itemEntity.setItemImage3(itemDTO.getItemImage3());
        itemEntity.setItemImage4(itemDTO.getItemImage4());
        itemEntity.setItemVideo(itemDTO.getItemVideo());
        itemEntity.setItemContent1(itemDTO.getItemContent1());
        itemEntity.setItemContent2(itemDTO.getItemContent2());
        itemEntity.setItemCategory1(itemDTO.getItemCategory1());
        itemEntity.setItemCategory2(itemDTO.getItemCategory2());
        itemEntity.setItemCategory3(itemDTO.getItemCategory3());
        itemEntity.setItemDate(itemDTO.getItemDate());
itemEntity.setItemSeller(itemDTO.getItemSeller());
 itemEntity.setItemSellerid(itemDTO.getItemSellerid());
        return itemEntity;

    }
}