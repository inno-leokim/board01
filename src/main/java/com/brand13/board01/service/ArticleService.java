package com.brand13.board01.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brand13.board01.domain.types.SearchType;
import com.brand13.board01.dto.ArticleDto;
import com.brand13.board01.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {
    
    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType title, String string) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(Long l){
        return null;
    }
}
