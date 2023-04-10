package com.example.entity;


import com.example.dto.CommentDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "comment_table")
public class CommentEntity {

    @Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence")
   // @SequenceGenerator(name = "item_sequence", sequenceName = "item_sequence", allocationSize = 1)
    private Long id;

    @Column
    private String commentContent;

    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date commentDate;



    public static CommentEntity tocommentEntity(CommentDTO commentDTO) {
        CommentEntity commentEntity = new CommentEntity();
commentEntity.setId(commentEntity.getId());
commentEntity.setCommentContent(commentEntity.getCommentContent());
commentEntity.setCommentDate(commentEntity.getCommentDate());

        return commentEntity;

    }
}