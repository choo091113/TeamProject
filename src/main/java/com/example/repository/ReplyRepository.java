package com.example.repository;


import com.example.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {

    List<ReplyEntity> findAllByReplyItemid(int replyItemid);
}
