package com;

public class CalculatorMain {

	public static void main(String[] args) {
		System.out.println("<<------------ Starting Calculator ------------>>");
		Calculator c1 = new Calculator();
		System.out.println("ADD : "+c1.add(10, 20));
		System.out.println("SUB : "+c1.sub(20, 10));
		System.out.println("DIV : "+c1.div(10, 5));
		System.out.println("MUL : "+c1.mul(5, 2));
		System.out.println("<<------------ Exitting Calculator ------------>>");

	}

}
