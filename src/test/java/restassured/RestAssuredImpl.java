package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredImpl {
    public static void main(String[] args) {
        // getAllProducts();
        // getProductById();
        // searchProduct();
        // createProduct();
        updateProduct();
        // deleteProduct();
    }

    public static void getAllProducts() {
        // GET /products

        // Define base URL
        // "https://dummyjson.com/products"
        // baseURI = "https://dummyjson.com"
        // path = "/products"

        RestAssured.baseURI = "https://dummyjson.com"; // type String
        RequestSpecification requestSpecification = RestAssured.given();
        Response response =requestSpecification.log().all().get("products"); // type Response
        Response response2 = RestAssured
                            .given()
                                .log()
                                .all()
                            .when()
                                .get("products");

        // System.out.println("Hasilnya adalah: " + response.asPrettyString());
        System.out.println("Hasilnya adalah: " + response2.asPrettyString());
    }

    public static void getProductById() {
        // GET /products/{id}
        // "https://dummyjson.com/products/1"
        RestAssured.baseURI = "https://dummyjson.com";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response3 = requestSpecification
                                .log()
                                .all()    
                                .pathParam("path", "products")
                                .pathParam("idProduct", 1)
                            .when()
                                .get("{path}/{idProduct}");
        System.out.println("Product by Id adalah: " + response3.asPrettyString());
    }

    public static void searchProduct() {
        // GET /products?/seacrh?q=phone
        RestAssured.baseURI = "https://dummyjson.com";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "products")
                                .pathParam("method", "search")
                                .queryParam("q", "Iphone 5s")
                            .when()
                                .get("{path}/{method}");
        System.out.println("Product by name adalah: " + response.asPrettyString());
    }

    public static void createProduct() {
        // POST /products
        // {
        //     "name": "Iphone 5s",
        //     "price": 5000000
        // }

        String json = "{\n" +
                        "    \"title\": \"Iphone 15\",\n" +
                        "    \"price\": 2000000\n" +
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
    }

    public static void updateProduct() {
        // PUT /products/{id}
        // {
        //     "name": "Iphone 5s",
        //     "price": 5000000
        // }

        String json = "{\n" +
                        "    \"title\": \"Iphone 7\",\n" +
                        "    \"price\": 2000000\n" +
                        "}";

        RestAssured.baseURI = "https://dummyjson.com";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "products")
                                .pathParam("idProduct", "1") // ketika kita ganti 195 not found karena idProduct tidak disimpan di server
                                .body(json)
                                .contentType("application/json")
                            .when()
                                .put("{path}/{idProduct}");
        System.out.println("Update Product adalah: " + response.asPrettyString());
    }

    public static void deleteProduct() {
        // DELETE /products/{id}
        RestAssured.baseURI = "https://dummyjson.com";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "products")
                                .pathParam("idProduct", "1") // ketika kita ganti 195 not found karena idProduct tidak disimpan di server
                            .when()
                                .delete("{path}/{idProduct}");
        System.out.println("Delete Product adalah: " + response.asPrettyString());
    }

}
