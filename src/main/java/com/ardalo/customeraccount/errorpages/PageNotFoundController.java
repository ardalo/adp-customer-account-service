package com.ardalo.customeraccount.errorpages;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PageNotFoundController {

  @GetMapping("/api/pages/404")
  public ModelAndView notFoundPage() {
    return new ModelAndView("notFoundPage");
  }
}
