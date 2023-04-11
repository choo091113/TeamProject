package com.example.dto;

import com.example.entity.NoticeEntity;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class NoticeDTO {

    private Long noticeId;
    private String noticeTitle;
    private String noticeContent;

private Date noticeDate;

    public static NoticeDTO tonoticeDTO(NoticeEntity noticeEntity) {
       NoticeDTO noticeDTO = new NoticeDTO();
noticeDTO.setNoticeId(noticeEntity.getNoticeId());
        noticeDTO.setNoticeTitle(noticeEntity.getNoticeTitle());
        noticeDTO.setNoticeContent(noticeEntity.getNoticeContent());
        noticeDTO.setNoticeDate(noticeEntity.getNoticeDate());
        return noticeDTO;
    }
}
