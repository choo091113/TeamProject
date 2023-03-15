package com.example.service;

import com.example.entity.Users;
import com.example.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor

public class UsersService {

    private final UsersRepository usersRepository;

    public Users saveMember(Users users) {
        validateDuplicateMember(users);
        return usersRepository.save(users);

    }

    private void validateDuplicateMember(Users users) {
        Users findUsers = usersRepository.findByEmail(users.getEmail());
        if(findUsers != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
