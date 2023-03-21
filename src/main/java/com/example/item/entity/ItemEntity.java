package com.example.item.entity;


import com.example.item.dto.ItemDTO;
import com.example.member.dto.MemberDTO;
import com.example.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "item_table")
public class ItemEntity {


    @Id
    @Column(unique = true)
    private String itemName;

    @Column
private int itemPrice;

    @Column
    private String itemImage;

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

    @OneToOne
    @JoinColumn(name = "item_member", referencedColumnName = "membername")
    private MemberEntity member;

    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date itemDate;

    public static ItemEntity toItemEntity(ItemDTO itemDTO) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItemName(itemDTO.getItemName());
        itemEntity.setItemPrice(itemDTO.getItemPrice());
        itemEntity.setItemImage(itemDTO.getItemImage());
        itemEntity.setItemVideo(itemDTO.getItemVideo());
        itemEntity.setItemContent1(itemDTO.getItemContent1());
        itemEntity.setItemContent2(itemDTO.getItemContent2());
        itemEntity.setItemCategory1(itemDTO.getItemCategory1());
        itemEntity.setItemCategory2(itemDTO.getItemCategory2());
        itemEntity.setItemCategory3(itemDTO.getItemCategory3());
        itemEntity.setMember(MemberEntity.toMemberEntity(itemDTO.getMember()));
        itemEntity.setItemDate(itemDTO.getItemDate());

        return itemEntity;

}
}