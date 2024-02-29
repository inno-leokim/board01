package com.brand13.board01.dto;

public record ArticleUpdateDto(
    String title, 
    String content,
    String hashtag
) {
    public static ArticleUpdateDto of(String title, String content, String hashTag){
        return new ArticleUpdateDto(title, content, hashTag);
    }
}
