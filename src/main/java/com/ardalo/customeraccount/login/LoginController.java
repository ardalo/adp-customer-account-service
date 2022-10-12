package com.ardalo.customeraccount.login;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

  @GetMapping("/api/pages/login")
  public ModelAndView loginPage() {
    ModelAndView modelAndView = new ModelAndView("loginPage");
    modelAndView.getModel().put("currentTimestamp", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
    return modelAndView;
  }
}
