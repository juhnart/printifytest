import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.*;

@org.testng.annotations.Test(threadPoolSize = 3, invocationCount = 5,  timeOut = 10000)
public class ProductTest {

    private String authToken = Constants.authToken;
    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(Constants.host)
            .setBasePath(Constants.basePath)
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .addHeader("Authorization", "Bearer " + authToken)
            .build();
    private ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    @Test
    public void testCreateProduct() {
        //create new product
        String productName = createNewProduct().get(0);

        //assert that product created
        final List<String> descriptions = given()
                .spec(requestSpec)
                .pathParams("id", getShopId())
                .when()
                .get(Constants.products)
                .then()
                .spec(responseSpec)
                .contentType(ContentType.JSON)
                .extract().body().jsonPath().getList("data.description");
        descriptions
                .stream()
                .filter(name -> name.equals(productName))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Product not created"));
    }

    @Test
    public void testUpdateProduct() {
        //create new product
        List<String> nameAndId = createNewProduct();
        String productId = nameAndId.get(1);

        //generate new product name
        Random rand = new Random();
        final String updatedProductName = "TestProduct2"+rand.nextInt();

        //update product
        given()
                .spec(requestSpec)
                .pathParams("shop_id", getShopId())
                .pathParams("product_id", productId)
                .when()
                .body(String.format(Constants.updateProductBody, updatedProductName))
                .put(Constants.product)
                .then()
                .spec(responseSpec)
                .contentType(ContentType.JSON);

        //assert that product updated
        String description = given()
                .spec(requestSpec)
                .pathParams("shop_id", getShopId())
                .pathParams("product_id", productId)
                .when()
                .get(Constants.product)
                .then()
                .spec(responseSpec)
                .contentType(ContentType.JSON)
                .extract().body().jsonPath().get("description");
        Assert.assertTrue(description.equals(updatedProductName));
    }

    @Test
    public void testDeleteProduct() {
        //create new product
        List<String> nameAndId = createNewProduct();
        String productId = nameAndId.get(1);

        //delete product
        given()
                .spec(requestSpec)
                .pathParams("shop_id", getShopId())
                .pathParams("product_id", productId)
                .when()
                .delete(Constants.product)
                .then()
                .spec(responseSpec)
                .contentType(ContentType.JSON);

        //assert that product deleted
        List<String> descriptions = given()
                .spec(requestSpec)
                .pathParams("id", getShopId())
                .when()
                .get(Constants.products)
                .then()
                .spec(responseSpec)
                .contentType(ContentType.JSON)
                .extract().body().jsonPath().getList("data.id");
        Assert.assertFalse(descriptions.contains(productId));
    }

    private String getShopId() {
        return given()
                .spec(requestSpec)
                .when()
                .log().all()
                .get(Constants.shops)
                .then()
                .spec(responseSpec)
                .contentType(ContentType.JSON)
                .extract().jsonPath().getList("id").get(0).toString();
    }

    private List<String> createNewProduct() {
        List<String> nameAndId = new ArrayList<>();
        Random rand = new Random();
        final String productName = "TestProduct" +rand.nextInt();
        nameAndId.add(productName);
        String id = given()
                .spec(requestSpec)
                .pathParams("id", getShopId())
                .when()
                .log().all()
                .body(String.format(Constants.newProductBody, productName))
                .post(Constants.products)
                .then()
                .spec(responseSpec)
                .contentType(ContentType.JSON)
                .extract().jsonPath().getList("id").get(0).toString();
        nameAndId.add(id);
        return nameAndId;
    }

}
