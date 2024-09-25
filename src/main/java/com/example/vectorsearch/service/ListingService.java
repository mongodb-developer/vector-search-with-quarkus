package com.example.vectorsearch.service;

import com.example.vectorsearch.gateway.GeminiClient;
import com.example.vectorsearch.gateway.GeminiClientImpl;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.Document;


import java.util.List;

@ApplicationScoped
public class ListingService {

    @Inject
    MongoClient mongoClient;

    @Inject
    GeminiClientImpl geminiClient;

    public void generateAndStoreEmbeddings() {
        MongoCollection<Document> listingsCollection = mongoClient.getDatabase("sample_airbnb").getCollection("listingsAndReviews");

        for (Document doc : listingsCollection.find()) {
            String description = doc.getString("description");
            List<Double> embeddings = geminiClient.getEmbedding(description);

            doc.put("descriptionEmbeddings", embeddings);
            listingsCollection.replaceOne(new Document("_id", doc.getObjectId("_id")), doc);
        }
    }
}

