package com;
import java.lang.NullPointerException;

public class Calculator {
	public int add(int a, int b) {
		return a+b;
	}
	
	public int sub(int a, int b) {
		return a-b;
	}
	
	public int mul(int a, int b) {
		return a*b;
	}
	
	public int div(int a, int b) throws Exception{
		if(b != 0) return a/b;
		throw new NullPointerException();
	}
}
