package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.lang.annotation.Inherited;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.*;

@DisplayName("Testing Calculator Class")
@TestInstance(Lifecycle.PER_CLASS)
class CalculatorTest {
	
	public CalculatorTest() {
		System.out.println("<----- CalculatorTest Object created ----->");
	}

	Calculator c1 = null;
	int denom = 2;
//	int denom = 0;
	
	@BeforeAll							//Older version : @BeforeClass
	void createCalculator() {
		c1 = new Calculator();
		System.out.println("Testing started!!");
	}
	
	@Test				
	@DisplayName("Dummy test()")
	@Disabled							//Older version : @Ignore
	@Tag("demo")
	void test() {
		System.out.println("From Test test method");
		assertTrue(true);
	}
	
	@Test
	@DisplayName("Test Add()")
	@EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
	@Tag("math")
	void testAdd() {
		
		System.out.println("From Test Add method");
		assertEquals(30, c1.add(10, 20), ()-> "Sum of two numbers is not as excepted!");
		assertEquals(3, c1.add(1, 2), ()-> "Sum of two numbers is not as excepted!");
		assertEquals(-10, c1.add(10, -20), ()-> "Sum of two numbers is not as excepted!");
	}
	
	@Test
	@DisplayName("Test Div()")
	@Tag("math")
	void TestDiv(){
		System.out.println("From Test Div method");
		assertEquals(2, c1.div(10, 5));
		assertThrows(NullPointerException.class, ()->c1.div(10, 0));
	}
	
	@Test
	@DisplayName("Test Mul()")
	@Tag("math")
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
	
	@Test
	@DisplayName("Test Mod()")
	@Tags(value = {@Tag("demo"), @Tag("math")})
	void testMod() {
		System.out.println("From test Mod start");
		assertAll(
				() -> assertEquals(0, c1.mod(10, 10), () -> "Mod of two numbers is not as excepted!"),
				() -> assertEquals(1, c1.mod(11, 10), () -> "Mod of two numbers is not as excepted!"),
				() -> assertEquals(2, c1.mod(12, 10), () -> "Mod of two numbers is not as excepted!"),
				() -> assertEquals(3, c1.mod(13, 10), () -> "Mod of two numbers is not as excepted!"),				
				() -> assertEquals(4, c1.mod(14, 10), () -> "Mod of two numbers is not as excepted!")
		);
		System.out.println("From test Mod end");
	}
	
	@Test
	@EnabledOnOs(value = {OS.WINDOWS})
	@Tag("os")
	void testDLL() {
		System.out.println("From testDLL()");
	}
	
	@Test
	@EnabledOnOs(value = {OS.LINUX, OS.MAC})
	@Tag("os")
	void testShellScript() {
		System.out.println("From testSchellScript()");
	}
	
	@Test
	@Tag("math")
	void testDynamically() {
		System.out.println("From testDynamically() start");
		assertEquals(5, c1.div(10, denom), () -> "Div of two numbers is not as excepted!");
		assertEquals(2, c1.div(4, denom), () -> "Div of two numbers is not as excepted!");
		assumeTrue(denom == 0);
		assertEquals(10,c1.div(10, 0), () -> "Div of two numbers is not as excepted!");
		
		System.out.println("From testDynamically() end");
	}
	
	@Test
	@Tag("demo")
	void testThisOnly() {
		System.out.println("From testThisOnly()");
	}
	
	
	@AfterAll							//Older version : @AfterClass
	void removeCalculator() {
		c1 = null;
		System.out.println("Testing Completed!!");
	}
	
	@BeforeEach
	void start() {
		System.out.println("Before Each.......");
	}

	@AfterEach
	void end() {
		System.out.println("After Each.......");
	}

// Assignment without using Mockito
//	@Test
//	@Tag("void")
//	@DisplayName("Test Xyz()")
//	void testXyz() {
//		assertDoesNotThrow(() ->c1.xyz(), "There are some errors in xyz()");
//	}
//	
//	@Nested
//	static class Times extends Calculator{
//		static int counter = 0;
//		
//		@Override
//		public void count() {
//			counter++;
//			super.count();
//		}
//	}
//	
//	@RepeatedTest(3)
//	@Tag("times")
//	@DisplayName("Test count()")
//	void testCount() {
//		assertDoesNotThrow(() -> new Times().count(), "Some error occured in count()");
//	}
//	
//	@Test
//	@Tag("times")
//	@DisplayName("Test if count() is called exactly 3 times")
//	void testTimes() {
//		assertTrue(Times.counter == 3);
//	}
}
