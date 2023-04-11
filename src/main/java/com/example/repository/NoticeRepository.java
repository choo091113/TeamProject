package com.example.repository;

import com.example.entity.MemberEntity;
import com.example.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {

}
