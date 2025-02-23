package scenario;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apiautomation.model.ResponseObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TaskE2ETest {
    ResponseObject responseObject;

    @Test
    public void taskE2ETest(){
        String json = "{\n" + //
                        "   \"name\": \"Apple MacBook Pro 16\",\n" + //
                        "   \"data\": {\n" + //
                        "      \"year\": 2019,\n" + //
                        "      \"price\": 20000,\n" + //
                        "      \"CPU model\": \"Intel Core i9\",\n" + //
                        "      \"Hard disk size\": \"1 TB\"\n" + //
                        "   }\n" + //
                        "}";

        RestAssured.baseURI = "https://api.restful-api.dev";
        // Add product
        Response response = given()
                            .log()
                            .all()
                            .pathParam("path", "objects")
                            .body(json)
                            .contentType("application/json")
                            .when()
                                .post("{path}");
        System.out.println("Response API" + response.asPrettyString());
        JsonPath jsonPath = response.jsonPath();
        responseObject = jsonPath.getObject("", ResponseObject.class);

        Assert.assertEquals(responseObject.name, "Apple MacBook Pro 16");
        Assert.assertNotNull(responseObject.createdAt);
        Assert.assertNotNull(responseObject.id);
        Assert.assertEquals(responseObject.dataItem.year, 2019);
        Assert.assertEquals(responseObject.dataItem.price, 20000);
        Assert.assertEquals(responseObject.dataItem.cpuModel, "Intel Core i9");
        Assert.assertEquals(responseObject.dataItem.hardDiskSize, "1 TB");
        
        // Get product by id
        String idObject = responseObject.id;
        Response response2 = given()
                            .log()
                            .all()
                            .pathParam("path", "objects")
                            .pathParam("idObject", idObject)
                        .when()
                            .get("{path}/{idObject}");
        System.out.println("Response API" + response2.asPrettyString());


        // Update product
        String jsonUpdate = "{\n" + //
                        "   \"name\": \"Apple MacBook Pro 16\",\n" + //
                        "   \"data\": {\n" + //
                        "      \"year\": 2020,\n" + //
                        "      \"price\": 25000,\n" + //
                        "      \"CPU model\": \"Intel Core i9\",\n" + //
                        "      \"Hard disk size\": \"1 TB\"\n" + //
                        "   }\n" + //
                        "}";
        Response responseUpdate = given()
                            .log()
                            .all()
                            .pathParam("path", "objects")
                            .pathParam("idObject", idObject)
                            .body(jsonUpdate)
                            .contentType("application/json")
                            .when()
                                .put("{path}/{idObject}");
        System.out.println("Response API" + responseUpdate.asPrettyString());

        JsonPath jsonPathUpdate = responseUpdate.jsonPath();
        responseObject = jsonPathUpdate.getObject("", ResponseObject.class);
        Assert.assertNotNull(responseObject.id);
        Assert.assertNotNull(responseObject.updatedAt);
        Assert.assertEquals(responseObject.name, "Apple MacBook Pro 16");
        Assert.assertEquals(responseObject.dataItem.year, 2020);
        Assert.assertEquals(responseObject.dataItem.price, 25000);
        Assert.assertEquals(responseObject.dataItem.cpuModel, "Intel Core i9");
        Assert.assertEquals(responseObject.dataItem.hardDiskSize, "1 TB");

        // Verify updated product
        Response response3 = given()
                            .log()
                            .all()
                            .pathParam("path", "objects")
                            .pathParam("idObject", idObject)
                        .when()
                            .get("{path}/{idObject}");
        System.out.println("Response API" + response3.asPrettyString());


    }
}
