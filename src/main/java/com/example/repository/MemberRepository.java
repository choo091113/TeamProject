package com.example.repository;

import com.example.entity.ItemEntity;
import com.example.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //이메일로 회원 정보 조회 (select * from member_table where member_email=?)
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
Optional<MemberEntity> findByMemberName(String memberName);

    Optional<MemberEntity> findById(Long id);


}
