package com.brand13.board01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.brand13.board01.domain.Article;



@RepositoryRestResource
public interface ArticleRepository extends 
    JpaRepository<Article, Long>,
    QuerydslPredicateExecutor<Article> //모든 필드에 대한 검색기능을 추가
    // QuerydslBinderCustomizer<QArticle>
{}
