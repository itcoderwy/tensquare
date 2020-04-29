package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private RedisTemplate redisTemplate;
    /*Spring-data-redis是spring大家族的一部分，提供了在srping应用中通过简单的配置访问 redis服务，
    对reids底层开发包(Jedis,  JRedis, and RJC)进行了高度封装，RedisTemplate 提供了redis各种操作。
*/
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

    /**
     * 根据文章id查询 并使用redis技术做缓存
     * @param id
     * @return
     */
    public Article findById(String id){
        //先在redis里查询是否存在这一个实体 如果存在那么直接返回就ok
        Article article =(Article)redisTemplate.opsForValue().get("article_" + id);
         //要是没有在数据库里面查询出来返回再保存redis里一份
        if(article==null){
            Optional<Article> byId = articleDao.findById(id);
            if(byId.isPresent()){
                article = byId.get();
                redisTemplate.opsForValue().set("article_" + article.getId(),article,1, TimeUnit.DAYS);
            }
        }
        return article;
    }



}
