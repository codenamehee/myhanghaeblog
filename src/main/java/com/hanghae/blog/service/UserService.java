package com.hanghae.blog.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hanghae.blog.dto.SignupRequestDto;
import com.hanghae.blog.models.User;
import com.hanghae.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    // 회원가입 시 유효성 체크
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for(FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    // 회원가입 비즈니스 로직, void -> user로 리턴 타입 변경
    public void registerUser(SignupRequestDto requestDto) {

        //nickname 중복 확인
        String username = requestDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 닉네임이 존재합니다.");
        }

        String password = requestDto.getPassword();
        String password2 = requestDto.getPassword2();

        // password 일치 여부 확인 & 암호화
        if(password2.equals(password)) {
            password = passwordEncoder.encode(requestDto.getPassword2());
        }

        User user = new User(username, password);
        userRepository.save(user);
//        return user;
    }

}
