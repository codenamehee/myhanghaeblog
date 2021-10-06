package com.hanghae.blog.controller;

import com.hanghae.blog.dto.SignupRequestDto;
import com.hanghae.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

//@AllArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입을 위한 API -> 회원가입 버튼 클릭시 작동
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원가입 프론트요청 처리 API
    @PostMapping("user/signup")
    public String registerUser(@Valid SignupRequestDto requestDto, Errors errors, Model model) {
        if(errors.hasErrors()) {
          model.addAttribute("requestDto", requestDto);

          Map<String, String> validatorResult = userService.validateHandling(errors);
          for (String key : validatorResult.keySet()) {
              model.addAttribute(key, validatorResult.get(key));
          }
          return "signup";
        }
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }

    // 로그인 API
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }
}
