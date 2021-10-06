package com.hanghae.blog.annotation;

import com.hanghae.blog.dto.SignupRequestDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PWValidator implements ConstraintValidator<IfExcludeId, String> {



    @Override
    public boolean isValid(String username, String password, ConstraintValidatorContext context) {

        // username과 password의 값을 비교하여
        // password값 안에 username 값과 같은 값이 포함되어 있는지 확인하기

        if(password.contains(username)) {
            return false;
        } else {
            return true;
        }
    }
}
