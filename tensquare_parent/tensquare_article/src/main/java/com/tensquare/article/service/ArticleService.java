package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Description TODO
 * @Author Wy005
 * @Date 2020/4/29 9:20
 * @Version 1.0
 **/
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    //在jpa执行修改的时候要加事务否则报错 不执行

    /**
     * 文章点赞功能
     * @param id
     */
    @Transactional
    public void updatethumbup(String id){
        articleDao.updatethumbup(id);
    }

    /**
     * 文章审核功能
     * @param id
     */
    @Transactional
    public void examine(String id){
        //注意这块如果id查不到值是会报错的,但是实际情况下既然是审核就肯定会有id的值
        Article article = articleDao.findById(id).get();
            article.setState("1");
    }
}
