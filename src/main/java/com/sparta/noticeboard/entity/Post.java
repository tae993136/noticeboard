package com.sparta.noticeboard.entity;

import com.sparta.noticeboard.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor

public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String password;

    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }

    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }


}
