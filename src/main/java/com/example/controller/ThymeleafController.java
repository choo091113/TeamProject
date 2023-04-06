package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class ThymeleafController {




    @GetMapping(value = "/emailsign")
    public String emailsign() {
        return "layout/emailsign.html";
    }

    @GetMapping(value = "/emailsign1")
    public String emailsign1() {
        return "layout/emailsign1.html";
    }

    @GetMapping(value = "/find")
    public String find() {
        return "layout/find.html";
    }

    @GetMapping(value = "/instructor")
    public String instructor() {
        return "layout/instructor.html";
    }


    @GetMapping(value = "/lecture")
    public String lecture() {
        return "layout/lecture.html";
    }

    @GetMapping(value = "/Proseller")
    public String Proseller() {
        return "layout/Proseller.html";
    }

    @GetMapping(value = "/seller_myService")
    public String seller_myService() {
        return "layout/seller_myService.html";
    }

    @GetMapping(value = "/seller_orderList")
    public String seller_orderList() {
        return "layout/seller_orderList.html";
    }

    @GetMapping(value = "/seller_revenue")
    public String seller_revenue() {
        return "layout/seller_revenue.html";
    }

}

