package com.hanghae.blog.controller;

import com.hanghae.blog.dto.CommentRequestDto;
import com.hanghae.blog.models.Comment;
import com.hanghae.blog.repository.CommentRepository;
import com.hanghae.blog.security.UserDetailsImpl;
import com.hanghae.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    // 필수 멤버 변수 선언
    private final CommentRepository commentRepository;
    private final CommentService commentService;

//    @GetMapping("/api/comments")
//    public List<Comment> getComment(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        Long userId = userDetails.getUser().getId();
//        return commentService.getComment(userId);
//    }


    // 댓글 조회 api
    @GetMapping("/api/comments")
    public List<Comment> getComments(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getId();
        return commentService.getComment(userId);
    }

    // 게시글 id로 댓글 조회
    @GetMapping("/api/comments/{postId}")
    public List<Comment> getComments(@PathVariable Long postId) {
        return commentService.getComment(postId);
    }

    // 댓글 생성 api
    @PostMapping("/api/comments")
    public boolean createComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails !=null) {
            Long userId = userDetails.getUser().getId();
            commentService.createComment(requestDto, userId);
            return true;
        }
        return false;
    }

    // 댓글 수정
    @PutMapping("/api/comment/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        commentService.update(id, requestDto);
        return id;
    }

    // 댓글 삭제
    @DeleteMapping("/api/comment/{id}")
    public Long deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }

}
