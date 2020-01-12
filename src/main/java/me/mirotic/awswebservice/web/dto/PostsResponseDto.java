package me.mirotic.awswebservice.web.dto;

import lombok.Getter;
import me.mirotic.awswebservice.domain.posts.Posts;


@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}