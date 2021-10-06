package com.hanghae.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@ToString
@Setter
@Getter
public class SignupRequestDto {

    // 닉네임은 최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)로 구성하기
    // 비밀번호는 최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패로 만들기
    // -------회원가입 정보 유효성 검사--------
    // notblank : 유효성 검사. null을 허용하지 않고 적어도 white-space가 아닌 문자가 한 개 이상 포함되어야 하는 어노테이션 생성
    @NotBlank(message = "닉네임을 입력해주세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=\\\\S+$).{3,20}",
            message = "닉네임은 알파벳 대소문자와 숫자를 포함하여 최소 3자 ~ 20자 미만으로 입력해주세요.")
    private String username;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "")
    private String password;

    @NotBlank(message = "비밀번호 확인값을 입력해주세요.")
    private String password2;
}
