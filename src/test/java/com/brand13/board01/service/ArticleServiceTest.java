package com.brand13.board01.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import com.brand13.board01.domain.Article;
import com.brand13.board01.domain.types.SearchType;
import com.brand13.board01.dto.ArticleDto;
import com.brand13.board01.dto.ArticleUpdateDto;
import com.brand13.board01.repository.ArticleRepository;



@DisplayName("비지니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class) //mockito는 이미 제공되므로 plugin을 따로 설치할 필요없다.
class ArticleServiceTest {
    
    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenRequestsArticleList(){

        // Given


        // When
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); // 제목, 본문, ID, 닉네임, 해시태그

        // Then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticles_thenReturnsArticle(){
        // Given

        // When
        ArticleDto article = sut.searchArticle(1L);

        // Then
        assertThat(article).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다.")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSaveArticle() {
        // Given
        ArticleDto dto = ArticleDto.of(LocalDateTime.now(), "keymamo", "title", "content", "#java");
        // BDDMockito.willDoNothing().given(articleRepository.save(any(Article.class))); 
        BDDMockito.given(articleRepository.save(any(Article.class))).willReturn(null);
        
        // When
        sut.saveArticle(dto);

        // Then
        BDDMockito.then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글의 ID와 수정 정보를 입력하면, 게시글을 수정한다.")
    @Test
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdatesArticle() {
        // Given
        
        BDDMockito.given(articleRepository.save(any(Article.class))).willReturn(null);
        
        // When
        sut.updateArticle(1L, ArticleUpdateDto.of("title", "content", "#java"));

        // Then
        BDDMockito.then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글의 ID를 입력하면, 게시글을 삭제한다.")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeletesArticle() {
        // Given
        
        BDDMockito.willDoNothing().given(articleRepository).delete(any(Article.class)); 
        
        // When
        sut.deleteArticle(1L);

        // Then
        BDDMockito.then(articleRepository).should().delete(any(Article.class));
    }
}
