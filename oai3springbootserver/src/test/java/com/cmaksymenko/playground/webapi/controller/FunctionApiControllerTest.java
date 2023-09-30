package com.cmaksymenko.playground.webapi.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FunctionApiController.class)
public class FunctionApiControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Disabled
	@Test
	public void testCreateReverseWordsFunction() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/functions/reverseWords").contentType(MediaType.APPLICATION_JSON)
				.content("{\"inputString\":\"Write a function\"}")).andExpect(status().isOk())
				.andExpect(content().string("{\"reversedString\":\"function a Write\"}"));
	}
}
