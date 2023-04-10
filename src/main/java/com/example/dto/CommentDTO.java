package com.example.dto;

import com.example.entity.CommentEntity;
import com.example.entity.ItemEntity;
import com.example.entity.MemberEntity;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDTO {

    private Long id;
    private String commentContent;
    private Date commentDate;

    public static CommentDTO tocommentDTO(CommentEntity commentEntity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setCommentContent(commentEntity.getCommentContent());
        commentDTO.setCommentDate(commentEntity.getCommentDate());


        return commentDTO;
    }
}
