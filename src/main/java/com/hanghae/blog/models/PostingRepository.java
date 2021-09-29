package com.hanghae.blog.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// ID가 Long 타입인 repository 생성.
public interface PostingRepository extends JpaRepository<Posting, Long> {
    // 리스트 형태인 posting 클래스를 모두 찾은 뒤 생성날짜를 기준으로 내림차순 정렬
    List<Posting> findAllByOrderByCreatedAtDesc();
}
