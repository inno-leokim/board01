package com.brand13.board01.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("/articles")
@Controller
public class ArticleController{
    
    @GetMapping
    public String articles(ModelMap map) {
        map.addAttribute("articles", List.of());
        return "articles/index";
    }

    @GetMapping("{articleId}")
    public String article(@PathVariable Long articleId, ModelMap map) {
        map.addAttribute("article", "article"); //TODO: 구현할 때 실제 데이터 넘겨줄 것
        map.addAttribute("articleComments", List.of());
        
        
        return "articles/detail";
    }
    
    
}
