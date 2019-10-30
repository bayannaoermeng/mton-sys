package com.ruoyi;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.time.Duration;
import java.time.Instant;

/**
 * 启动程序
 *
 * @author cui
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.marathon","com.ruoyi"})
@MapperScan({"com.marathon.mapper"})
public class MrtonApplication {

    private static final Logger log = LoggerFactory.getLogger(MrtonApplication.class);

    public static void main(String[] args) {
        Instant inst1 = Instant.now();
        SpringApplication.run(MrtonApplication.class, args);
        log.info("Mrton系统启动成功!耗时:{}秒 ::", Duration.between(inst1, Instant.now()).getSeconds());
    }

}