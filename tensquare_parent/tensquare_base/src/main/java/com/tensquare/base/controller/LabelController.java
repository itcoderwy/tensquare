package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName LabelController
 * @Description TODO
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


}
