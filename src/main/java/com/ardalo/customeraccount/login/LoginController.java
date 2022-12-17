package com.ardalo.customeraccount.login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

  private final String footerUrl;

  LoginController(@Value("${ui.footer-url}") String footerUrl) {
    this.footerUrl = footerUrl;
  }

  @GetMapping("/api/pages/login")
  public ModelAndView loginPage() {
    ModelAndView modelAndView = new ModelAndView("loginPage");
    modelAndView.getModel().put("footerUrl", footerUrl);
    return modelAndView;
  }
}
