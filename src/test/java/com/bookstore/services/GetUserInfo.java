package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class GetUserInfo extends Globals {

    public void getUserInformation() {

        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("Authorization","Bearer "+token);

        response = RestAssured.given()
                .accept(ContentType.JSON)
                .pathParam("UserId", userID)
        //        .header("Authorization", "Bearer " + token)
                .headers(tokenMap)
                .when().log().all()
                .get("/Account/v1/User/{UserId}")
                .prettyPeek();
    }

    public void validateThatTheUserInformation() {
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.path("userId"), userID);
        Assert.assertEquals(response.path("username"), userName);
        Assert.assertEquals(response.path("books[0].isbn"), isbnNumbers.get(0));
    }
}
