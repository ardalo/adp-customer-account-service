package com.ardalo.customeraccount.myaccount

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

@WebMvcTest
class MyAccountControllerSpec extends Specification {

  @Autowired
  MockMvc mockMvc

  def "should provide my account page"() {
    when:
    def result = mockMvc.perform(MockMvcRequestBuilders.get("/api/pages/my-account")).andReturn()

    then:
    result.response.status == 200
    result.response.contentAsString.contains("<title>My Account</title>")
  }
}
