package com.redhat.shopping.integration.blackbox;

import com.redhat.shopping.cart.AddToCartCommand; 
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static io.restassured.RestAssured.delete; 
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@QuarkusTest
public class ShoppingCartTest {
    
    @BeforeEach
    public void clearCart() {
        delete("/cart");
    }

    @Test
    public void removingNonExistingProductInCatalogReturns400() {
        given()
            .pathParam("id", 9999)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(400);
    }

    @Test
    public void removingNonAddedProductToTheCartReturns404() {
        given()
            .pathParam("id", 1)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(404);
    }

    @Test
    public void removingProductfromCartContainMultipleAndDifferentProductsReturns200() {
        this.addProductToTheCartWithIdAndRandomQuantity(1);
        this.addProductToTheCartWithIdAndRandomQuantity(2);

        given()
            .pathParam("id", 1)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(200);        
    }

    private void addProductToTheCartWithIdAndRandomQuantity(int productId) {
        AddToCartCommand productToAdd = new AddToCartCommand(
            productId,   
            this.randomQuantity() );

        given()
            .contentType("application/json")
            .body(productToAdd)
            .put("/cart");
    }

    private int randomQuantity() {
        return (new Random()).nextInt(10) + 1;
    }
}
