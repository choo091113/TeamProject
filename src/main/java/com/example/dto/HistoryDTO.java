package com.example.dto;


import com.example.entity.HistoryEntity;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class HistoryDTO {

    private Long historyId;
    private int historyItemid;
    private int historyMemberid;

    private String historyMember;

    private String historyMemberprofile;
    private String historySeller;
    private String historyName;

    private String historyImage;

    private int historyPrice;
    private Date historyDate;

    public static HistoryDTO tohistoryDTO(HistoryEntity historyEntity) {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setHistoryId(historyEntity.getHistoryId());
        historyDTO.setHistoryItemid(historyEntity.getHistoryItemid());
        historyDTO.setHistoryMemberid(historyEntity.getHistoryMemberid());
        historyDTO.setHistoryMember(historyEntity.getHistoryMember());
        historyDTO.setHistoryMemberprofile(historyEntity.getHistoryMemberprofile());
        historyDTO.setHistorySeller(historyEntity.getHistorySeller());
        historyDTO.setHistoryName(historyEntity.getHistoryName());
        historyDTO.setHistoryImage(historyEntity.getHistoryImage());
        historyDTO.setHistoryPrice(historyEntity.getHistoryPrice());
historyDTO.setHistoryDate(historyEntity.getHistoryDate());

        return historyDTO;
    }
}
