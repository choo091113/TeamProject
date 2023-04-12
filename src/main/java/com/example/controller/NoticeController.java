package com.example.controller;


import com.example.dto.ItemDTO;
import com.example.dto.MemberDTO;
import com.example.dto.NoticeDTO;
import com.example.service.MemberService;
import com.example.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;
    @GetMapping(value = "/noticePage")
    public String findAll(Model model) {
        List<NoticeDTO> noticeDTOList = noticeService.findAllnotice();
        // 어떠한 html로 가져갈 데이터가 있다면 model을 사용
        model.addAttribute("noticeList", noticeDTOList);

        return "layout/noticePage";
    }

    @GetMapping("/noticeForm")
    public String noticeFormAccess(HttpSession session) {
        String memberType = (String) session.getAttribute("loginType");
        if(memberType != null && (memberType.equals("ADMIN"))) {
            return "layout/noticeForm";
        } else {
            System.out.println("Invalid memberType: " + memberType);
            return "redirect:/Main";
        }
    }



    @PostMapping("/noticeForm")
    public String postnotice(@ModelAttribute NoticeDTO noticeDTO) {
        noticeService.savenotice(noticeDTO);
        return "layout/Main";
    }

    @GetMapping("/admin_noticeList")
    public String findAll(Model model, HttpSession session) {
        String memberType = (String) session.getAttribute("loginType");
        List<NoticeDTO> noticeDTOList = noticeService.findAll();
        model.addAttribute("noticeList", noticeDTOList);
        if(memberType != null && (memberType.equals("ADMIN"))) {
            return "layout/admin_noticeList";
        }else {
            return "redirect:/Main";
        }
    }

    @PostMapping("/admin/notice/delete")
    public String deleteNotice(@RequestParam Long noticeId) {
       noticeService.deleteById(noticeId);
        return "redirect:/admin_noticeList";
    }

}
