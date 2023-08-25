package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class GetAllBooks extends Globals {

    public void getAllBooks(){
        response= RestAssured
                .given()
                .accept(ContentType.JSON)
                .when().log().all()
                .get("/BookStore/v1/Books")
                .prettyPeek();
    }

    public void validateThatAllBooksAreListed(){
        Assert.assertEquals(response.statusCode(),200);

        //bütün isbn'leri alalım
        JsonPath jsonPath = response.jsonPath();
        List<String> allIsbnNumbers= jsonPath.getList("books.isbn");
        allIsbnNumbers.forEach(n->Assert.assertNotNull(n));

        //bütün isbn numaralarını globaldekine alalım
        isbnNumbers=jsonPath.getList("books.isbn");


    }
}
