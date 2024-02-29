package com.brand13.board01.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brand13.board01.dto.ArticleCommentDto;
import com.brand13.board01.repository.ArticleCommentRepository;
import com.brand13.board01.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {
    
    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;
 
    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComment(Long articleId) {
        return List.of();
    }
}
