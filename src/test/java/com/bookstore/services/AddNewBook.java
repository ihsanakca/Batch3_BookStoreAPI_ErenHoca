package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.*;

public class AddNewBook extends Globals {

    public void addNewBook() {
        String body = "{\n" +
                "  \"userId\": \"" + userID + "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"" + isbnNumbers.get(0) + "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        /*
        Map<String, Object> mapBody = new HashMap<>();
        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("isbn", isbnNumbers.get(0));

        list.add(map);

        mapBody.put("userId", userID);
        mapBody.put("collectionOfIsbns", list);
        */

        response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(body)
                .when().log().all()
                .post("/BookStore/v1/Books")
                .prettyPeek();

    }

    public void validateThatTheBookAddedToTheUser() {
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.path("books[0].isbn"), isbnNumbers.get(0));
    }
}
