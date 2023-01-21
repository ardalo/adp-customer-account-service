package com.ardalo.customeraccount.footer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

@WebMvcTest(FooterController)
class FooterControllerSpec extends Specification {

  @Autowired
  MockMvc mockMvc

  def "should provide footer fragment"() {
    when:
    def result = mockMvc.perform(MockMvcRequestBuilders.get("/api/fragments/footer")).andReturn()

    then:
    result.response.status == 200
    result.response.contentAsString.contains("</footer>")
  }
}
