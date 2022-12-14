package com.ardalo.customeraccount.frontpage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FrontpageController {

  @GetMapping("/api/pages/frontpage")
  public ModelAndView loginPage() {
    return new ModelAndView("frontPage");
  }
}
