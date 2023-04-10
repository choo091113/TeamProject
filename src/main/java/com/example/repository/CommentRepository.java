package com.example.repository;

import com.example.entity.CommentEntity;
import com.example.entity.ItemEntity;
import com.example.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    Optional<CommentEntity> findByid(Long id);

}
