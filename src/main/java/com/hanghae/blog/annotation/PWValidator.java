package com.hanghae.blog.annotation;

import com.hanghae.blog.dto.SignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.RowSet;
import javax.swing.*;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class PWValidator implements ConstraintValidator<IfExcludeId, String> {

    private final SignupRequestDto requestDto;



    @Override
    public void initialize(IfExcludeId constraintAnnotation) {
    }

    // isvalid의 매개변수
    // String username : HTML form 태그에서 사용자로부터 입력받은 값
    // ConstraintValidatorContext context : 어노테이션에서 정의한 오류메시지 대신 추가적인 에러메시지를 주거나 다른 데이터를
    // 넣기 위해 사용되는 인터페이스
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        String nickname = requestDto.getUsername();
        // password가 username을 포함하고 있으면 false return하기
        return !password.contains(nickname);
    }

//    @Override
//    public boolean isValid(SignupRequestDto requestDto, ConstraintValidatorContext context) {
//
//        boolean result;
//
//        String username = requestDto.getUsername();
//        String password = requestDto.getPassword();
//
//        // username과 password의 값을 비교하여
//        // password값 안에 username 값과 같은 값이 포함되어 있는지 확인하기
//
//        result = !password.contains(username);
//        return result;
//    }
}
