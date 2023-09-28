package com.cmaksymenko.playground.webapi.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.cmaksymenko.playground.webapi.api.FunctionTestsApi;
import com.cmaksymenko.playground.webapi.model.CreateReverseWordsFunction200Response;
import com.cmaksymenko.playground.webapi.model.CreateReverseWordsFunctionRequest;

import jakarta.validation.Valid;

@RequestMapping("${openapi.playground.base-path:/api}")
public class FunctionTestsApiController implements FunctionTestsApi {

	private final NativeWebRequest request;

	@Autowired
	public FunctionTestsApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	public ResponseEntity<CreateReverseWordsFunction200Response> createReverseWordsFunction(@Valid CreateReverseWordsFunctionRequest request) {
		
		final CreateReverseWordsFunction200Response response = new CreateReverseWordsFunction200Response();
		response.setReversedString("NOT IMPLEMENTED!");
		
        return ResponseEntity.ok(response);
	}
}
