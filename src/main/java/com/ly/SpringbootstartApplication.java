package com.ly;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

//扫描mybatis mapper的包路径
@MapperScan(basePackages = "com.ly.mapper")
//扫描所需要的包，包含一些自用的工具类包所在的路径
@ComponentScan(basePackages = {"com.ly","org.n3r.idworker"})
//开启定时任务
@EnableScheduling
//开启异步调用方法
@EnableAsync
public class SpringbootstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstartApplication.class, args);
	}

}

