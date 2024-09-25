package com.example.vectorsearch.model;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.Decimal128;

public class Listing{

    private String _id;
    private String listingUrl;
    private String name;
    private String summary;
    private String space;
    private String description;
    private String neighborhoodOverview;
    private String notes;
    private String transit;
    private String access;
    private String interaction;
    private String houseRules;
    private String propertyType;
    private String roomType;
    private String bedType;
    private int minimumNights;
    private int maximumNights;
    private String cancellationPolicy;
    private LocalDateTime lastScraped;
    private LocalDateTime calendarLastScraped;
    private LocalDateTime firstReview;
    private LocalDateTime lastReview;
    private int accommodates;
    private int bedrooms;
    private int beds;
    private int numberOfReviews;
    private Decimal128 bathrooms;
    private List<String> amenities;
    private Decimal128 price;
    private Decimal128 securityDeposit;
    private Decimal128 cleaningFee;
    private Decimal128 extraPeople;
    private Decimal128 guestsIncluded;
    private Images images;
    private Host host;
    private Address address;
    private Availability availability;
    private ReviewScores reviewScores;
    private List<Review> reviews;

    // Nested Classes for Images, Host, Address, Location, Availability, ReviewScores, Review

    public static class Images {
        private String thumbnailUrl;
        private String mediumUrl;
        private String pictureUrl;
        private String xlPictureUrl;

        // Getters and Setters
    }

    public static class Host {
        private String hostId;
        private String hostUrl;
        private String hostName;
        private String hostLocation;
        private String hostAbout;
        private String hostResponseTime;
        private String hostThumbnailUrl;
        private String hostPictureUrl;
        private boolean hostIsSuperhost;
        private boolean hostHasProfilePic;
        private boolean hostIdentityVerified;
        private int hostListingsCount;
        private List<String> hostVerifications;

        // Getters and Setters
    }

    public static class Address {
        private String street;
        private String suburb;
        private String governmentArea;
        private String market;
        private String country;
        private String countryCode;
        private Location location;

        public static class Location {
            private String type;
            private List<Double> coordinates;
            private boolean isLocationExact;

            // Getters and Setters
        }

        // Getters and Setters
    }

    public static class Availability {
        private int availability30;
        private int availability60;
        private int availability90;
        private int availability365;

        // Getters and Setters
    }

    public static class ReviewScores {
        private int reviewScoresAccuracy;
        private int reviewScoresCleanliness;
        private int reviewScoresCheckin;
        private int reviewScoresCommunication;
        private int reviewScoresLocation;
        private int reviewScoresValue;
        private int reviewScoresRating;

        // Getters and Setters
    }

    public static class Review {
        private String _id;
        private LocalDateTime date;
        private String listingId;
        private String reviewerId;
        private String reviewerName;
        private String comments;

        // Getters and Setters
    }

    public String get_id() {
        return _id;
    }

    public String getListingUrl() {
        return listingUrl;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getSpace() {
        return space;
    }

    public String getDescription() {
        return description;
    }

    public String getNeighborhoodOverview() {
        return neighborhoodOverview;
    }

    public String getNotes() {
        return notes;
    }

    public String getTransit() {
        return transit;
    }

    public String getAccess() {
        return access;
    }

    public String getInteraction() {
        return interaction;
    }

    public String getHouseRules() {
        return houseRules;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getBedType() {
        return bedType;
    }

    public int getMinimumNights() {
        return minimumNights;
    }

    public int getMaximumNights() {
        return maximumNights;
    }

    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public LocalDateTime getLastScraped() {
        return lastScraped;
    }

    public LocalDateTime getCalendarLastScraped() {
        return calendarLastScraped;
    }

    public LocalDateTime getFirstReview() {
        return firstReview;
    }

    public LocalDateTime getLastReview() {
        return lastReview;
    }

    public int getAccommodates() {
        return accommodates;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getBeds() {
        return beds;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public Decimal128 getBathrooms() {
        return bathrooms;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public Decimal128 getPrice() {
        return price;
    }

    public Decimal128 getSecurityDeposit() {
        return securityDeposit;
    }

    public Decimal128 getCleaningFee() {
        return cleaningFee;
    }

    public Decimal128 getExtraPeople() {
        return extraPeople;
    }

    public Decimal128 getGuestsIncluded() {
        return guestsIncluded;
    }

    public Images getImages() {
        return images;
    }

    public Host getHost() {
        return host;
    }

    public Address getAddress() {
        return address;
    }

    public Availability getAvailability() {
        return availability;
    }

    public ReviewScores getReviewScores() {
        return reviewScores;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
