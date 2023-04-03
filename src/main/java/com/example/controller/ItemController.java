package com.example.controller;

import com.example.dto.ItemDTO;
import com.example.dto.MemberDTO;
import com.example.entity.ItemEntity;
import com.example.repository.ItemRepository;
import com.example.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        System.out.println("itemDTO = " + itemDTO);
        itemService.saveitem(itemDTO);
        return "layout/Main";
    }

    @GetMapping("layout/Clist")
    public String findAllitem(Model model) {
        List<ItemDTO> itemDTOList = itemService.findAllitem();
        // 어떠한 html로 가져갈 데이터가 있다면 model 사용
        model.addAttribute("itemList", itemDTOList);
        return "layout/Clist";
    }

    @GetMapping("layout/itemDtl/{id}")
    public String findByid(@PathVariable Long id, Model model) {
        ItemDTO itemDTO = itemService.findById(id);
        model.addAttribute("item", itemDTO);
        return "layout/itemDtl";
    }


}

