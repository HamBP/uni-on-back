package org.algosketch.union.repository;

import org.algosketch.union.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryArticleRepository implements ArticleRepository {
    private static Map<Long, Article> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Article save(Article article) {
        article.setId(++sequence);
        store.put(article.getId(), article);
        return article;
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Article> findByTitle(String title) {
        return store.values().stream()
                .filter(article -> article.getTitle().equals(title))
                .findAny();
    }

    @Override
    public List<Article> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Boolean deleteById(Long id) {
        store.remove(id);

        return true;
    }
}
