package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class GenerateToken extends Globals {



    public void generateToken(){
        Map<String ,String> mapBody=new HashMap<>();
        mapBody.put("userName",userName);
        mapBody.put("password",password);

        response= RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(mapBody)
                .when().log().all()
                .post("/Account/v1/GenerateToken")
                .prettyPeek();
    }

    public void validateThatTokenIsGenerated(){
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertNotNull(response.path("token"));
        Assert.assertEquals(response.path("result"),"User authorized successfully.");
        Assert.assertEquals(response.path("status"),"Success");

        token=response.path("token");
    }
}
