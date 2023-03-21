package com.example.item.dto;

import com.example.item.entity.ItemEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Blob;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ItemDTO {
    private String itemName;
    private int itemPrice;
    private Blob itemImage;

    private String itemVideo;

    private String itemContent1;

    private String itemContent2;

    private String itemCategory1;


    private String itemCategory2;


    private String itemCategory3;

    private String itemMember;

    private Date itemDate;

    public static ItemDTO toitemDTO(ItemEntity itemEntity) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemName(itemEntity.getItemName());
        itemDTO.setItemPrice(itemEntity.getItemPrice());
        itemDTO.setItemImage(itemEntity.getItemImage());
        itemDTO.setItemVideo(itemEntity.getItemVideo());
        itemDTO.setItemContent1(itemEntity.getItemContent1());
        itemDTO.setItemContent2(itemEntity.getItemContent2());
        itemDTO.setItemCategory1(itemEntity.getItemCategory1());
        itemDTO.setItemCategory2(itemEntity.getItemCategory2());
        itemDTO.setItemCategory3(itemEntity.getItemCategory3());
        itemDTO.setItemMember(itemEntity.getItemMember());
        itemDTO.setItemDate(itemEntity.getItemDate());


        return itemDTO;
    }
}