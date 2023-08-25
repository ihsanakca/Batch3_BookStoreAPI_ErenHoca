package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class AuthorizeUser extends Globals {

    public void authorizeUser(){
        Map<String ,String> mapBody=new HashMap<>();
        mapBody.put("userName",userName);
        mapBody.put("password",password);

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(mapBody)
                .when().log().all()
                .post("/Account/v1/Authorized")
                .prettyPeek();
    }

    public void validateThatUserIsAuthorized(){
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals("true",response.asString());
    }
}
