package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing Calculator Class")
class CalculatorTest {

	static Calculator c1 = null;
	
	@BeforeAll
	static void createCalculator() {
		c1 = new Calculator();
		System.out.println("Testing started!!");
	}
	
	@Test
	@DisplayName("Dummy test method")
	@Disabled
	void test() {
		System.out.println("From Test test method");
		assertTrue(true);
	}
	
	@Test
	@DisplayName("Test Add method")
	void testAdd() {
		
		System.out.println("From Test Add method");
		assertEquals(30, c1.add(10, 20), ()-> "Sum of two numbers is not as excepted!");
		assertEquals(3, c1.add(1, 2), ()-> "Sum of two numbers is not as excepted!");
		assertEquals(-10, c1.add(10, -20), ()-> "Sum of two numbers is not as excepted!");
	}
	
	@Test
	@DisplayName("Test Div method")
	void TestDiv() throws Exception {
		System.out.println("From Test Div method");
		assertEquals(2, c1.div(10, 5), () -> "Div of two numbers is not as expected!");
		assertThrows(NullPointerException.class, ()->c1.div(10, 0));
	}
	
	@Test
	@DisplayName("Test Mul method")
	void testMul() {
		System.out.println("From test Mul start");
		assertAll(
			() -> assertEquals(40, c1.mul(10, 4), () -> "Mul of two numbers is not as excepted!"),
			() -> assertEquals(4, c1.mul(2, 2), () -> "Mul of two numbers is not as excepted!"),
//			() -> assertEquals(40, c1.mul(10, 3), () -> "Mul of two numbers is not as excepted!"),	//fail
			() -> assertEquals(40, c1.mul(10, 4), () -> "Mul of two numbers is not as excepted!"),
//			() -> assertEquals(200, c1.mul(10, 10), () -> "Mul of two numbers is not as excepted!"),	//fail
			() -> assertEquals(100, c1.mul(10, 10), () -> "Mul of two numbers is not as excepted!")
		);
		System.out.println("From test Mul end");
	}
	
	@AfterAll
	static void removeCalculator() {
		c1 = null;
		System.out.println("Testing Completed!!");
	}
	
	@BeforeEach
	void abc() {
		System.out.println("Before Each.......");
	}

	@AfterEach
	void xyz() {
		System.out.println("After Each.......");
	}

}
