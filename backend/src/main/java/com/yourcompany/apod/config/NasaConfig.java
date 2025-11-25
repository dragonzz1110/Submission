package com.yourcompany.apod.config;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class NasaConfig {

    @ConfigProperty(name = "nasa.api.key")
    String apiKey;

    @ConfigProperty(name = "nasa.api.base-url")
    String baseUrl;

    public String getApiKey() {
        return apiKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
