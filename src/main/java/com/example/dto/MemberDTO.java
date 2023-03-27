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
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberType;
    private String MemberProfile;

    private int memberCash;
    private Date MemberDate;



public static MemberDTO tomemberDTO(MemberEntity memberEntity) {
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setMemberEmail(memberEntity.getMemberEmail());
    memberDTO.setMemberPassword(memberDTO.getMemberPassword());
    memberDTO.setMemberName(memberEntity.getMemberName());
    memberDTO.setMemberType(memberEntity.getMemberType());
    memberDTO.setMemberProfile(memberEntity.getMemberProfile());
    memberDTO.setMemberCash(memberEntity.getMemberCash());
    return memberDTO;
}
}
