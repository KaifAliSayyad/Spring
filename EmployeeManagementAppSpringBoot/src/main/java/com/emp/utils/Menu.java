package com.emp.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;



import com.emp.exceptions.*;

public class Menu{
	private static int maxChoice;
	private static BufferedReader br = null;

	static{
		try{
			br = new BufferedReader(new InputStreamReader(System.in));
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public static int readChoice(int max){
		maxChoice = max;
		while(true){
			try{
				System.out.print("Enter choice : ");
				int choice = Integer.parseInt(br.readLine());
				if(choice < 1 || choice > maxChoice){
					throw new InvalidChoiceException();
				}
				return choice;
			}
			catch(InputMismatchException e){
				System.out.println("Please enter number only");
			}
			catch(InvalidChoiceException e){
				e.displayMessage(maxChoice);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public static String readName(){
		while(true){
			try{
				System.out.print("Enter name : ");
				String name = br.readLine();
				if(Patterns.validateName(name)) return name;
				else{
					throw new InvalidNameException();
				}
			}catch(InvalidNameException e){
				//invalid name message printed from constructor
			}catch(InputMismatchException e){
				System.out.println("Name should be a valid string....");
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}

	public static int readAge(){
		while (true) {
			try{
				System.out.print("Enter age : ");
				int age = Integer.parseInt(br.readLine());
				if(age < 21 || age > 65) throw new InvalidAgeException(21, 65);
				else return age;
			}catch(InvalidAgeException e){
				//printed in InvalidAgeException class

			}catch(InputMismatchException e){
				System.out.println("Only numbers are allowed in input field...");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public static float readSalary(){
		while(true){
			try{
				System.out.print("Enter salary : ");
				float salary = Float.parseFloat(br.readLine());
				if(salary <= 0) throw new InvalidSalaryException();
				else return salary;
			}catch(InvalidSalaryException e){

			}catch(InputMismatchException e){
				System.out.println("Only numbers are allowed in input field...");

			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public static int readId(){
		while(true){
			try{
				System.out.print("-> ");
				int id = Integer.parseInt(br.readLine());
				return id;
			}catch(InputMismatchException e){
				System.out.println("Only numbers are allowed in input field...");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public static String readDesignation(){
		while(true){
			try{
				System.out.print(" -> ");
				String name = br.readLine();
				return name.toUpperCase();
			}catch(InputMismatchException e){
				System.out.println("Name should be a valid string....");
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}

	public static boolean closeReader(){
		try{
			br.close();
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
}
