package com.example.controller;

import com.example.dto.ItemDTO;
import com.example.dto.MemberDTO;
import com.example.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor

public class ItemController {
    // 생성자 주입
    public final ItemService itemService;

    // 상품등록 페이지 출력 요청
    @GetMapping("layout/itemForm")
    public String saveitem() {
        return "layout/itemForm";
    }

    @PostMapping("layout/itemForm")
    public String postitem(@ModelAttribute ItemDTO itemDTO) {
        System.out.println("assada");
        System.out.println("itemDTO = " + itemDTO);
       itemService.saveitem(itemDTO);
        return "layout/Main";
    }
}
