package com.example.demo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Security {
    private String username;
    private String password;
    private List<String> roles = new ArrayList<>();
    private boolean enabled;
    private Map<String, String> permissions = new HashMap<>();
}
