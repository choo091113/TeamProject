package com.example.controller;

import com.example.dto.ItemDTO;
import com.example.dto.MemberDTO;
import com.example.dto.ReplyDTO;
import com.example.entity.ItemEntity;
import com.example.repository.ItemRepository;
import com.example.service.ItemService;
import com.example.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor

public class ItemController {
    // 생성자 주입
    public final ItemService itemService;
public final ReplyService replyService;

    // 상품등록 페이지 출력 요청
//    @GetMapping("/itemForm")
//    public String saveitem() {
//        return "layout/itemForm";
//    }
    @GetMapping("/itemForm")
    public String itemFormAccess(HttpSession session) {
        String memberType = (String) session.getAttribute("loginType");
        if(memberType != null && (memberType.equals("PRO") || memberType.equals("ADMIN"))) {
            return "layout/itemForm";
        } else {
            System.out.println("Invalid memberType: " + memberType);
            return "redirect:/loginpage";
        }
    }



    @PostMapping("/itemForm")
    public String postitem(@ModelAttribute ItemDTO itemDTO) {
        System.out.println("itemDTO = " + itemDTO);
        itemService.saveitem(itemDTO);
        return "layout/Main";
    }



    @GetMapping("/Clist")
    public String findAllitem(Model model) {
        List<ItemDTO> itemDTOList = itemService.findAllitem();
        // 어떠한 html로 가져갈 데이터가 있다면 model 사용
        model.addAttribute("itemList", itemDTOList);
        return "layout/Clist";
    }

    @GetMapping("/Main")
    public String findTop3ByOrderByIdDesc(Model model) {
        List<ItemDTO> itemDTOList = itemService.findTop3ByOrderByIdDesc();
        // 어떠한 html로 가져갈 데이터가 있다면 model 사용
        model.addAttribute("itemList", itemDTOList);
        return "layout/Main";
    }

    @GetMapping("/itemDtl/{id}")
    public String findByid(@PathVariable Long id, Model model) {
        ItemDTO itemDTO = itemService.findById(id);
        List<ReplyDTO> replyDTOList = replyService.findAllByReplyItemId(itemDTO.getId().intValue());
        model.addAttribute("item", itemDTO);
        model.addAttribute("replyList", replyDTOList);
        return "layout/itemDtl";
    }


    @PostMapping("/itemDtl/{id}")
    public String postreply(@ModelAttribute ReplyDTO replyDTO) {
        replyService.savereply(replyDTO);
        return "redirect:/Clist";
    }

    @GetMapping("/order/{id}")
    public String order(@PathVariable Long id, Model model) {
        ItemDTO itemDTO = itemService.findById(id);
        model.addAttribute("item", itemDTO);
        return "layout/order";
    }

    @GetMapping("/order2/{id}")
    public String order2(@PathVariable Long id, Model model) {
        ItemDTO itemDTO = itemService.findById(id);
        model.addAttribute("item", itemDTO);
        return "layout/order2";
    }

    @GetMapping("/Slist")
    public String search(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        if (keyword == null || keyword.trim().isEmpty()) {
            List<ItemDTO> items = itemService.findAllitem();
            // If keyword is null or empty, display an error message
            model.addAttribute("error", "Please enter a search keyword");
            return "layout/Slist";
        } else {
            // Otherwise, perform the search and display the results
            List<ItemDTO> items = itemService.itemSearchList(keyword);
            model.addAttribute("items", items);
            model.addAttribute("keyword", keyword);
            return "layout/Slist";
        }
    }

    @GetMapping("/admin/item/list")
    public String getItemList(Model model, HttpSession session) {
        String memberType = (String) session.getAttribute("loginType");
        List<ItemDTO> itemList = itemService.findAllitem();
        model.addAttribute("itemList", itemList);
        if(memberType != null && (memberType.equals("ADMIN"))) {
            return "layout/itemList";
        }else {
            return "redirect:/Main";
        }
    }

    @PostMapping("/admin/item/delete")
    public String deleteItem(@RequestParam Long id) {
        itemService.deleteItem(id);
        return "redirect:list";
    }
}

