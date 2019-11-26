package com.example.demo;

import com.example.demo.config.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties(AppProperties.class)
public class ConfigPropertiesDemoApplication {

    public static void main(String[] args) {
        log.debug("ConfigPropertiesDemoApplication.main Start");
        SpringApplication application = new SpringApplication(ConfigPropertiesDemoApplication.class);
        application.setAdditionalProfiles("devdb");
        ConfigurableEnvironment environment = new StandardEnvironment();
        environment.setActiveProfiles("devdb2");
        application.setEnvironment(environment);
        application.run(args);
        log.debug("ConfigPropertiesDemoApplication.main End");
    }
}
