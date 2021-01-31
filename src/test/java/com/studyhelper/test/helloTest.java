package com.studyhelper.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("tester")
@SpringBootTest(properties = "spring.config.location="
		+ "file:/C:/Users/Owner/eclipse-workspace/config/real-application.yml,"
		+ "classpath:application.yml", classes = {HelloController.class,PropertiesValueTest.class})
@AutoConfigureMockMvc
public class helloTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void helloTest() throws Exception {
		mockMvc.perform(get("/hello")).andExpect(status().is(HttpStatus.OK.value())).andDo(print());
	}
}
