package org.algosketch.union.repository;

import org.algosketch.union.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {
    Article save(Article article);
    Optional<Article> findById(Long id);
    Optional<Article> findByTitle(String title);
    List<Article> findAll();
    Boolean deleteById(Long id);
}
