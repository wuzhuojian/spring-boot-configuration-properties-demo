package com.example.demo.config;

import com.example.demo.model.Security;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@Getter
@Slf4j
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private String name;
    private String description;
    private String uploadDir;
    private final List<Security> security;

    @ConstructorBinding
    private AppProperties(String name, String description, String uploadDir, List<Security> security) {
        log.debug("AppProperties Start");
        this.name = name;
        this.description = description;
        this.uploadDir = uploadDir;
        this.security = security;
        log.debug("AppProperties End");
    }
}

