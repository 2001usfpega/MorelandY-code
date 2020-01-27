package com.revature.javacore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuestionOneTest {

	@Test
	void test() {
		QuestionOne one = new QuestionOne();
		int[]input = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		one.bubble_srt(input);
		
	}

}
