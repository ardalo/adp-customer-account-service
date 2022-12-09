package com.ardalo.customeraccount.errorpages;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Global404Controller {

  /**
   * Header "X-Replaced-Path" is set by Traefik.
   * See https://doc.traefik.io/traefik/middlewares/http/replacepath/#general
   * and /deployment/helm/values.yaml for details.
   */
  @GetMapping("/api/pages/global-404")
  public ModelAndView global404Page(@RequestHeader(name = "X-Replaced-Path", required = false) Optional<String> originalPath) {
    ModelAndView modelAndView = new ModelAndView("global404Page");
    modelAndView.getModel().put("originalPath", originalPath.orElse("n/a"));
    modelAndView.setStatus(HttpStatus.NOT_FOUND);
    return modelAndView;
  }
}
