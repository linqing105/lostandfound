package com.evan.wj.service;

import com.evan.wj.dao.ArticleDAO;
import com.evan.wj.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleDAO articleDAO;

    //查找所有数据
    public List<Article> list(){
        Sort sort= Sort.by(Sort.Direction.DESC,"id");
        return articleDAO.findAll(sort);
    }
    //增加或更新数据
    public void addOrUpadate(Article article){
        articleDAO.save(article);
    }
    //通过id删除数据
    public void deleteById(int id){
        articleDAO.deleteById(id);
    }

    //通过分类查找数据
    public List<Article> listByType(String type){
        return articleDAO.findAllByType(type);
    }
}
