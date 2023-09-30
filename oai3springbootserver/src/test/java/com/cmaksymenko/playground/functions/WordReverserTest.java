package com.cmaksymenko.playground.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordReverserTest {

	@Test
	public void testNormalCases() {
		assertEquals("World Hello", WordReverser.reverseWords("Hello World"));
		assertEquals("twinkle sky night the make Stars", WordReverser.reverseWords("Stars make the night sky twinkle"));
	}

	@Test
	public void testEdgeCases() {
		assertEquals("Hello", WordReverser.reverseWords("Hello"));
		assertEquals("", WordReverser.reverseWords(""));
		assertEquals("World   Hello", WordReverser.reverseWords("Hello   World"));
		assertEquals(" World Hello ", WordReverser.reverseWords(" Hello World "));
	}

	@Test
	public void testSpecialCharactersAndNumbers() {
		assertEquals("456 123", WordReverser.reverseWords("123 456"));
		assertEquals("World! Hello,", WordReverser.reverseWords("Hello, World!"));
	}
}