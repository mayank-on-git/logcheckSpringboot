package com.logcheck.logcheck.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@ConfigurationProperties(prefix = "tenant.datasource")
public class MultiTenantProperties {

    private Map<String, DataSourceProperty> tenants = new HashMap<>();

    public Map<String, DataSourceProperty> getTenants() {
        return tenants;
    }

    public void setTenants(Map<String, DataSourceProperty> tenants) {
        this.tenants = tenants;
    }

    public static class DataSourceProperty {
        private String url;
        private String username;
        private String password;

        // Getters and Setters
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
