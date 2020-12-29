package com.evan.wj.controller;

import com.evan.wj.pojo.Article;
import com.evan.wj.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.jar.JarOutputStream;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

//    @GetMapping("/api/home")
//    public List<Article> list() throws Exception{
//        return articleService.list();
//    }

    @CrossOrigin
    @PostMapping("/api/home")
    public List<Article> listByType(@RequestBody Article article) throws Exception{
        String type=article.getType();
        return articleService.listByType(type);
    }

    @CrossOrigin
    @PostMapping("/api/release")
    public Article addOrUpdate(@RequestBody Article article, HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setHeader("Access-Control-Allow-Origin","*");
        String type=article.getType();
        System.out.println("信息类型为："+type);
        String category=article.getCategory();
        System.out.println("物品类别为："+category);
        String articlename=article.getArticlename();
        System.out.println("物品名称为："+articlename);
        String content=article.getContent();
        System.out.println("内容描述："+content);
        Date gettime=article.getGettime();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string=format.format(gettime);
        Date d1=format.parse(string);
        String d2=format.format(d1);
        System.out.println("发生时间为："+d2);
        String getplace=article.getGetplace();
        System.out.println("发生地点为："+getplace);

        articleService.addOrUpadate(article);
        return article;
    }

    @PostMapping("/api/profile")
    public void delete(@RequestBody Article article) throws Exception{
        articleService.deleteById(article.getArticleno());
    }

}
