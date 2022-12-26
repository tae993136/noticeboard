package com.sparta.noticeboard.service;

import com.sparta.noticeboard.dto.PostRequestDto;
import com.sparta.noticeboard.entity.Post;
import com.sparta.noticeboard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Post createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return post;
    }


    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @org.springframework.transaction.annotation.Transactional
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post.getId();
    }

    @org.springframework.transaction.annotation.Transactional
    public Long deletePost(Long id) {
        postRepository.deleteById(id);
        return id;
    }
}
