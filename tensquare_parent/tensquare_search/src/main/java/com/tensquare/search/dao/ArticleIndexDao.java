package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleIndexDao extends ElasticsearchRepository<Article,String> {

    //根据关键字查询标题，内容中符合条件的数据
    //Page<Article> findByTitleAndContent(String keyword, String keyword1, Pageable pageable);

    Page<Article> findByTitleOrContentLike(String keyword, String keyword1, Pageable pageable);
}
