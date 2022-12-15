package com.ardalo.customeraccount.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

  @GetMapping("/api/pages/login")
  public ModelAndView loginPage() {
    return new ModelAndView("loginPage");
  }
}
