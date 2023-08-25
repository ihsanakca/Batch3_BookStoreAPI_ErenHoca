package com.bookstore.step_defs;

import io.cucumber.java.Before;
import static io.restassured.RestAssured.*;

public class Hooks {
    @Before
    public void setUp(){
        baseURI="https://bookstore.toolsqa.com";
    }

}
