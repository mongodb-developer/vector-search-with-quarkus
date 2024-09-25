package com.example.vectorsearch.gateway;

import com.example.vectorsearch.config.GeminiConfig;
import com.example.vectorsearch.request.GeminiRequest;
import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
        var geminiAIGateway = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(geminiAIConfig.getGeminiAIUrl() + "?key=" + geminiAIConfig.getApiKey()))
                .build(GeminiClient.class);

        LOGGER.info("Requesting embeddings for input: {}", input);

        GeminiRequest request = new GeminiRequest(
                new GeminiRequest.Content(List.of(new GeminiRequest.Part(input)))
        );

        var embedding = geminiAIGateway.embedding(request);

        return embedding.data().get(0).embedding();
    }
}
