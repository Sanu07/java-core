package com.test.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.java.solution.Solution2;

public class Solution2Test {

	private Solution2 s2 = new Solution2();
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test() {
		assertEquals(10, s2.countAllEmployees());
	}

}
