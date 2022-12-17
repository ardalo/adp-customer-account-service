package com.ardalo.customeraccount.myaccount;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyAccountController {

  private final String footerUrl;

  MyAccountController(@Value("${ui.footer-url}") String footerUrl) {
    this.footerUrl = footerUrl;
  }

  @GetMapping("/api/pages/my-account")
  public ModelAndView myAccountPage() {
    ModelAndView modelAndView = new ModelAndView("myAccountPage");
    modelAndView.getModel().put("footerUrl", footerUrl);
    return modelAndView;
  }
}
