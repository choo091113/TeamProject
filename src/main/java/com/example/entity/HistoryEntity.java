package com.example.entity;



import com.example.dto.HistoryDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@Table(name = "history_table")
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_sequence")
    private Long historyId;

@Column
private int historyItemid;

@Column
private int historyMemberid;

@Column
private String historyMember;

@Column
private String historyMemberprofile;

@Column
private String historySeller;
@Column
private String historyName;

@Column
private String historyImage;

private int historyPrice;

    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date historyDate;


    public static HistoryEntity toHistoryEntity(HistoryDTO historyDTO) {
        HistoryEntity historyEntity = new HistoryEntity();
        historyEntity.setHistoryId(historyDTO.getHistoryId());
        historyEntity.setHistoryItemid(historyDTO.getHistoryItemid());
        historyEntity.setHistoryMemberid(historyDTO.getHistoryMemberid());
        historyEntity.setHistoryMember(historyDTO.getHistoryMember());
        historyEntity.setHistoryMemberprofile(historyDTO.getHistoryMemberprofile());
        historyEntity.setHistorySeller(historyDTO.getHistorySeller());
        historyEntity.setHistoryName(historyDTO.getHistoryName());
        historyEntity.setHistoryImage(historyDTO.getHistoryImage());
        historyEntity.setHistoryPrice(historyDTO.getHistoryPrice());
        historyEntity.setHistoryDate(historyDTO.getHistoryDate());
        return historyEntity;
    }


    public static HistoryEntity toUpdateHistoryEntity(HistoryDTO historyDTO) {
        HistoryEntity historyEntity = new HistoryEntity();
     historyEntity.setHistoryId(historyDTO.getHistoryId());
     historyEntity.setHistoryItemid(historyDTO.getHistoryItemid());
     historyEntity.setHistoryMemberid(historyDTO.getHistoryMemberid());
        historyEntity.setHistoryMember(historyDTO.getHistoryMember());
        historyEntity.setHistoryMemberprofile(historyDTO.getHistoryMemberprofile());
        historyEntity.setHistorySeller(historyDTO.getHistorySeller());
      historyEntity.setHistoryName(historyDTO.getHistoryName());
  historyEntity.setHistoryImage(historyDTO.getHistoryImage());
  historyEntity.setHistoryPrice(historyDTO.getHistoryPrice());
       historyEntity.setHistoryDate(historyDTO.getHistoryDate());

        return historyEntity;
    }

}
