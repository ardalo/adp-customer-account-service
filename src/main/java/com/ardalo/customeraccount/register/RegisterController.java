package com.ardalo.customeraccount.register;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegisterController {

  private final String footerUrl;

  RegisterController(@Value("${ui.footer-url}") String footerUrl) {
    this.footerUrl = footerUrl;
  }

  @GetMapping("/api/pages/register")
  public ModelAndView registerPage() {
    ModelAndView modelAndView = new ModelAndView("registerPage");
    modelAndView.getModel().put("footerUrl", footerUrl);
    return modelAndView;
  }
}
