package com.example.controller;

import com.example.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @GetMapping("layout/signCli2")
    public String signCli() {
        return "layout/signCli2.html";
    }
    @PostMapping("layout/signCli2")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("MemberDTO = " + memberDTO);


        return "layout/index.html";
    }

}
