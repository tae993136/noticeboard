package com.sparta.noticeboard.controller;

import com.sparta.noticeboard.dto.PostRequestDto;
import com.sparta.noticeboard.entity.Post;
import com.sparta.noticeboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto){
        return postService.createPost(requestDto);
    }

    @GetMapping("/api/posts")
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
