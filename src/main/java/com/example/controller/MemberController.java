package com.example.controller;

import com.example.dto.MemberDTO;
import com.example.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @GetMapping("layout/list")
        public String findAll(Model model) {
            List<MemberDTO> memberDTOList = memberService.findAll();
            // 어떠한 html로 가져갈 데이터가 있다면 model을 사용
            model.addAttribute("memberList", memberDTOList);
return "layout/list";
        }


    @GetMapping("layout/myPage_update")
    public String updateForm(HttpSession session, Model model) {
        String myName = (String) session.getAttribute("loginName");
        MemberDTO memberDTO = memberService.updateForm(myName);
        model.addAttribute("updateMember", memberDTO);
        return "myPage_update";
    }
@PostMapping("layout/myPage_update")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        memberService.update(memberDTO);
return "redirect:/layout/" + memberDTO.getMemberEmail();
}
@GetMapping("layout/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "layout/Main.html";
}

}
