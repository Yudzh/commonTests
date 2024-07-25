package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiContainer {

  @Autowired
  public UserService userService;

}
