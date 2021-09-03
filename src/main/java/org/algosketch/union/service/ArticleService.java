package org.algosketch.union.service;

import org.algosketch.union.domain.Article;
import org.algosketch.union.repository.ArticleRepository;
import org.algosketch.union.repository.MemoryArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article post(Article article) {
        article.setUser("익명");
        return articleRepository.save(article);
    }

    public List<Article> findArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> findArticle(Long articleId) {
        return articleRepository.findById(articleId);
    }

    public Boolean deleteArticle(Long articleId) {
        return articleRepository.deleteById(articleId);
    }
}
