package com.ardalo.customeraccount.errorpages;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PageNotFoundController {

  @GetMapping("/api/pages/404")
  public ModelAndView notFoundPage(@RequestParam(name = "originalPath", required = false) Optional<String> originalPath) {
    ModelAndView modelAndView = new ModelAndView("notFoundPage");
    modelAndView.getModel().put("originalPath", originalPath.orElse("n/a"));
    return modelAndView;
  }
}
