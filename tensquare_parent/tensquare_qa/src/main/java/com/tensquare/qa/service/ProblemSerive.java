package com.tensquare.qa.service;

import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author Wy005
 * @Date 2020/4/28 23:08
 * @Version 1.0
 **/
@Service
public class ProblemSerive {

    @Autowired
    private ProblemDao problemDao;
      /**
     * 根据标签ID查询问题列表
     * @param lableId
     * @param page
     * @param size
     * @return
     */
   public Page<Problem> findNewListByLabelId(String lableId,int page,int size){
       PageRequest pageRequest = PageRequest.of(page - 1, size);
       return problemDao.findNewListByLabelId(lableId, pageRequest);
   }

}
