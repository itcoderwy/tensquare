package com.tensquare.article.dao;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ArticleDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {

    //注意这块在写更新的时候a.thumbup+1这块中间不能加空格  否则会不执行
    //注意把数据库中的字段初始值设为0 int数据类型
    @Query("update  Article a set a.thumbup = a.thumbup+1 where a.id = ?1")
    @Modifying
    void updatethumbup(String id);
}
