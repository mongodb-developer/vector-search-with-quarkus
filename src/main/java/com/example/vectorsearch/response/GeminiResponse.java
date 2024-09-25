package com.example.vectorsearch.response;


import java.util.List;

public record GeminiResponse(
        List<DataItem> data){

    public record DataItem(
            List<Double> embedding
    ){}
}

