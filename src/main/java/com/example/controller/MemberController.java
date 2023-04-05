package com.example.controller;

import com.example.dto.ItemDTO;
import com.example.dto.MemberDTO;
import com.example.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
            session.setAttribute("loginid", loginResult.getId());
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


@GetMapping("layout/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "layout/Main.html";
}
    @GetMapping("myPage_cash/{id}")
    public String myPage_cash(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "layout/myPage_cash";
    }

    @GetMapping("/myPage_like/{id}")
    public String myPage_like(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "layout/myPage_like";
    }

    @GetMapping("/myPage_charges/{id}")
    public String myPage_charges(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "layout/myPage_charges";
    }

    @GetMapping("/myPage_orderList/{id}")
    public String myPage_orderList(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "layout/myPage_orderList";
    }

    @GetMapping("/myPage_update/{id}")
    public String myPage_update(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "layout/myPage_update";
    }

    @GetMapping("/myProfile_update/{id}")
    public String myProfile_update(HttpServletRequest request, Model model) {
        MemberDTO memberDTO = memberService.findById(Long.parseLong(request.getParameter("id")));
        model.addAttribute("updateMember", memberDTO);
        return "layout/myProfile_update";
    }

    @PostMapping("/myProfile_update")
    public String myProfile_update(MemberDTO memberDTO) {
        memberService.update(memberDTO.getId(), memberDTO);
        return "redirect:/myProfile";
    }

    @PostMapping("/layout/email-check")
    public @ResponseBody String emailCheck(@RequestParam("memberEmail") String memberEmail) {
        System.out.println("memberEmail = " + memberEmail);
        String checkResult = memberService.emailCheck(memberEmail);
        return checkResult;
//        if (checkResult != null) {
//            return "ok";
//        } else {
//            return "no";
//        }
    }
}
