package com.ardalo.customeraccount.register;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegisterController {

  @GetMapping("/api/pages/register")
  public ModelAndView loginPage() {
    ModelAndView modelAndView = new ModelAndView("registerPage");
    modelAndView.getModel().put("currentTimestamp", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
    return modelAndView;
  }
}
