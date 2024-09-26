package com.example.vectorsearch.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GeminiResponse {

    @JsonProperty("data")
    private List<DataItem> data;

    public List<DataItem> getData() {
        return data;
    }

    public static class DataItem {
        @JsonProperty("embedding")
        private List<Double> embedding;

        public List<Double> getEmbedding() {
            return embedding;
        }
    }
}
