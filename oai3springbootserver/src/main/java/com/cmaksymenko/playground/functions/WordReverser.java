package com.cmaksymenko.playground.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordReverser {

	/**
	 * Reverse the words in a string.
	 *
	 * @param s The input string.
	 * @return A new string with the words reversed.
	 */
	public static String reverseWords(String s) {

		// Pattern to match either a word or whitespace
		Pattern pattern = Pattern.compile("(\\S+|\\s+)");
		Matcher matcher = pattern.matcher(s);
		
        // Store the words and whitespace in a list
        List<String> tokens = new ArrayList<>();
        while (matcher.find()) {
            tokens.add(matcher.group());
        }		
        
        StringBuilder reversed = new StringBuilder();

        // Add the words and whitespaces in reverse order
        for (int i = tokens.size() - 1; i >= 0; i--) {
            reversed.append(tokens.get(i));
        }

        return reversed.toString();
	}
}