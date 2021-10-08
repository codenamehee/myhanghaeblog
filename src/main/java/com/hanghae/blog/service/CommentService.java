package com.hanghae.blog.service;

import com.hanghae.blog.dto.CommentRequestDto;
import com.hanghae.blog.models.Comment;
import com.hanghae.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    // 댓글 조회
    public List<Comment> getComment(Long postId) {
        return commentRepository.findAllByPostIdOrderByCreatedAtDesc(postId);
    }

    // 댓글 작성
    @Transactional
    public Comment createComment(CommentRequestDto requestDto, Long userId) {
        Comment comment = new Comment(requestDto, userId);
        commentRepository.save(comment);
        return comment;
    }

    // 댓글 수정
    @Transactional
    public void update(Long id, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않습니다.")
        );
        comment.update(requestDto);
    }
}
