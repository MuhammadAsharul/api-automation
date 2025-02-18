package com.apiautomation.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseItem {
    @JsonProperty("id")
    public String id;

    @JsonProperty("title")
    public String title;

    @JsonProperty("price")
    public int price;

    @JsonProperty("discountPercentage")
    public int discountPercentage;

    @JsonProperty("stock")
    public int stock;

    @JsonProperty("rating")
    public int rating;

    @JsonProperty("description")
    public String description;

    @JsonProperty("category")
    public String category;


}
