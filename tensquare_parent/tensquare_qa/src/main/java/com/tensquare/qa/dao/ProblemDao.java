package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 问答微服务数据访问接口
 */
public interface ProblemDao extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {

    @Query("SELECT p from Problem p  where id in(SELECT problemid from Pl where labelid=?1) ORDER BY replytime DESC")
    public Page<Problem> findNewListByLabelId(String labelId,Pageable pageable);


}
