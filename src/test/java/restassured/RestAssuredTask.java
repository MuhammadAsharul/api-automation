package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

public class RestAssuredTask {
    public static void main(String[] args) {
        // auth();
        getAllObjects2();
        // getListObjectById();
        // getObjectById();
        // createObject();
        // updateObject();
        // updatePartiallyObject();
        // deleteObject();
    }
    public static void getAllObjects(){
        // GET /objects
        RestAssured.baseURI = "https://api.restful-api.dev/";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "objects")
                            .when()
                                .get("{path}");
        System.out.println("Get All Objects: " + response.asPrettyString()); 
    }

    public static void getAllObjects2() {
        // GET /products

        // Define base URL
        // "https://dummyjson.com/products"
        // baseURI = "https://dummyjson.com"
        // path = "/products"

        RestAssured.baseURI = "https://dummyjson.com"; // type String
        RequestSpecification requestSpecification = RestAssured.given();
        Response response =requestSpecification.log().all().get("products"); // type Response
        // Memproses respons agar sesuai format
        JsonPath jsonPath = response.jsonPath();
        JSONArray productsArray = new JSONArray();
        
        for (Object product : jsonPath.getList("products")) {
            JSONObject p = new JSONObject(product.toString());
            JSONObject newProduct = new JSONObject();
            newProduct.put("id", p.get("id").toString());
            newProduct.put("name", p.get("title"));

            JSONObject data = new JSONObject();
            if (p.has("color")) data.put("color", p.get("color"));
            if (p.has("capacity")) data.put("capacity", p.get("capacity"));
            if (p.has("price")) data.put("price", p.get("price"));

            newProduct.put("data", data.isEmpty() ? JSONObject.NULL : data);
            productsArray.put(newProduct);
        }

        System.out.println("Hasilnya adalah: " + productsArray.toString(4));
    }

    public static void getObjectById() {
        //GET /objects/{id}
        RestAssured.baseURI = "https://api.restful-api.dev";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "objects")
                                .pathParam("id", "1")
                            .when()
                                .get("{path}/{id}");
        System.out.println("Get Object by Id: " + response.asPrettyString());
    }

    public static void getListObjectById() {
        RestAssured.baseURI = "https://api.restful-api.dev";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "objects")
                                .queryParam("id", "3,5,10")
                            .when()
                                .get("{path}");
        System.out.println("Get Object by Id: " + response.asPrettyString());
    }


    public static void createObject() {
        // POST /objects
        String json = "{\n" +
        "   \"name\": \"Apple MacBook Pro 17\",\n" +
        "   \"data\": {\n" +
        "      \"year\": 2019,\n" +
        "      \"price\": 1849.99,\n" +
        "      \"CPU_model\": \"Intel Core i9\",\n" +
        "      \"Hard_disk_size\": \"1 TB\"\n" +
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
        System.out.println("Add Object adalah: " + response.asPrettyString());
    }

    public static void updateObject() {
        // PUT /objects/{id}
        // {
            String json = "{\n" +
            "   \"name\": \"Apple MacBook Pro 18\",\n" +
            "   \"data\": {\n" +
            "      \"year\": 2025,\n" +
            "      \"price\": 1849.99,\n" +
            "      \"CPU_model\": \"Intel Core i7\",\n" +
            "      \"Hard_disk_size\": \"2 TB\"\n" +
            "   }\n" +
            "}";

            RestAssured.baseURI = "https://api.restful-api.dev";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "objects")
                                .pathParam("idObject", "ff808181932badb601950a1def5e344a")
                                .body(json)
                                .contentType("application/json")
                            .when()
                                .put("{path}/{idObject}");
        System.out.println("Update Object adalah: " + response.asPrettyString());
    }

    public static void updatePartiallyObject() {
        // PATCH /objects/{id}
        // {
        //     "name": "Apple MacBook Pro 18"
        // }

        String json = "{\n" +
        "   \"name\": \"Apple MacBook Pro 21\"\n" +
        "}";

        RestAssured.baseURI = "https://api.restful-api.dev";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "objects")
                                .pathParam("idObject", "ff808181932badb601950a1def5e344a")
                                .body(json)
                                .contentType("application/json")
                            .when()
                                .patch("{path}/{idObject}");
        System.out.println("Update Object adalah: " + response.asPrettyString());
    }

    public static void deleteObject() {
        // DELETE /objects/{id}
        RestAssured.baseURI = "https://api.restful-api.dev";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "objects")
                                .pathParam("idObject", "ff808181932badb601950a1def5e344a") // ketika kita ganti 195 not found karena idObject tidak disimpan di server
                            .when()
                                .delete("{path}/{idObject}");
        System.out.println("Delete Object adalah: " + response.asPrettyString());
    }
}
