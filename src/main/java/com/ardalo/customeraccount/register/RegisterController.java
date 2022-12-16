package com.ardalo.customeraccount.register;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegisterController {

  @GetMapping("/api/pages/register")
  public ModelAndView loginPage() {
    return new ModelAndView("registerPage");
  }
}
