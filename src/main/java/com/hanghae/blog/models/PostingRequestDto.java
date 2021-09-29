package com.hanghae.blog.models;

import lombok.Getter;

@Getter // 데이터를 조회할 때 필요한 getter 생성자 자동 생성
public class PostingRequestDto {
    private String title;
    private String username;
    private String contents;
}
