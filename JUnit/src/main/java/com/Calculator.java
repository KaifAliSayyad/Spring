package com;
import java.lang.NullPointerException;

public class Calculator implements Demo {

	public Calculator() {
		System.out.println("<----- Calculator Object created ----->");
	}
	public int add(int a, int b) {
		return a+b;
	}
	
	public int sub(int a, int b) {
		return a-b;
	}
	
	public int mul(int a, int b) {
		return a*b;
	}
	
	public int div(int a, int b){
		if(b != 0) return a/b;
		throw new NullPointerException();
	}
	
	public int mod(int a, int b){
		return a % b;
	}

	
	public void xyz() {
		System.out.println("From abstract method xyz()");
//		throw new NullPointerException();
	}
}
