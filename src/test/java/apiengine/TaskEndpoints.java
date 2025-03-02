package apiengine;

import com.apiautomation.constants.TaskConstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TaskEndpoints {
RequestSpecification requestSpecification;

    public TaskEndpoints(){
        RestAssured.baseURI = TaskConstants.BASE_URL; // type Strings
        requestSpecification = RestAssured.given();
    }

    public Response getAllObjects(String path) {
        // implementation
        System.out.println("Get all objects");
        
        // Response response =requestSpecification.log().all().get("objects"); // type Response
        Response response = requestSpecification
                                .log()
                                .all()
                            .when()
                                .get(path);

        return response;
    }

    public Response addObjectData(String path, String json) {
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", path)
                                .body(json)
                                .contentType("application/json")
                            .when()
                                .post("{path}");
        return response;
    }

    public Response getObjectById(String path, String idObject){
         Response response = requestSpecification
                               .pathParam("path", path)
                               .pathParam("id", idObject)
                           .when()
                               .get("{path}/{id}");
        return response;
    }

    public Response updateObjectById(String path, int idObject, String json){
        Response response = requestSpecification
                            .log()
                            .all()
                            .pathParam("path", path)
                            .pathParam("idObject", idObject)
                            .contentType("application/json")
                            .body(json)
                        .when()
                            .put("{path}/{idObject}");
        return response;
    }

    public Response deleteObjectById(String path, int idObject){
        Response response = requestSpecification
                            .log()
                            .all()
                            .pathParam("path", path)
                            .pathParam("idObject", idObject)
                            .contentType("application/json")
                        .when()
                            .delete("{path}/{idObject}");
        return response;
    } 
}