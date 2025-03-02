package stepdefinitions;

import com.apiautomation.model.ResponseObject;
import com.apiautomation.model.request.RequestObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import apiengine.TaskAssertion;
import apiengine.TaskEndpoints;

import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.DataRequest;
import resources.TaskDataRequest;

public class TaskStepDefinition {

    ResponseObject responseObject;
    TaskDataRequest taskDataRequest;
    RequestObject requestObject;
    String json;
    int idProduct;
    Response response;
    TaskAssertion taskAssertion;
    TaskEndpoints taskEndpoints;
    TaskDataRequest taskDataRequest;

    @BeforeStep
    public void setUp(){
        taskEndpoints = new TaskEndpoints();
        taskAssertion = new TaskAssertion();
    }

    @Given("A list of item are available get list of all objects")
    public void getAllObjects(){
        // implementation
        System.out.println("Get all objects");
        // RestAssured.baseURI = "https://api.restful-api.dev"; // type String
        // RequestSpecification requestSpecification = RestAssured.given();
        // Response response =requestSpecification.log().all().get("products"); // type Response
        // Response response2 = requestSpecification
        //                         .log()
        //                         .all()
        //                     .when()
        //                         .get("products");
        // System.out.println("Hasilnya adalah: " + response.asPrettyString());
        // System.out.println("Hasilnya adalah: " + response2.asPrettyString());

        response = taskEndpoints.getAllObjects("objects");
        System.out.println("Hasilnya adalah: " + response.asPrettyString());
    }

    @When("I add a new object to etalase")
    public void addNewObject(){
        // implementation
        System.out.println("Add new object");
        String json = "{\n" +
        "   \"name\": \"Apple MacBook Pro 16\",\n" + 
        "   \"data\": {\n" + 
        "      \"year\": 2019,\n" + 
        "      \"price\": 20000,\n" + 
        "      \"CPU model\": \"Intel Core i9\",\n" +
        "      \"Hard disk size\": \"1 TB\"\n" +
        "   }\n" +
            "}"; 
        RestAssured.baseURI = "https://api.restful-api.dev";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "objects")
                                .body(json)
                                .contentType("application/json")
                            .when()
                                .post("{path}");
        System.out.println("Add Product adalah: " + response.asPrettyString());

        // Validation POJO
        JsonPath addJsonPath = response.jsonPath();
        responseObject = addJsonPath.getObject("", ResponseObject.class);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(responseObject.name,"Apple MacBook Pro 16");
        Assert.assertEquals(responseObject.dataItem.year,2019);
        Assert.assertEquals(responseObject.dataItem.price, 20000);
        Assert.assertEquals(responseObject.dataItem.cpuModel, "Intel Core i9");
        Assert.assertEquals(responseObject.dataItem.hardDiskSize, "1 TB");
    }

    @Then("The item is available Single object")
    public void getSingleObject(){
        // implementation
        // System.out.println("Get single object");
        // RestAssured.baseURI = "https://api.restful-api.dev";
        // RequestSpecification requestSpecification = RestAssured.given();
        // Response response3 = requestSpecification
        //                         .log()
        //                         .all()    
        //                         .pathParam("path", "objects")
        //                         .pathParam("idObject", 1)
        //                     .when()
        //                         .get("{path}/{idObject}");
        // System.out.println("Object by Id adalah: " + response3.asPrettyString());

        response = taskEndpoints.getObjectById("products", "1");
        System.out.println("Object by Id adalah: " + response.asPrettyString());

    }

    // @When("I add item to list {string} Add object")
    // public void addNewObjects(String payload) throws JsonMappingException, JsonProcessingException{
    //     // implementation
    //     taskDataRequest = new TaskDataRequest();
    //     System.out.println("Add new product 1" + payload);
        
    //     for(Map.Entry<String, String> entry : taskDataRequest.addItemObject().entrySet()){
    //         if(entry.getKey().equals(payload)){
    //             json = entry.getValue();
    //             break;
    //         }
    //     }

    //     RestAssured.baseURI = "https://api.restful-api.dev";
    //     RequestSpecification requestSpecification = RestAssured.given();
    //     Response response = requestSpecification
    //                             .log()
    //                             .all()
    //                             .pathParam("path", "objects")
    //                             .contentType("application/json")
    //                             .body(json)
    //                         .when()
    //                             .post("{path}");
    //     System.out.println("Add Product adalah: " + response.asPrettyString());

    //     // Object Mapper
    //     /* 
    //      * Convert JSON to POJO
    //      */
    //     ObjectMapper requestAddItem = new ObjectMapper();
    //     requestObject = requestAddItem.readValue(json, RequestObject.class);


    //     // Validation POJO
    //     JsonPath addJsonPath = response.jsonPath();
    //     responseObject = addJsonPath.getObject("", ResponseObject.class);

    //     Assert.assertEquals(response.statusCode(), 201);
    //     Assert.assertEquals(responseObject.name,requestObject.name);
    //     Assert.assertEquals(responseObject.dataItem.year, requestObject.data.year);
    //     Assert.assertEquals(responseObject.dataItem.price, requestObject.data.price);
    //     Assert.assertEquals(responseObject.dataItem.cpuModel, requestObject.data.CPUmodel);
    //     Assert.assertEquals(responseObject.dataItem.hardDiskSize, requestObject.data.HardDiskSize);
        
    // }

    @When("I add item to list {string} Add object")
public void addNewObjects(String payload) throws JsonMappingException, JsonProcessingException{
    // Prepare Data
    String json = "{\n" + //
            " \"name\": \"Apple MacBook Pro 16\",\n" +
            " \"data\": {\n" +
            " \"year\": 2019,\n" +
            " \"price\": 20000,\n" +
            " \"CPU model\": \"Intel Core i9\",\n" +
            " \"Hard disk size\": \"1 TB\"\n" +
            " }\n" +
            "}";
    taskDataRequest = new TaskDataRequest();
    System.out.println("Add new product 1: " + payload);

    for(Map.Entry<String, String> entry : taskDataRequest.addItemObject().entrySet()){
        if(entry.getKey().equals(payload)){
            json = entry.getValue();
            break;
        }
    }


    // API Request
    // RestAssured.baseURI = "https://api.restful-api.dev";
    // RequestSpecification requestSpecification = RestAssured.given();

    // Response response = requestSpecification
    //                         .log()
    //                         .all()
    //                         .pathParam("path", "objects")
    //                         .contentType("application/json") // ✅ Pindah ke atas
    //                         .body(json)  // ✅ Pastikan json tidak null
    //                     .when()
    //                         .post("{path}");
    // System.out.println("Add Product Response: " + response.asPrettyString());

    response = taskEndpoints.addObjectData("products",  json);
        System.out.println("Add Object adalah: " + response.asPrettyString());

    // Object Mapping
    ObjectMapper requestAddItem = new ObjectMapper();
    requestObject = requestAddItem.readValue(json, RequestObject.class);

    // JSON Response Mapping
    JsonPath addJsonPath = response.jsonPath();
    responseObject = addJsonPath.getObject("", ResponseObject.class); // ✅ Perbaiki path

    // Assertions
    // Assert.assertEquals(response.statusCode(), 200);
    // Assert.assertEquals(responseObject.name, requestObject.name);
    // Assert.assertEquals(responseObject.dataItem.year, requestObject.data.year);
    // Assert.assertEquals(responseObject.dataItem.price, requestObject.data.price);
    // Assert.assertEquals(responseObject.dataItem.cpuModel, requestObject.data.CPUmodel);

    taskAssertion.AssertAddObject(responseObject, requestObject);
    // Assert.assertEquals(responseObject.dataItem.hardDiskSize, requestObject.data.HardDiskSize);
}
    @Then("I can update item {string}")
    public void updateSingleProduct(String payload){
        idProduct = 1;
        taskDataRequest = new TaskDataRequest();

        System.out.println("update single product");
        
        for(Map.Entry<String, String> entry : taskDataRequest.updateObjectCollection().entrySet()){
                    if(entry.getKey().equals(payload)){
                        json = entry.getValue();
                        break;
                    }
                }
        // RequestSpecification requestSpecification = RestAssured.given();
        // Response response = requestSpecification
        //                     .log()
        //                     .all()
        //                     .pathParam("path",- "products")
        //                     .pathParam("id", "idProduct")
        //                     .body(json)
        //                     .contentType("application/json")
        //                 .when()
        //                     .put("{path}/{idProduct}");
        // System.out.println("update product" + response.asPrettyString());

        response = taskEndpoints.updateObjectById("products", idProduct, json);
        System.out.println("Update Object by Id adalah: " + response.asPrettyString());
    }

    


}
