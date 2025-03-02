package stepdefinitions;

import java.util.Map;

import org.testng.Assert;

import com.apiautomation.model.ResponseItem;
import com.apiautomation.model.request.RequestItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import apiengine.Assertion;
import apiengine.Endpoints;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.DataRequest;

public class StepDefinitionImpl {

    /* 
    Given A list of products are available
    When I add a new product to etalase
    Then The product is available
     */
    ResponseItem responseItem;    
    DataRequest dataRequest;  
    RequestItem requestItem;
    String json;
    int idProduct;
    Response response;
    Endpoints endpoints;
    Assertion assertion;

    @BeforeStep
    public void setUp(){
        endpoints = new Endpoints();
        assertion = new Assertion();
    }
    @Given("A list of products are available")
    public void getAllProducts(){
        // implementation
        System.out.println("Get all products");

        response = endpoints.getAllProducts("products");
        System.out.println("Hasilnya adalah: " + response.asPrettyString());
    }

    // @Given("A list of products are available")
    // public void getAllProducts(){
    //     // implementation
    //     System.out.println("Get all products");
    //     RestAssured.baseURI = "https://dummyjson.com"; // type String
    //     RequestSpecification reques  tSpecification = RestAssured.given();
    //     // Response response =requestSpecification.log().all().get("products"); // type Response
    //     Response response2 = requestSpecification
    //                             .log()
    //                             .all()
    //                         .when()
    //                             .get("products");

    //     // System.out.println("Hasilnya adalah: " + response.asPrettyString());
    //     System.out.println("Hasilnya adalah: " + response2.asPrettyString());
    // }


    @When("I add new products to etalase")
    public void addNewProduct(){
        // implementation
        System.out.println("Add new product");
        String json = "{\n" + //
                          "  \"id\": 1,\n" + //
                          "  \"title\": \"Le minerale\",\n" + //
                          "  \"description\": \"The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.\",\n" + //
                          "  \"category\": \"food\",\n" + //
                          "  \"price\": 10000,\n" + //
                          "  \"discountPercentage\": 5,\n" + //
                          "  \"rating\": 5,\n" + //
                          "  \"stock\": 15,\n" + //
                          "  \"tags\": [\n" + //
                          "    \"beauty\",\n" + //
                          "    \"mascara\"\n" + //
                          "  ],\n" + //
                          "  \"dimensions\": {\n" + //
                          "    \"width\": 23.17,\n" + //
                          "    \"height\": 14.43,\n" + //
                          "    \"depth\": 28.01\n" + //
                          "  }\n" + //
                          "}";
        RestAssured.baseURI = "https://dummyjson.com";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "products")
                                .pathParam("method","add")
                                .body(json)
                                .contentType("application/json")
                            .when()
                                .post("{path}/{method}");
        System.out.println("Add Product adalah: " + response.asPrettyString());

        // Validation POJO
        JsonPath addJsonPath = response.jsonPath();
        responseItem = addJsonPath.getObject("", ResponseItem.class);

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(responseItem.title,"Le minerale");
        Assert.assertEquals(responseItem.price,10000);
        Assert.assertEquals(responseItem.discountPercentage, 5);
        Assert.assertEquals(responseItem.stock, 15);
        Assert.assertEquals(responseItem.category, "food");
    
    }

    @Then("The product is available")
    public void getSingleProduct(){
    //     // implementation
    //     System.out.println("Get single product");
    //     RestAssured.baseURI = "https://dummyjson.com";
    //     RequestSpecification requestSpecification = RestAssured.given();
    //     Response response3 = requestSpecification
    //                             .log()
    //                             .all()    
    //                             .pathParam("path", "products")
    //                             .pathParam("idProduct", 1)
    //                         .when()
    //                             .get("{path}/{idProduct}");
    //     System.out.println("Product by Id adalah: " + response3.asPrettyString());

        response = endpoints.getProductById("products", "1");
        System.out.println("Product by Id adalah: " + response.asPrettyString());
    }

    
    @When("I add new {string} to etalase")
    public void addNewProducts(String payload) throws JsonMappingException, JsonProcessingException{
    //     // implementation    
    String json = "{\n" + //
                          "  \"id\": 1,\n" + //
                          "  \"title\": \"Le minerale\",\n" + //
                          "  \"description\": \"The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.\",\n" + //
                          "  \"category\": \"food\",\n" + //
                          "  \"price\": 10000,\n" + //
                          "  \"discountPercentage\": 5,\n" + //
                          "  \"rating\": 5,\n" + //
                          "  \"stock\": 15,\n" + //
                          "  \"tags\": [\n" + //
                          "    \"beauty\",\n" + //
                          "    \"mascara\"\n" + //
                          "  ],\n" + //
                          "  \"dimensions\": {\n" + //
                          "    \"width\": 23.17,\n" + //
                          "    \"height\": 14.43,\n" + //
                          "    \"depth\": 28.01\n" + //
                          "  }\n" + //
                          "}";
        dataRequest = new DataRequest();
    //     System.out.println("Add new product 1" + payload);
        
        for(Map.Entry<String, String> entry : dataRequest.addItemCollection().entrySet()){
            if(entry.getKey().equals(payload)){
                json = entry.getValue();
                break;
            }
        }

    //     RestAssured.baseURI = "https://dummyjson.com";
    //     RequestSpecification requestSpecification = RestAssured.given();
    //     Response response = requestSpecification
    //                             .log()
    //                             .all()
    //                             .pathParam("path", "products")
    //                             .pathParam("method","add")
    //                             .body(json)
    //                             .contentType("application/json")
    //                         .when()
    //                             .post("{path}/{method}");
    //     System.out.println("Add Product adalah: " + response.asPrettyString());

        response = endpoints.addProductData("products", "add", json);
        System.out.println("Add Product adalah: " + response.asPrettyString());

    //     // Object Mapper
    //     /* 
    //      * Convert JSON to POJO
    //      */
        ObjectMapper requestAddItem = new ObjectMapper();
        requestItem = requestAddItem.readValue(json, RequestItem.class);


    //     // Validation POJO
        JsonPath addJsonPath = response.jsonPath();
        responseItem = addJsonPath.getObject("", ResponseItem.class);

        Assert.assertEquals(response.statusCode(), 201);
    //     Assert.assertEquals(responseItem.title,requestItem.title);
    //     Assert.assertEquals(responseItem.price,requestItem.price);
    //     Assert.assertEquals(responseItem.discountPercentage, requestItem.discountPercentage);
    //     Assert.assertEquals(responseItem.stock, requestItem.stock);
    //     Assert.assertEquals(responseItem.category, requestItem.category);
        
    assertion.AssertAddProduct(responseItem, requestItem);

    }
    @Then("I can update item {string}")
    public void updateSingleProduct(String payload){
        idProduct = 1;
        dataRequest = new DataRequest();

        System.out.println("update single product");
        
        for(Map.Entry<String, String> entry : dataRequest.updateItemCollection().entrySet()){
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

        response = endpoints.updateProductById("products", idProduct, json);
        System.out.println("Update Product by Id adalah: " + response.asPrettyString());
    }

}
