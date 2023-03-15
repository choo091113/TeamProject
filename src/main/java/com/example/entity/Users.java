package com.example.entity;

import com.example.constant.Role;
import com.example.dto.UsersFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Getter @Setter
@ToString

public class Users {

    @Id /* 프라이머리키 지정 Long */
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long users_num;

    @Column(name="id",nullable = false, length = 30, columnDefinition = "int default 0"  /* not null , 길이, DATE DEFAULT sysdate */)
    private String id;

    @Column(name="pass",nullable = false, length = 30 /* not null , 길이, DATE DEFAULT sysdate */)
    private String pass;

    @Column(name="users_type",nullable = false, length = 20 /* not null , 길이, DATE DEFAULT sysdate */)
    private String users_type;

    @Column(name="phone",nullable = false, length = 30 /* not null , 길이, DATE DEFAULT sysdate */)
    private String phone;

    @Column(name="email",nullable = false, length = 50 /* not null , 길이, DATE DEFAULT sysdate */)
    private String email;

    @Column(name="userprofile", length = 2000 /* not null , 길이, DATE DEFAULT sysdate */)
    private String userprofile;

    @Column(name="del_yn", columnDefinition = "char default 'N'")
    private char del_yn;

    @Column(name="regidate", nullable = false, columnDefinition = "Date default sysdate")
    private LocalDateTime regidate;

    @Enumerated(EnumType.STRING)

    private Role role;


    public static Users createMember(UsersFormDto memberFormDto, PasswordEncoder passwordEncoder) {



        Users users = new Users();

        return users;

    }
}
