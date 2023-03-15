package com.example.controller;

import com.example.dto.UsersFormDto;
import com.example.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.entity.Users;
import org.springframework.web.bind.annotation.PostMapping;



@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    @GetMapping(value = "layout/signPro2")
    public String signPro2(Model model) {
        model.addAttribute("memberFormDto", new UsersFormDto());
        return "layout/signPro2.html";

    }

    }

