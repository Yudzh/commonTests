package rest;

import org.springframework.stereotype.Component;
import pojo.User;

@Component
public class UserService extends Rest{
  @Override
  public String getBasePath() {
    return "/api";
  }

  @Override
  public String getBaseUri() {
    return "https://randomuser.me";
  }

  public User getUser(){
    return executeGet().then().extract().jsonPath().getList("results", User.class).get(0);
  }
}
