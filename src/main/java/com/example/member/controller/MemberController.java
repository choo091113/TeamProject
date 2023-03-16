package com.example.member.controller;

import com.example.member.dto.MemberDTO;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
// 생성자 주입
    private final MemberService memberService;


    //회원가입 페이지 출력 요청
    @GetMapping("layout/signCli")
    public String signCli() {
        return "layout/signCli.html";
    }
    @PostMapping("layout/signCli")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("MemberDTO = " + memberDTO);
System.out.println("memberDTO = " + memberDTO);
memberService.save(memberDTO);
        return "layout/complete.html";
    }

}
