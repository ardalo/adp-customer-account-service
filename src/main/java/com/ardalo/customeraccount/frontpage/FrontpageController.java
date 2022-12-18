package com.ardalo.customeraccount.frontpage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FrontpageController {

  private final String footerUrl;

  public FrontpageController(@Value("${ui.footer-url}") String footerUrl) {
    this.footerUrl = footerUrl;
  }

  @GetMapping("/api/pages/frontpage")
  public ModelAndView frontPage() {
    ModelAndView modelAndView = new ModelAndView("frontPage");
    modelAndView.getModel().put("footerUrl", footerUrl);
    return modelAndView;
  }
}
