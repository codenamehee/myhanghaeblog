package com.hanghae.blog.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // 일괄적으로 Get 함수를 만들어줌
@NoArgsConstructor // 기본 생성자를 자동으로 만들어줌
@Entity // DB 테이블임을 선언
public class User {

    // 아이디가 자동으로 생성되고 증가한다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    // user 클래스에서만 쓸 수 있는 멤버 변수
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    public User(String nickname, String password){
        this.nickname = nickname;
        this.password = password;


//    @Column(nullable = false)
//    private String password2;

    // 인스턴스 생성시 빠뜨리면 안되는 멤버 변수들을 생성자를 통해 정의하여 인스턴스 생성시 해당 객체가
    // 생성자에 정의된 멤버 변수들을 가지고 있도록 하는 것
//    public User(String nickname, String password) {
//        this.nickname = nickname;
//        this.password = password;
//    }

//    public User(String nickname, String password, String password2) {
//        this.nickname = nickname;
//        this.password = password;
//        this.password2 = password2;
    }
}
