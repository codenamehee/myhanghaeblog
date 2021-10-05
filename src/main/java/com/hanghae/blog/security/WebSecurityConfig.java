package com.hanghae.blog.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 빈을 한개이상 사용할 것임을 선언하는 어노테이션
@Configuration
// 스프링 security 지원을 가능하게 하는 어노테이션
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // WebSecurityConfig에 내장되어 있는 메소드를 가져다 쓰되 내 마음대로 바꾸어 쓰겠다는 어노테이션
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                //어떤 요청이든 '인증'
                .anyRequest().authenticated()
                .and()
                    //로그인 기능 허용
                    .formLogin()
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    //로그아웃 기능 허용
                    .logout()
                    .permitAll();
    }
}
