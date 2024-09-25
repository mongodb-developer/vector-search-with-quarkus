package com.example.vectorsearch.gateway;

import com.example.vectorsearch.request.GeminiRequest;
import com.example.vectorsearch.response.GeminiResponse;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface GeminiClient {

    @POST
    GeminiResponse embedding(GeminiRequest request);
}
