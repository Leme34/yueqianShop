package com.lee.yueqian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lee.yueqian.dao")
public class YueqianApplication {

	public static void main(String[] args) {
		SpringApplication.run(YueqianApplication.class, args);
	}
}
