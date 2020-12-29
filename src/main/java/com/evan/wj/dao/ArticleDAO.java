package com.evan.wj.dao;

import com.evan.wj.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleDAO extends JpaRepository<Article,Integer> {

    List<Article> findAllByType(String type);
    List<Article> findAllByArticlenameLike(String keyword);
}
