package com.ardalo.customeraccount.register

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

@WebMvcTest
class RegisterControllerSpec extends Specification {

  @Autowired
  MockMvc mockMvc

  def "should provide register page"() {
    when:
    def result = mockMvc.perform(MockMvcRequestBuilders.get("/api/pages/register")).andReturn()

    then:
    result.response.status == 200
    result.response.contentAsString.contains("<title>Register</title>")
  }
}
