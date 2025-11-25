package com.yourcompany.apod.service;

import com.yourcompany.apod.model.ApodDto;
import com.yourcompany.apod.model.ApodMediaType;
import com.yourcompany.apod.model.ApodNasaResponse;
import com.yourcompany.apod.repository.ApodRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;

@ApplicationScoped
public class ApodService {

    @Inject
    ApodRepository apodRepository;

    public ApodDto getTodayApod() {
        LocalDate today = LocalDate.now();
        return getApodByDate(today);
    }

    public ApodDto getApodByDate(LocalDate date) {
        ApodNasaResponse response = apodRepository.getApodByDate(date);
        return mapToDto(response);
    }

    private ApodDto mapToDto(ApodNasaResponse response) {
        ApodMediaType mediaType = ApodMediaType.fromString(response.getMediaType());

        return new ApodDto(
                response.getDate(),
                response.getTitle(),
                response.getExplanation(),
                response.getMediaUrl(),
                response.getHdMediaUrl(),
                response.getThumbnailUrl(),
                mediaType,
                response.getCopyright()
        );
    }
}
