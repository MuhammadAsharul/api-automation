package apiengine;

import com.apiautomation.constants.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Endpoints {

    RequestSpecification requestSpecification;

    public Endpoints(){
        
        RestAssured.baseURI = Constants.BASE_URL; // type Strings
        requestSpecification = RestAssured.given();
    }

    public Response getAllProducts(String path) {
        // implementation
        System.out.println("Get all products");
        
        // Response response =requestSpecification.log().all().get("products"); // type Response
        Response response = requestSpecification
                                .log()
                                .all()
                            .when()
                                .get(path);

        return response;
    }

    public Response addProductData(String path, String method, String json) {
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", path)
                                .pathParam("method",method)
                                .body(json)
                                .contentType("application/json")
                            .when()
                                .post("{path}/{method}");
        return response;
    }

    public Response getProductById(String path, String id) {
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", path)
                                .pathParam("id", id)
                            .when()
                                .get("{path}/{id}");
        return response;
    }

    public Response updateProductById(String path, int idProduct, String json){
        Response response = requestSpecification
                            .log()
                            .all()
                            .pathParam("path", path)
                            .pathParam("idProduct", idProduct)
                            .contentType("application/json")
                            .body(json)
                        .when()
                            .put("{path}/{idProduct}");
        return response;
    }

    public Response deleteProductById(String path, int idProduct){
        Response response = requestSpecification
                            .log()
                            .all()
                            .pathParam("path", path)
                            .pathParam("idProduct", idProduct)
                            .contentType("application/json")
                        .when()
                            .delete("{path}/{idProduct}");
        return response;
    } 

}
