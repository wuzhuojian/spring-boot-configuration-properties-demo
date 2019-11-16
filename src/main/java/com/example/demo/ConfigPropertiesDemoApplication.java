package com.example.demo;

import com.example.demo.config.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties(AppProperties.class)
public class ConfigPropertiesDemoApplication {

    public static void main(String[] args) {
        log.debug("ConfigPropertiesDemoApplication.main Start");
        SpringApplication.run(ConfigPropertiesDemoApplication.class, args);
        log.debug("ConfigPropertiesDemoApplication.main End");
    }
}
