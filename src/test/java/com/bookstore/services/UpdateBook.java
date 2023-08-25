package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class UpdateBook extends Globals {
    public void updateBook(){
        Map<String,String> mapBody=new HashMap<>();
        mapBody.put("userId",userID);
        mapBody.put("isbn", isbnNumbers.get(1));

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("ISBN",isbnNumbers.get(0))
                .header("Authorization", "Bearer "+token)
                .body(mapBody)
                .when().log().all()
                .put("/BookStore/v1/Books/{ISBN}")
                .prettyPeek();
    }

    public void validateThatTheBookIsUpdated(){

            Assert.assertEquals(response.statusCode(), 200);
            Assert.assertEquals(response.path("userId"), userID);
            Assert.assertEquals(response.path("username"), userName);
            Assert.assertEquals(response.path("books[0].isbn"), isbnNumbers.get(1));
        }

}
