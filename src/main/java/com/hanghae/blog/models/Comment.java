package com.hanghae.blog.models;

import com.hanghae.blog.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Long userId;

    public Comment(Long postId, String username, String comment) {
        this.postId = postId;
        this.username = username;
        this.comment = comment;
    }

    public Comment(CommentRequestDto requestDto) {
        this.postId = requestDto.getPostId();
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
    }

    public Comment(CommentRequestDto requestDto, Long userId) {
        this.postId = requestDto.getPostId();
        this.comment = requestDto.getComment();
        this.username = requestDto.getUsername();
        this.userId = userId;
    }

    public Comment(CommentRequestDto requestDto, Long userId, String Comment) {
        this.postId = requestDto.getPostId();
        this.comment = comment;
        this.username = requestDto.getUsername();
        this.userId = userId;
    }

    public void update(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
    }

}
