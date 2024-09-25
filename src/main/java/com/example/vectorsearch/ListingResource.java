package com.example.vectorsearch;


import com.example.vectorsearch.service.ListingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;


@Path("/api/listings")
public class ListingResource {

    @Inject
    ListingService listingService;

    @GET
    @Path("/generate-embeddings")
    public Response generateEmbeddings() {
        listingService.generateAndStoreEmbeddings();
        return Response.ok("Embeddings generated and stored").build();
    }

    @GET
    @Path("/perform-vector-search")
    public Response performVectorSearch() {

        return Response.ok("Vector search result").build();
    }
}

