package org.mdzahidhasanjamil.citest1.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  public void test() throws Exception {
    mockMvc
        .perform(get("/user/test"))
        .andExpect(status().isOk()) // Check if the status is 200 OK
        .andExpect(
            content()
                .string("Test successfully done with updated version")); // Verify response body
  }
}
