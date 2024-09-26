package com.example.vectorsearch.service;

import com.example.vectorsearch.gateway.GeminiClientImpl;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.search.FieldSearchPath;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.Document;
import org.bson.conversions.Bson;


import java.util.List;

import static com.mongodb.client.model.Aggregates.vectorSearch;
import static com.mongodb.client.model.search.SearchPath.fieldPath;
import static java.util.Arrays.asList;

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

    public void performVectorSearch(String query){
        MongoCollection<Document> collection = mongoClient.getDatabase("sample_airbnb").getCollection("listingsAndReviews");

        List<Double> queryEmbeddings = geminiClient.getEmbedding(query);
        String indexName = "vector_index";
        FieldSearchPath fieldSearchPath = fieldPath("descriptionEmbeddings");
        int numCandidates = 150;
        int limit = 10;

        List<Bson> pipeline = asList(
                vectorSearch(
                        fieldSearchPath,
                        queryEmbeddings,
                        indexName,
                        numCandidates,
                        limit));

        collection.aggregate(pipeline)
                .forEach(doc -> System.out.println(doc.toJson()));
    }
}

