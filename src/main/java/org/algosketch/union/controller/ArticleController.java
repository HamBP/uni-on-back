package org.algosketch.union.controller;

import org.algosketch.union.domain.Article;
import org.algosketch.union.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public  String home() {
        return "home";
    }

    @GetMapping("articles/new")
    public String newArticle() {
        return "new";
    }

    @PostMapping("articles")
    @ResponseBody
    public String postArticle(ArticleForm form) {
        Article article = new Article();
        article.setUser("익명");
        article.setTitle(form.getTitle());
        article.setContent(form.getContent());

        Article newA = articleService.post(article);

        System.out.println(newA.getContent());

        return "";
    }

    @GetMapping("articles")
    @ResponseBody
    public List<Article> getArticles() {
        return articleService.findArticles();
    }

    @GetMapping("articles/{articleId}")
    @ResponseBody
    public Article getArticle(@PathVariable Long articleId) {
        return articleService.findArticle(articleId).get();
    }

    @DeleteMapping("articles/{articleId}")
    public Article deleteArticle(@PathVariable Long articleId) {
        Optional<Article> result = articleService.findArticle(articleId);
        articleService.deleteArticle(articleId);
        return result.get();
    }
}