package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class ThymeleafController {




    @GetMapping(value = "layout/emailsign")
    public String emailsign() {
        return "layout/emailsign.html";
    }

    @GetMapping(value = "layout/emailsign1")
    public String emailsign1() {
        return "layout/emailsign1.html";
    }

    @GetMapping(value = "layout/find")
    public String find() {
        return "layout/find.html";
    }

    @GetMapping(value = "layout/instructor")
    public String instructor() {
        return "layout/instructor.html";
    }


    @GetMapping(value = "layout/lecture")
    public String lecture() {
        return "layout/lecture.html";
    }

    @GetMapping(value = "layout/myPage_cash")
    public String myPage_cash() {
        return "layout/myPage_cash.html";
    }

    @GetMapping(value = "layout/myPage_charges")
    public String myPage_charges() {
        return "layout/myPage_charges.html";
    }

    @GetMapping(value = "layout/myPage_like")
    public String myPage_like() {
        return "layout/myPage_like.html";
    }

    @GetMapping(value = "layout/myPage_orderList")
    public String myPage_orderList() {
        return "layout/myPage_orderlist.html";
    }

    @GetMapping(value = "layout/order")
    public String order() {
        return "layout/order.html";
    }

    @GetMapping(value = "layout/order2")
    public String order2() {
        return "layout/order2.html";
    }

    @GetMapping(value = "layout/Proseller")
    public String Proseller() {
        return "layout/Proseller.html";
    }

    @GetMapping(value = "layout/seller_myService")
    public String seller_myService() {
        return "layout/seller_myService.html";
    }

    @GetMapping(value = "layout/seller_orderList")
    public String seller_orderList() {
        return "layout/seller_orderList.html";
    }

    @GetMapping(value = "layout/seller_revenue")
    public String seller_revenue() {
        return "layout/seller_revenue.html";
    }


    @GetMapping(value = "layout/signpage")
    public String signpage() {
        return "layout/signpage.html";
    }

    @GetMapping(value = "layout/signPro")
    public String signPro() {
        return "layout/signPro.html";
    }

}

