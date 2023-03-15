package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class UsersFormDto {

    private Long users_num;
    private String id;

    private String pass;

    private String users_type;

    private String phone;

    private String email;

    private String userprofile;

    private char del_yn;

    private LocalDateTime regidate;

}
