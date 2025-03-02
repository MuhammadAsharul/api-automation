package resources;

import java.util.HashMap;
import java.util.Map;

public class TaskDataRequest {


    public Map<String, String> addItemObject(){
        Map<String, String> dataObject = new HashMap<>();
        dataObject.put("addItem1", 
            "{\n" + //
            " \"name\": \"Apple MacBook Pro 16\",\n" +
            " \"data\": {\n" +
            " \"year\": 2019,\n" +
            " \"price\": 20000,\n" +
            " \"CPU model\": \"Intel Core i9\",\n" +
            " \"Hard disk size\": \"1 TB\"\n" +
            " }\n" +
            "}"
        );

        dataObject.put("addItem2", 
            "{\n" + //
            " \"name\": \"Apple MacBook Pro 15\",\n" +
            " \"data\": {\n" +
            " \"year\": 2018,\n" +
            " \"price\": 15000,\n" +
            " \"CPU model\": \"Intel Core i7\",\n" +
            " \"Hard disk size\": \"500 GB\"\n" +
            " }\n" +
            "}"
        );

        return dataObject;
    };

    public Map<String, String> updateObjectCollection(){
        Map<String, String> dataObject = new HashMap<>();
        dataObject.put("addItem1", 
            "{\n" + //
            " \"name\": \"Apple MacBook Pro 17\",\n" +
            " \"data\": {\n" +
            " \"year\": 2020,\n" +
            " \"price\": 20000,\n" +
            " \"CPU model\": \"Intel Core i9\",\n" +
            " \"Hard disk size\": \"1 TB\"\n" +
            " }\n" +
            "}"
        );

        dataObject.put("addItem2", 
            "{\n" + //
            " \"name\": \"Apple MacBook Pro 18\",\n" +
            " \"data\": {\n" +
            " \"year\": 2021,\n" +
            " \"price\": 15000,\n" +
            " \"CPU model\": \"Intel Core i7\",\n" +
            " \"Hard disk size\": \"5 TB\"\n" +
            " }\n" +
            "}"
        );
        return dataObject;
    }
    
}
