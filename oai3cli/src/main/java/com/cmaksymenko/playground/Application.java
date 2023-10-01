package com.cmaksymenko.playground;

import java.net.ConnectException;

import com.cmaksymenko.playground.oai3server.webapi.ApiClient;
import com.cmaksymenko.playground.oai3server.webapi.ApiException;
import com.cmaksymenko.playground.oai3server.webapi.api.FunctionApi;
import com.cmaksymenko.playground.oai3server.webapi.model.CreateReverseWordsFunction200Response;
import com.cmaksymenko.playground.oai3server.webapi.model.CreateReverseWordsFunctionRequest;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "oai3cli", mixinStandardHelpOptions = true, description = "CLI Application")
public class Application implements Runnable {

    @Option(names = "--function", description = "Selects the function to run. Only 'reverseWords' is available.")
    private String function;

    @Parameters(index = "0", description = "The string to process.", arity = "0..1")
    private String input;
	
    public static void main(String[] args) {
        int exitCode = new CommandLine(new Application()).execute(args);
        System.exit(exitCode);
    }
    
    @Override
    public void run() {
        if (function == null) {
            System.out.println("No function specified. Use --help for more information.");
            return;
        }

        if ("reverseWords".equalsIgnoreCase(function)) {
            
        	if (input == null || input.trim().isEmpty()) {
                System.out.println("Function 'reverseWords' requires an input string. Provide a valid string to process.");
                return;
            }
            
        	ApiClient apiClient = new ApiClient();
        	apiClient.setBasePath("http://localhost:8080/api");            
        	FunctionApi functionApi = new FunctionApi(apiClient);
        	
        	CreateReverseWordsFunctionRequest request = new CreateReverseWordsFunctionRequest();
        	request.setInputString(this.input);
        	
        	CreateReverseWordsFunction200Response response;
			try {
				
				response = functionApi.createReverseWordsFunction(request);
				System.out.println(String.format("Reversed String: %s", response.getReversedString()));
			} catch (ApiException e) {
				e.printStackTrace();
			}
			
        } else {
            System.out.println("Invalid function selected. Currently only 'reverseWords' is supported.");
        }
    }
}
