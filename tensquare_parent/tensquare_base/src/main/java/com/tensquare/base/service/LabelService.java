package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import utils.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /**
     * 构建查询条件对象（查询返回符合条件数据，分页条件方法都可用）
     *
     * @param map 标签查询条件
     */
    public Specification<Label> createSpecification(Map map){
       return new Specification<Label>() {
           @Override
           public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
               List<Predicate> list = new ArrayList<Predicate>();
               if(map!=null && !map.isEmpty()){
                   if (!StringUtils.isEmpty(map.get("labelname"))) {
                       Predicate p1 = criteriaBuilder.like(root.get("labelname").as(String.class), "%"+(String) map.get("labelname")+"%");
                       list.add(p1);
                   }
                   if (!StringUtils.isEmpty(map.get("state"))) {
                       Predicate p1 = criteriaBuilder.equal(root.get("state").as(String.class), (String) map.get("state"));
                       list.add(p1);
                   }
                   if (!StringUtils.isEmpty(map.get("recommend"))) {
                       Predicate p1 = criteriaBuilder.equal(root.get("recommend").as(String.class), (String) map.get("recommend"));
                       list.add(p1);
                   }
                   if(list.size()==0){
                       return null;
                   }
                   return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
               }
               return null;
           }
       };
    }

    /**
     * 标签条件查询（无分页）
     * @param map
     * @return
     */
    public List<Label> findSearch(Map map){
        Specification<Label> specification = createSpecification(map);
        return labelDao.findAll(specification);
    }

    /**
     *分页条件查询
     * @param map
     * @param pageable
     * @return
     */
    public Page<Label> findSearch(Map map, Pageable pageable){
        Specification<Label> specification = createSpecification(map);
        return labelDao.findAll(specification, pageable);
    }


}
