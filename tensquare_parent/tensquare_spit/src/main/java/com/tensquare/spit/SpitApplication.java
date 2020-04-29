package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import utils.IdWorker;

/**
 * @Description 吐槽微服务
 * @Author Wy005
 * @Date 2020/4/29 14:40
 * @Version 1.0
 **/
@SpringBootApplication
public class SpitApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplication.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }

}
