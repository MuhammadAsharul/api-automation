package com.apiautomation.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestObject {
    /* "{\n" + //
        "   \"name\": \"Apple MacBook Pro 16\",\n" + //
        "   \"data\": {\n" + //
        "      \"year\": 2019,\n" + //
        "      \"price\": 20000,\n" + //
        "      \"CPU model\": \"Intel Core i9\",\n" + //
        "      \"Hard disk size\": \"1 TB\"\n" + //
        "   }\n" + //
            "}"; */

    @JsonProperty("name")
    public String name;

    @JsonProperty("data")
    public Data data;

    public static class Data {
        @JsonProperty("year")
        public int year;

        @JsonProperty("price")
        public int price;

        @JsonProperty("CPU model")
        public String CPUmodel;

        @JsonProperty("Hard disk size")
        public String HardDiskSize;
    }
}
