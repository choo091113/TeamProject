package com.example.member.controller;

import com.example.member.dto.MemberDTO;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

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
@GetMapping("layout/loginpage")
public String loginform() {
        return "layout/loginpage.html";
}
    @PostMapping("layout/loginpage")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            // 로그인 성공
            session.setAttribute("loginName", loginResult.getMemberName());
            return "layout/Main";
        } else {
            // 로그인 실패
            return "layout/loginpage";
        }
    }

}
