package com.ruoyi;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RuoyiMqBootrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context=new SpringApplication().run(RuoyiMqBootrap.class,args);
        System.out.println(context.getBean(RocketMQTemplate.class));
    }

}
