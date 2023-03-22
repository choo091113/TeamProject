package com.example.dto;

import com.example.entity.ItemEntity;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ItemDTO {
    private String itemName;
    private int itemPrice;
    private String itemImage1;
    private String itemImage2;
    private String itemImage3;
    private String itemImage4;

    private String itemVideo;

    private String itemContent1;

    private String itemContent2;

    private String itemCategory1;


    private String itemCategory2;


    private String itemCategory3;

    @OneToOne
    @JoinColumn(name = "memberName")
    private MemberDTO memberName;

    private Date itemDate;

    public static ItemDTO toitemDTO(ItemEntity itemEntity) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemName(itemEntity.getItemName());
        itemDTO.setItemPrice(itemEntity.getItemPrice());
        itemDTO.setItemImage1(itemEntity.getItemImage1());
        itemDTO.setItemImage2(itemEntity.getItemImage2());
        itemDTO.setItemImage3(itemEntity.getItemImage3());
        itemDTO.setItemImage4(itemEntity.getItemImage4());
        itemDTO.setItemVideo(itemEntity.getItemVideo());
        itemDTO.setItemContent1(itemEntity.getItemContent1());
        itemDTO.setItemContent2(itemEntity.getItemContent2());
        itemDTO.setItemCategory1(itemEntity.getItemCategory1());
        itemDTO.setItemCategory2(itemEntity.getItemCategory2());
        itemDTO.setItemCategory3(itemEntity.getItemCategory3());
     //   itemDTO.setMemberName(itemEntity.getMemberName());
        itemDTO.setItemDate(itemEntity.getItemDate());


        return itemDTO;
    }
}
