package com.revature.javacore;

import java.util.ArrayList;
import java.util.List;

public class QuestionEight {

	public static void main(String[] args) {

		String[] words = { "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy",
				"did" };
		List<String> orig = new ArrayList<String>();

		for (int i = 0; i < words.length; i++) {
			if (isPalindrome(words[i])) {
				orig.add(words[i]);

			}
		}
		for (int i = 0; i < orig.size(); i++) {
			System.out.println(orig.get(i));
		}

	}

	static boolean isPalindrome(String str) {

		// Pointers pointing to the beginning
		// and the end of the string
		int i = 0, j = str.length() - 1;

		// While there are characters to compare
		while (i < j) {

			// If there is a mismatch
			if (str.charAt(i) != str.charAt(j))
				return false;

			// Increment first pointer and
			// decrement the other
			i++;
			j--;
		}

		// Given string is a palindrome
		return true;
	}

}
