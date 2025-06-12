package com.logcheck.logcheck.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiTenantDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String tenant = TenantContext.getTenant();
        if (tenant == null) {
            // Optional: Log a warning or info
            System.out.println("No tenant set. Using default datasource.");
        }
        return tenant != null ? tenant : "tenant1";  // fallback to default
    }

}
