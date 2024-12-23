package com.w1101.gamemarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.w1101.gamemarket.mapper")
public class GameMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameMarketApplication.class, args);
    }

}
