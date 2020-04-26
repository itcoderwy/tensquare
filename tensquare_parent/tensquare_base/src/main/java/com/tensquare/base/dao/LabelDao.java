package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName LabelDao
 * @Description TODO
 * @Author lenovo
 * @Date 2020/4/26 22:04
 * @Version 1.0
 **/
public interface LabelDao extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label> {

/*
    JpaSpecificationExecutor<Label>  条件查询接口
*/

}
