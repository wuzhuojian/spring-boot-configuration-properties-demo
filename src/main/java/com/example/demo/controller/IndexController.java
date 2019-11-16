package com.example.demo.controller;

import com.example.demo.config.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class IndexController {

    // Injecting ConfigurationProperties in your Beans
    @Autowired
    private AppProperties appProperties;

    @GetMapping("/")
    public Map<String, String> getAppDetails() {
        log.debug("getAppDetails Start");
        Map<String, String> appDetails = new HashMap<>();
        appDetails.put("name", appProperties.getName());
        appDetails.put("description", appProperties.getDescription());
        log.debug("getAppDetails End");
        return appDetails;
    }
}
