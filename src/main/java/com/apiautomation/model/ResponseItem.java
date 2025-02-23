package com.apiautomation.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseItem {

    /* 
     * {
     *    "id": "7",
     *    "title": "Apple MacBook Pro 16",
     *    "price": 1849.99,
     *    "discountPercentage": 10,
     *    "stock": 5,
     *    "rating": 5,
     *    "description": "The Apple MacBook Pro 16 is a powerful laptop with a 16-inch Retina display, Intel Core i9 processor, and 1 TB hard disk.",
     *    "category": "electronics"
     */

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
