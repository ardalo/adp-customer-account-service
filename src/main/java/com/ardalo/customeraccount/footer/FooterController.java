package com.ardalo.customeraccount.footer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FooterController {

  @GetMapping("/api/fragments/footer")
  public ModelAndView footer() {
    return new ModelAndView("footerFragment");
  }
}
