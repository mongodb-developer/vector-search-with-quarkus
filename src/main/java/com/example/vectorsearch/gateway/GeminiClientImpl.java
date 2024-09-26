package com.example.vectorsearch.gateway;

import com.example.vectorsearch.config.GeminiConfig;
import com.example.vectorsearch.request.GeminiRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.List;

@ApplicationScoped
public class GeminiClientImpl implements GeminiAIGateway {

    @Inject
    GeminiConfig geminiAIConfig;

    private static final Logger LOGGER = LoggerFactory.getLogger(GeminiClientImpl.class);

    @Override
    public List<Double> getEmbedding(String input) {
        ObjectMapper objectMapper = new ObjectMapper();

        var geminiAIGateway = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(geminiAIConfig.getGeminiAIUrl() + "?key=" + geminiAIConfig.getApiKey()))
                .build(GeminiClient.class);

        LOGGER.info("Requesting embeddings for input: {}", input);

        GeminiRequest request = new GeminiRequest(
                geminiAIConfig.getModel(),
                new GeminiRequest.Content(List.of(new GeminiRequest.Part(input)))
        );
        LOGGER.info("Sending request: {}", request);

        try {
            String jsonRequest = objectMapper.writeValueAsString(request);
            //loggers
            System.out.println("Raw request: " + jsonRequest);
            var embedding = geminiAIGateway.embedding(jsonRequest);
            //loggers
            System.out.println("Raw response: " + embedding);

            return embedding.getData().getFirst().getEmbedding();
        } catch (WebApplicationException e) {
            LOGGER.error("Error from Gemini AI: {}", e.getResponse().readEntity(String.class));
            throw e;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
