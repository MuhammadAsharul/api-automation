package com.apiautomation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseObject {
    // {
    //     "id": "7",
    //     "name": "Apple MacBook Pro 16",
    //     "data": {
    //        "year": 2019,
    //        "price": 1849.99,
    //        "CPU model": "Intel Core i9",
    //        "Hard disk size": "1 TB"
    //     },
    //     "createdAt": "2022-11-21T20:06:23.986Z"
    //  }

//     [
//    {
//       "id": "3",
//       "name": "Apple iPhone 12 Pro Max",
//       "data": {
//          "color": "Cloudy White",
//          "capacity GB": 512
//       }
//    },
//    {
//       "id": "5",
//       "name": "Samsung Galaxy Z Fold2",
//       "data": {
//          "price": 689.99,
//          "color": "Brown"
//       }
//    },
//    {
//       "id": "10",
//       "name": "Apple iPad Mini 5th Gen",
//       "data": {
//          "Capacity": "64 GB",
//          "Screen size": 7.9
//       }
//    }
//     ]

    @JsonProperty("id")
    public int id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("data")
    public DataItem dataItem;

    @JsonProperty("createdAt")
    public String createdAt;

    public static class DataItem{
        @JsonProperty("year")
        public int year;

        @JsonProperty("price")
        public int price;

        @JsonProperty("CPU model")
        public String cPUModel;

        @JsonProperty("Hard disk size")
        public String hardDiskSize;
    }
}
