package com.example.service;

import com.example.dto.MemberDTO;
import com.example.entity.MemberEntity;
import com.example.repository.MemberRepository;
import com.example.role.MemberType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        // repository의 save 메서드 호출 (entity 객체를 넘겨줘야함)
        // 1. dto -> entity
        // 2. repository의 save메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);


    }

    public MemberDTO login(MemberDTO memberDTO) {
        /*
        1. 회원이 입력한 이메일로 DB에서 조회를 함
        2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            // 조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                // 비밀번호가 일치하다 (로그인 성공)
                // entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.tomemberDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 틀림 (로그인 실패)
                return null;
            }
        } else {
            // 조회 결과 없음( 이메일 없다 )
            return null;
        }
    }

  /*  public MemberDTO updateForm(String myName) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberName(myName);
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.tomemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

   public void update(MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));

    } */

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity memberEntity : memberEntityList) {
            memberDTOList.add(MemberDTO.tomemberDTO(memberEntity));
         //   MemberDTO memberDTO = MemberDTO.tomemberDTO(memberEntity);
          //  memberDTOList.add(memberDTO);
        }
        return memberDTOList;
    }

    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.tomemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    public MemberDTO updateForm(String myEmail) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberEmail(myEmail);
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.tomemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    public void update(Long id, MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    public String emailCheck(String memberEmail) {
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberEmail);
        if (byMemberEmail.isPresent()) {
            // 조회결과가 있다 -> 사용할 수 없다.
            return null;
        } else {
            // 조회결과가 없다 -> 사용할 수 있다.
            return "ok";
        }
    }

    public void changeMemberType(Long id, String memberType) {
        MemberEntity member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
        member.setMemberType(memberType);
        memberRepository.save(member);
    }
}
