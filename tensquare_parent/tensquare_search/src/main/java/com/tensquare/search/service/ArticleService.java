package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleIndexDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import utils.IdWorker;

/**
 * @Description TODO
 * @Author Wy005
 * @Date 2020/4/30 16:45
 * @Version 1.0
 **/
@Service
public class ArticleService {
    @Autowired
    private ArticleIndexDao articleIndexDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 添加文章
     * @param article
     */
    public void add(Article article){
        article.setId(idWorker.nextId()+"");
        articleIndexDao.save(article);
    }

    /**
     * 根据关键字查询
     * @param keywords
     * @param pageable
     * @return
     */
    public Page<Article> findByKeyword(String keywords, Pageable pageable){
        Page<Article> articles = articleIndexDao.findByTitleOrContentLike(keywords, keywords, pageable);
        return articles;
    }
}
