package com.ardalo.customeraccount.errorpages

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

@WebMvcTest
class Global404ControllerSpec extends Specification {

  @Autowired
  MockMvc mockMvc

  def "should provide global 404 page"() {
    when:
    def result = mockMvc.perform(MockMvcRequestBuilders.get("/api/pages/global-404")).andReturn()

    then:
    result.response.status == 200
    result.response.contentAsString.contains("<title>404 Not Found</title>")
  }
}
