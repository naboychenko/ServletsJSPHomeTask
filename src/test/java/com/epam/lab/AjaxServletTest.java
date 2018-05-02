package com.epam.lab;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;


public class AjaxServletTest {

  @Test
  public void doGetCheck() {
    given().
        contentType("application/json").
        when().
        get("/main").
        then().
        body("servletInnerState", equalTo("GET")).
        statusCode(200);
  }
  @Test
  public void doPostCheck() {
    given().
        contentType("application/json").
        when().
        post("/main").
        then().
        body("servletInnerState", equalTo("POST")).
        statusCode(200);
  }
  @Test
  public void doPutCheck() {
    given().
        contentType("application/json").
        when().
        put("/main").
        then().
        body("servletInnerState", equalTo("PUT")).
        statusCode(200);
  }
  @Test
  public void doDeleteCheck() {
    given().
        contentType("application/json").
        when().
        delete("/main").
        then().
        body("servletInnerState", equalTo("DELETE")).
        statusCode(200);
  }


}
