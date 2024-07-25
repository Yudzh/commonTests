package service;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Rest {

  protected RequestSpecification reqSpec;

  public abstract String getBasePath();
  public abstract String getBaseUri();

  protected Rest(){
    reqSpec = new RequestSpecBuilder()
        .setContentType(ContentType.JSON)
        .setBaseUri(getBaseUri())
        .setBasePath(getBasePath())
        .build();
  }

  protected Response executeGet(){
    return given()
        .spec(reqSpec)
        .log().uri()
        .when().get();
  }
}
