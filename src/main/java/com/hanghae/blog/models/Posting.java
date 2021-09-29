package com.hanghae.blog.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor // 기본 생성자 자동으로 생성하게 하기
@Getter // getter 자동으로 생성하게 하기
@Entity // 데이터베이스의 테이블과 연계되는 class임을 알려주기
public class Posting extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO) // Id가 자동으로 생성 및 증가
    @Id
    private Long id;

    // 데이터베이스의 칼럼에 필수적으로 기입될 정보들 추가
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Posting(String title, String username, String contents) {
        this.title = title;
        this.username = username;
        this.contents = contents;
    }

    // PostingRequestDto클래스의 requestdto를 매개변수로 Posting 클래스의 객체를 생성해주는 생성자 생성
    public Posting(PostingRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    // 게시글 수정을 위한 update 메소드 추가
    public void update(PostingRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
