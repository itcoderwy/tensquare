package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.IdWorker;

import java.util.List;

/**
 * @ClassName LabelService
 * @Description TODO
 * @Author lenovo
 * @Date 2020/4/26 22:08
 * @Version 1.0
 **/
@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public void add(Label label){
        label.setId(idWorker.nextId()+""); //注意要设置id
        labelDao.save(label);
    }

    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    public void update(Label label){
        labelDao.save(label);
    }

    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    public List<Label> findAll(){
        return  labelDao.findAll();
    }





}
