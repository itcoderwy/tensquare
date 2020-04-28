package com.tensquare.qa.controller;

import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemSerive;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author Wy005
 * @Date 2020/4/28 23:17
 * @Version 1.0
 **/
@RestController
@CrossOrigin//解决跨域问题
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private ProblemSerive problemSerive;

    /**
     * 根据标签ID查询问题列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/newlist/{labelid}/{page}/{size}",method = RequestMethod.GET)
    public Result findNewListByLabelId(@PathVariable String labelid,@PathVariable int page,@PathVariable int size){
        Page<Problem> pageList = problemSerive.findNewListByLabelId(labelid, page, size);
        PageResult<Problem> result = new PageResult<>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK,"查询成功",result);
    }



}
