package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName LabelController
 * @Description 标签
 * @Author lenovo
 * @Date 2020/4/26 22:10
 * @Version 1.0
 **/
@RestController
@RequestMapping("/label")
@CrossOrigin  //处理跨域请求的注解
public class LabelController {

    @Autowired
    private LabelService labelService;

    @RequestMapping(value = "", method = RequestMethod.GET)//等同于下方@GetMapping
    //@GetMapping("")
    public Result findAll() {
        List<Label> list = labelService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable String id){
        Label label = labelService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", label);
    }

    @PostMapping
    public Result add(@RequestBody Label label){
        labelService.add(label);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody Label label, @PathVariable String id){
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK,"更新成功");
    }

    /**
     * 根据条件查询
     * @param map 查询条件
     * @return 所有符合条件数据
     */
    @PostMapping("/search")
    public Result findSearch(@RequestBody Map map) {
        List<Label> list = labelService.findSearch(map);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 分页条件查询
     * @param map 查询条件
     * @param page 当前页 注意页数从0开始 0代表第一页
     * @param size 每页显示记录数
     */
    @PostMapping("/search/{page}/{size}")
    public Result findSearch(@RequestBody(required = false) Map map, @PathVariable int page, @PathVariable int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Label> pageData = labelService.findSearch(map, pageable);
        PageResult<Label> pageResult = new PageResult<>(pageData.getTotalElements(), pageData.getContent());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }


}
