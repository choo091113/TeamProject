package com.example.dto;

import com.example.entity.MemberEntity;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MemberDTO {

    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberType;
    private String MemberProfile;

    private int memberCash;
    private Date MemberDate;



public static MemberDTO tomemberDTO(MemberEntity memberEntity) {
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setId(memberEntity.getId());
    memberDTO.setMemberEmail(memberEntity.getMemberEmail());
    memberDTO.setMemberPassword(memberEntity.getMemberPassword());
    memberDTO.setMemberName(memberEntity.getMemberName());
    memberDTO.setMemberType(memberEntity.getMemberType());
    memberDTO.setMemberProfile(memberEntity.getMemberProfile());
    memberDTO.setMemberCash(memberEntity.getMemberCash());
    return memberDTO;
}
}
