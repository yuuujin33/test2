package com.mysite.test2.article;

import com.mysite.test2.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        List<Article> articleList = this.articleRepository.findAll();
        return articleList;
    }

    public void create(String subject, String content, SiteUser user) {
        Article article = new Article();
        article.setSubject(subject);
        article.setContent(content);
        article.setCreateDate(LocalDateTime.now());
        article.setAuthor(user);
        this.articleRepository.save(article);
    }

    public Article getArticle(Integer id) {
       Optional<Article> article = this.articleRepository.findById(id);
       return article.get();
    }

    public void modify (Article article, String subject, String content) {
        article.setSubject(subject);
        article.setContent(content);
        article.setModifyDate(LocalDateTime.now());
        this.articleRepository.save(article);
    }

    public void delete(Article article) {
        this.articleRepository.delete(article);
    }
}
