package com.bookstore.services;

import com.bookstore.utilities.Globals;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class AddNewUser extends Globals {

    Faker faker = new Faker();

    public void addNewUser() {
        userName=faker.name().fullName();
        password="Sg***61"+faker.internet().password();

        Map<String ,String > mapBody=new HashMap<>();
        mapBody.put("userName",userName);
        mapBody.put("password",password);

        response = RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(mapBody)
                .when().log().all()
                .post("/Account/v1/User")
                .prettyPeek();
    }

    public void validateThatNewUserIsCreated(){

        Assert.assertEquals(response.statusCode(),201);
        Assert.assertNotNull(response.path("userID"));
        Assert.assertEquals(userName,response.path("username"));

        userID=response.path("userID");
    }
}
