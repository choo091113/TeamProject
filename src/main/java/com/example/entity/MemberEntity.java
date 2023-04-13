package com.example.entity;

import com.example.dto.MemberDTO;
import com.example.role.MemberType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @Column
    private Long id;

    @Column(unique = true) // unique 제약 조건 추가ㅣ
    private String memberEmail;

    @Column
    private String memberPassword;

    @Column
    private String memberName;

    @Column

    private String memberType;

    @Column
    private String memberProfile;

    @Column
    private int memberCash;

    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date memberDate;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberType(memberDTO.getMemberType());
        memberEntity.setMemberProfile(memberDTO.getMemberProfile());
        memberEntity.setMemberDate(memberDTO.getMemberDate());
        memberEntity.setMemberCash(memberDTO.getMemberCash());
        return memberEntity;
    }

    public static MemberEntity toUpdateMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberType(memberDTO.getMemberType());
        memberEntity.setMemberProfile(memberDTO.getMemberProfile());
        memberEntity.setMemberDate(memberDTO.getMemberDate());
        memberEntity.setMemberCash(memberDTO.getMemberCash());
        return memberEntity;
    }

    public void setMemberProfile(String memberProfile) {
        if (memberProfile == null) {
            this.memberProfile = "https://mblogthumb-phinf.pstatic.net/20150427_261/ninevincent_1430122791768m7oO1_JPEG/kakao_1.jpg?type=w2'";
        } else {
            this.memberProfile = memberProfile;
        }
    }

}
