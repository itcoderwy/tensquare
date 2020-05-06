package com.tensquare.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import utils.IdWorker;

/**
 * @Description 搜索微服务
 * @Author Wy005
 * @Date 2020/4/30 16:15
 * @Version 1.0
 **/
@SpringBootApplication
public class SearchApplication {
    public static void main(String[] args) {
        //---------------获取本机的ip(InterAddress类)--------------------
        //InterAddress = ip;
        //---------------获取本机的ip(InterAddress类)--------------------
        SpringApplication.run(SearchApplication.class,args);
    }


    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
