package restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apiautomation.model.ResponseItem;
import com.beust.ah.A;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidationTest {
    // Scenario 1
    // Hit API https://dummyjson.com/products/1
    // Then Validate response body
    //  id is not empty
    //  title, price, discountPrecentage, stock, category

    @Test
    public void createProduct() {
        ResponseItem responseItem;
        

        // POST /products
        // {
        //     "name": "Iphone 5s",
        //     "price": 5000000
        // }

        String json = "{\n" +
    "    \"id\": 1,\n" +
    "    \"title\": \"Essence Mascara Lash Princess\",\n" +
    "    \"description\": \"The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects.\",\n" +
    "    \"category\": \"beauty\",\n" +
    "    \"price\": 10000,\n" +
    "    \"discountPercentage\": 7,\n" +
    "    \"rating\": 4.94,\n" +
    "    \"stock\": 5,\n" +
    "    \"tags\": [\"beauty\", \"mascara\"],\n" +
    "    \"brand\": \"Essence\",\n" +
    "    \"sku\": \"RCH45Q1A\",\n" +
    "    \"weight\": 2,\n" +
    "    \"dimensions\": {\n" +
    "        \"width\": 23.17,\n" +
    "        \"height\": 14.43,\n" +
    "        \"depth\": 28.01\n" +
    "    }\n" +
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

        JsonPath addJsonPath = response.jsonPath();
        
        // Cara ke 1
        // String title = addJsonPath.get("title");
        // int price = addJsonPath.get("price");
        // int discount = addJsonPath.get("discountPercentage");
        // int stock = addJsonPath.get("stock");
        // String category = addJsonPath.get("category");

        // Assert.assertEquals(response.getStatusCode(), 201);
        // Assert.assertEquals(title, "Essence Mascara Lash Princess");
        // Assert.assertEquals(price, 10000);
        // Assert.assertEquals(discount, 7);
        // Assert.assertEquals(stock, 5);
        // Assert.assertEquals(category, "beauty");

        if(response.getStatusCode() == 201){
            System.out.println("Product berhasil ditambahkan" + response.asPrettyString());
        } else {
            System.out.println("Product gagal ditambahkan" +response.getStatusCode());
        }

        // Cara ke 2
        responseItem = addJsonPath.getObject("", ResponseItem.class);
        Assert.assertEquals(responseItem.title, "Essence Mascara Lash Princess");
        Assert.assertEquals(responseItem.price, 10000);
        Assert.assertEquals(responseItem.discountPercentage, 7);
        Assert.assertEquals(responseItem.stock, 5);
        Assert.assertEquals(responseItem.category, "beauty");
        
    }

    @Test
    public void createObject(){
        // POST /products
        // {
        //     "name": "Iphone 5s",
        //     "price": 5000000
        // }

        String json = "{\n" +
                        "    \"name\": \"Iphone 15\",\n" +
                        "    \"price\": 2000000\n" +
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
        System.out.println("Create Object adalah: " + response.asPrettyString());

        JsonPath createJsonPath = response.jsonPath();
        String id  = createJsonPath.getString("id");
        String name = createJsonPath.getString("name");
        String createdAt = createJsonPath.getString("createdAt");
        int year = createJsonPath.getInt("data.year");
        float price = createJsonPath.getFloat("data.price");
        String cpuModel = createJsonPath.getString("data.'CPU model'");
        String hardisk = createJsonPath.getString("data.'Hard disk size'");

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(name, "Iphone 15");
        Assert.assertNotNull(id);
        Assert.assertNotNull(createdAt);
        Assert.assertEquals(year, 2021);
        Assert.assertEquals(price, 2000000);
        Assert.assertEquals(cpuModel, "A14 Bionic");
        Assert.assertEquals(hardisk, "256GB");

    }

}
