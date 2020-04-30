package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author Wy005
 * @Date 2020/4/30 16:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 添加文章
     * @param article
     */
    @PostMapping
    public Result add(@RequestBody Article article){
        articleService.add(article);
        return new Result(true, StatusCode.OK,"添加文章成功");
    }

    /**
     * 根据关键字查询
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/search/{keywords}/{page}/{size}")
    public Result findByKeyword(@PathVariable String keywords,@PathVariable int page,@PathVariable int size){
        PageRequest pageable = PageRequest.of(page - 1, size);
        Page<Article> articles = articleService.findByKeyword(keywords, pageable);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Article>(articles.getTotalElements(),articles.getContent()));
    }

}
