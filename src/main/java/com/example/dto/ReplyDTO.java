package com.example.dto;

import com.example.entity.NoticeEntity;
import com.example.entity.ReplyEntity;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ReplyDTO {

    private Long replyId;

    private int replyItemid;
    private String replyContent;
    private String replyMember;
    private String replyProfile;
    private Date replyDate;

    public static ReplyDTO toreplyDTO(ReplyEntity replyEntity) {
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setReplyId(replyEntity.getReplyId());
        replyDTO.setReplyItemid(replyEntity.getReplyItemid());
        replyDTO.setReplyContent(replyEntity.getReplyContent());
        replyDTO.setReplyMember(replyEntity.getReplyMember());
        replyDTO.setReplyProfile(replyEntity.getReplyProfile());
        replyDTO.setReplyDate(replyEntity.getReplyDate());
        return replyDTO;
    }
}
