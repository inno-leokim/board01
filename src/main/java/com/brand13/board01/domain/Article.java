package com.brand13.board01.domain;


import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Table(indexes = { // 서칭이 빨라지게끔 인덱스를 걸어준다.
    @Index(columnList = "title"),
    @Index(columnList = "hashtag"),
    @Index(columnList = "createdAt"),
    @Index(columnList = "createdBy")
})
@Entity
public class Article extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Setter를 각각 준다.
    @Setter 
    @Column(nullable = false) 
    private String title; // 제목

    @Setter
    @Column(nullable = false, length = 10000) 
    private String content; // 내용
    
    @Setter 
    @Column(name = "hashtag")
    private String hashTag; // 해시태그

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    // 생성자 대신 builder 방식이 적용되는지 알아보자.

    protected Article() {}

    private Article(String title, String content, String hashTag){
        this.title = title;
        this.content =content;
        this.hashTag = hashTag;
    }

    // factory method (new 없이 생성가능. builder와 비슷)
    public static Article of(String title, String content, String haString){
        return new Article(title, content, haString);
    }

    // lombok 기능. 동등성 검사
    @Override
    public boolean equals(Object o) {
        // if (this == o) return true;
        // if (!(o instanceof Article)) return false;

        // Article article = (Article) o;

        // return id != null && id.equals(article.id);


        // pattern 방식
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;

        return id != null && id.equals(article.id); //동등성 검사 전, 영속화 되지 않은 entity의 id값이 null이면 안됨.동등성 검사의 의미가 없어짐.
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
