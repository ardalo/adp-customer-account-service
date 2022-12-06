package com.ardalo.customeraccount.errorpages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PageNotFoundController {

  @GetMapping("/api/pages/404")
  public ModelAndView notFoundPage() {
    ModelAndView modelAndView = new ModelAndView("notFoundPage");
    modelAndView.getModel().put("currentTimestamp", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
    return modelAndView;
  }
}
