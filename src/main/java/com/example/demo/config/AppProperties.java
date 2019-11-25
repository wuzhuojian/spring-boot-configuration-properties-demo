package com.example.demo.config;

import com.example.demo.model.Color;
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
    private final String name;
    private final String description;
    private final String uploadDir;
    private final List<Security> security;

    private final List<Color> colors;

    @ConstructorBinding
    private AppProperties(String name, String description, String uploadDir, List<Security> security, List<Color> colors) {
        log.debug("AppProperties.AppProperties Start");
        this.name = name;
        this.description = description;
        this.uploadDir = uploadDir;
        this.security = security;
        this.colors = colors;
        log.debug("AppProperties.AppProperties End");
    }
}

