package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class DemoTest {

	@RepeatedTest(5)
	@Disabled
	void testXyz() {
		System.out.println("From testXyz() start");
		Demo obj = mock(Demo.class);
		obj.xyz();
		verify(obj, times(1)).xyz();
		System.out.println("From testXyz() end");
	}
	
	@Test
	void testXyzTimes() {
		System.out.println("From testXyzTimes() start");
		Demo obj = mock(Demo.class);
		for(int i = 0 ; i < 5 ; i++) {
			obj.xyz();
		}
		verify(obj, times(5)).xyz();
		System.out.println("From testXyzTimes() end");
	}

}
