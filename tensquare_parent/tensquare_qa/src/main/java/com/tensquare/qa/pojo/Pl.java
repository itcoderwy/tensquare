package com.tensquare.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description 问答微服务模块实体类
 * @Author Wy005
 * @Date 2020/4/28 22:12
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_pl")
@IdClass(Pl.class)//复合联合主键
public class Pl implements Serializable {
    @Id
    private String problemid;
    @Id
    private String labelid;

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }
}
