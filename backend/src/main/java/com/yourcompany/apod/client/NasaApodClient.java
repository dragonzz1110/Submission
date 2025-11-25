package com.yourcompany.apod.client;

import com.yourcompany.apod.model.ApodNasaResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/")
@RegisterRestClient(configKey = "nasa-apod")
public interface NasaApodClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    ApodNasaResponse getApod(
            @QueryParam("api_key") String apiKey,
            @QueryParam("date") String date,
            @QueryParam("thumbs") Boolean thumbs,
            @QueryParam("hd") Boolean hd
    );
}
