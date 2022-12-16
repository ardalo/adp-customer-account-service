package com.ardalo.customeraccount.myaccount;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyAccountController {

  @GetMapping("/api/pages/my-account")
  public ModelAndView loginPage() {
    return new ModelAndView("myAccountPage");
  }
}
