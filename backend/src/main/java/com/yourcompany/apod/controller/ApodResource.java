package com.yourcompany.apod.controller;

import com.yourcompany.apod.exception.ApiException;
import com.yourcompany.apod.model.ApodDto;
import com.yourcompany.apod.service.ApodService;
import com.yourcompany.apod.util.DateUtil;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;

@Path("/api/apod")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApodResource {

    @Inject
    ApodService apodService;

    /**
     * GET /api/apod/today
     */
    @GET
    @Path("/today")
    public ApodDto getToday() {
        return apodService.getTodayApod();
    }

    /**
     * GET /api/apod/date/{yyyy-MM-dd}
     */
    @GET
    @Path("/date/{date}")
    public ApodDto getByDate(@PathParam("date") String date) {
        LocalDate parsed = DateUtil.parse(date);

        // NASA APOD started in 1995-06-16, simple validation to avoid useless calls
        if (parsed.isBefore(LocalDate.of(1995, 6, 16))) {
            throw new ApiException(Response.Status.BAD_REQUEST.getStatusCode(),
                    "APOD is only available from 1995-06-16 onwards");
        }

        if (parsed.isAfter(LocalDate.now())) {
            throw new ApiException(Response.Status.BAD_REQUEST.getStatusCode(),
                    "APOD is not available for future dates");
        }

        return apodService.getApodByDate(parsed);
    }
}
