package com.example.member.dto;

import com.example.member.entity.MemberEntity;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MemberDTO {
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberType;
    private String MemberProfile;

    private Date MemberDate;



public static MemberDTO tomemberDTO(MemberEntity memberEntity) {
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setMemberEmail(memberEntity.getMemberEmail());
    memberDTO.setMemberPassword(memberDTO.getMemberPassword());
    memberDTO.setMemberName(memberEntity.getMemberName());
    memberDTO.setMemberType(memberEntity.getMemberType());
    memberDTO.setMemberProfile(memberEntity.getMemberProfile());
    return memberDTO;
}
}
