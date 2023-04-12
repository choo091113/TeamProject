package com.example.repository;


import com.example.entity.HistoryEntity;
import com.example.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {
    List<HistoryEntity> findAllByHistoryMemberid(int HistoryMemberid);

}
