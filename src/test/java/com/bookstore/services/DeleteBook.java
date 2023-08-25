package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class DeleteBook extends Globals {
    public void deleteBook(){
        Map<String,String> mapBody=new HashMap<>();
        mapBody.put("userId",userID);
        mapBody.put("isbn", isbnNumbers.get(1));

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(mapBody)
                .header("Authorization","Bearer "+token)
                .when().log().all()
                .delete("/BookStore/v1/Book")
                .prettyPeek();
    }

    public void validateThatTheBookIsDeleted(){
        Assert.assertEquals(response.statusCode(),204);
    }
}
