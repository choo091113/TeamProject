package com.example.entity;


import com.example.dto.NoticeDTO;
import com.example.dto.ReplyDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@Table(name = "reply_table")
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_sequence")
    private Long replyId;

    @Column
    private int replyItemid;
    @Column // unique 제약 조건 추가ㅣ
    private String replyContent;

    @Column
    private String replyMember;

    @Column
    private String replyProfile;

    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date replyDate;


    public static ReplyEntity toReplyEntity(ReplyDTO replyDTO) {
       ReplyEntity replyEntity = new ReplyEntity();
        replyEntity.setReplyId(replyDTO.getReplyId());
        replyEntity.setReplyItemid(replyDTO.getReplyItemid());
        replyEntity.setReplyContent(replyDTO.getReplyContent());
        replyEntity.setReplyMember(replyDTO.getReplyMember());
        replyEntity.setReplyProfile(replyDTO.getReplyProfile());
        replyEntity.setReplyDate(replyDTO.getReplyDate());

        return replyEntity;

    }

    public static ReplyEntity toUpdateReplyEntity(ReplyDTO ReplyDTO) {
        ReplyEntity replyEntity = new ReplyEntity();
        replyEntity.setReplyId(ReplyDTO.getReplyId());
        replyEntity.setReplyItemid(ReplyDTO.getReplyItemid());
       replyEntity.setReplyContent(ReplyDTO.getReplyContent());
       replyEntity.setReplyMember(ReplyDTO.getReplyMember());
      replyEntity.setReplyProfile(ReplyDTO.getReplyProfile());
    replyEntity.setReplyDate(ReplyDTO.getReplyDate());

        return replyEntity;
    }

}
