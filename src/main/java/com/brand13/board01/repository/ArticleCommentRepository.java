package com.brand13.board01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.brand13.board01.domain.Article;
import com.brand13.board01.domain.ArticleComment;

@RepositoryRestResource
public interface ArticleCommentRepository extends 
        JpaRepository<ArticleComment, Long>,
        QuerydslPredicateExecutor<ArticleComment> //모든 필드에 대한 검색기능을 추가
{
}
