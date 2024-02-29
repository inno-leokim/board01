package com.brand13.board01.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.brand13.board01.config.JpaConfig;
import com.brand13.board01.domain.Article;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

@Disabled("테스트제외")
@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class) //Audit을 넣기 위해서 추가한다.
@DataJpaTest
class JpaRepositoryTest {
    
    private ArticleRepository articleRepository;
    private ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
        @Autowired ArticleRepository articleRepository,
        @Autowired ArticleCommentRepository articleCommentRepository
    ){
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_when_then(){
        //given
        
        //when
        List<Article> articles = articleRepository.findAll();
        //then
        assertThat(articles)
            .isNotNull()
            .hasSize(123);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_then(){
        //given
        long previousCount = articleRepository.count();
        //when
        articleRepository.saveAndFlush(Article.of("new article", "new content", "#spring"));
        //then
        assertThat(articleRepository.count())
            .isEqualTo(previousCount + 1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine() {
        Article article = articleRepository.findById(1L).orElseThrow();
        String updateHashTag = "#springboot";
        article.setHashTag(updateHashTag);

        Article saveArticle = articleRepository.saveAndFlush(article);

        assertThat(saveArticle).hasFieldOrPropertyWithValue("hashtag", updateHashTag);
    }

    // @DisplayName("delete 테스트")
    // @Test
    
}
