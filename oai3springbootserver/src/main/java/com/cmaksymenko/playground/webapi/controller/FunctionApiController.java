package com.cmaksymenko.playground.webapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import com.cmaksymenko.playground.functions.WordReverser;
import com.cmaksymenko.playground.webapi.api.FunctionApi;
import com.cmaksymenko.playground.webapi.model.CreateReverseWordsFunction200Response;
import com.cmaksymenko.playground.webapi.model.CreateReverseWordsFunctionRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("${openapi.playground.base-path:/api}")
public class FunctionApiController implements FunctionApi {

	private final NativeWebRequest request;

	@Autowired
	public FunctionApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	public ResponseEntity<CreateReverseWordsFunction200Response> createReverseWordsFunction(
			@Valid CreateReverseWordsFunctionRequest request) {

		@NotNull
		String inputString = request.getInputString();

		String reversedInputString = WordReverser.reverseWords(inputString);

		final CreateReverseWordsFunction200Response response = new CreateReverseWordsFunction200Response();
		response.setReversedString(reversedInputString);

		return ResponseEntity.ok(response);
	}
}