package com.tensquare.article.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author Wy005
 * @Date 2020/4/29 9:18
 * @Version 1.0
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 文章点赞功能
     * @param id
     * @return
     */
    @PostMapping("/updatethumbup/{id}")
    public Result updatethumbup(@PathVariable String id){
        articleService.updatethumbup(id);
        return new Result(true, StatusCode.OK,"点赞数增加成功");
    }

    /**
     * 文章审核功能
     * @param id
     * @return
     */
    @PutMapping("/examine/{id}")
    public Result examine(@PathVariable String id){
        articleService.examine(id);
        return new Result(true,StatusCode.OK,"文章审核通过");
    }

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable String id){
        Article article = articleService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",article);
    }

}
