package com.yourcompany.apod.repository;

import com.yourcompany.apod.client.NasaApodClient;
import com.yourcompany.apod.config.NasaConfig;
import com.yourcompany.apod.exception.ApiException;
import com.yourcompany.apod.model.ApodNasaResponse;
import com.yourcompany.apod.util.DateUtil;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDate;

@ApplicationScoped
public class ApodRepository {

    @Inject
    @RestClient
    NasaApodClient nasaApodClient;

    @Inject
    NasaConfig nasaConfig;

    /**
     * Cached APOD by date.
     * Cache name configured in application.properties as "apod-cache".
     */
    @CacheResult(cacheName = "apod-cache")
    public ApodNasaResponse getApodByDate(LocalDate date) {
        try {
            String formatted = DateUtil.format(date);
            return nasaApodClient.getApod(
                    nasaConfig.getApiKey(),
                    formatted,
                    Boolean.TRUE,
                    Boolean.TRUE
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ApiException(502, "Failed to fetch data from NASA APOD API", ex);
        }
    }
}
