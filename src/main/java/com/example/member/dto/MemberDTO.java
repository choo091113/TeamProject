package com.example.member.dto;

import com.example.member.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MemberDTO {
    private String memberEmail;
    private String memberPassword;
    private String memberName;

public static MemberDTO tomemberDTO(MemberEntity memberEntity) {
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setMemberEmail(memberEntity.getMemberEmail());
    memberDTO.setMemberPassword(memberDTO.getMemberPassword());
    memberDTO.setMemberName(memberEntity.getMemberName());
    return memberDTO;
}
}
