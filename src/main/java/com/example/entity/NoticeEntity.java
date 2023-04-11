package com.example.entity;


import com.example.dto.NoticeDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@Table(name = "notice_table")
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_sequence")
    private Long noticeId;

    @Column(unique = true) // unique 제약 조건 추가ㅣ
    private String noticeTitle;

    @Column
    private String noticeContent;

    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
private Date noticeDate;


    public static NoticeEntity toNoticeEntity(NoticeDTO noticeDTO) {
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setNoticeId(noticeDTO.getNoticeId());
        noticeEntity.setNoticeTitle(noticeDTO.getNoticeTitle());
        noticeEntity.setNoticeContent(noticeDTO.getNoticeContent());
        noticeEntity.setNoticeDate(noticeDTO.getNoticeDate());

        return noticeEntity;
    }

    public static NoticeEntity toUpdateNoticeEntity(NoticeDTO noticeDTO) {
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setNoticeId(noticeDTO.getNoticeId());
        noticeEntity.setNoticeTitle(noticeDTO.getNoticeTitle());
        noticeEntity.setNoticeContent(noticeDTO.getNoticeContent());
        noticeEntity.setNoticeDate(noticeDTO.getNoticeDate());

        return noticeEntity;
    }

}
