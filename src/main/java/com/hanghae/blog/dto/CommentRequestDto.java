package com.hanghae.blog.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long postId;
    private String username;
    private String comment;
    private Long userId;
}
