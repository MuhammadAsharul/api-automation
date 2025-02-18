package restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class ValidationResponse {
    public static void main(String[] args) {
        getProductById();
    }

    public static void getProductById() {
        // GET /products/{id}
        // "https://dummyjson.com/products/1"

        RestAssured.baseURI = "https://dummyjson.com";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                                .log()
                                .all()    
                                .pathParam("path", "products")
                                .pathParam("idProduct", 1)
                            .when()
                                .get("{path}/{idProduct}");

        ValidatableResponse validationResponse = response
                                                .then()
                                                .body("id", equalTo(1));
                                                
        if(validationResponse.equals(true)){
            System.out.println("Validasi : " + response.asPrettyString());
        } else {
            System.out.println("Product by Id tidak ditemukan");
        }
        System.out.println("Product by Id adalah: " + response.asPrettyString());

        JsonPath jsonPath = response.jsonPath();
        System.out.println("Product by Id adalah: " + jsonPath.get("id"));
        System.out.println("Title by Id adalah: " + jsonPath.get("title"));
        System.out.println("Width by Id adalah: " + jsonPath.get("dimensions.width"));
    }
    
}
