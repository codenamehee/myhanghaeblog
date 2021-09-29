package com.hanghae.blog.controller;

import com.hanghae.blog.models.Posting;
import com.hanghae.blog.models.PostingRepository;
import com.hanghae.blog.models.PostingRequestDto;
import com.hanghae.blog.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostingController {

    private final PostingRepository postingRepository;
    private final PostingService postingService;

    // 게시글 생성 api
    @PostMapping("/api/postings")
    public Posting createPosting(@RequestBody PostingRequestDto requestDto) {
        // Posting 클래스의 새로운 객체 생성
        Posting posting = new Posting(requestDto);
        return postingRepository.save(posting);
    }

    // 게시글 전체 조회 api
    @GetMapping("/api/postings")
    public List<Posting> getPostings() {
        return postingRepository.findAllByOrderByCreatedAtDesc();
    }

    //    게시글 상세 조회 api
    @GetMapping("/api/postings/{id}")
    public Posting getDetailPosting(@PathVariable Long id) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        return posting;
    }

    // 게시글 삭제 api
    @DeleteMapping("/api/postings/{id}")
    public Long deletePosting(@PathVariable Long id) {
        postingRepository.deleteById(id);
        return id;
    }

    // 게시글 변경 api
    @PutMapping("/api/postings/{id}")
    public Long updatePosting(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        postingService.update(id, requestDto);
        return id;
    }
}
