package com.emp.exceptions;


public class InvalidChoiceException extends RuntimeException{
    public InvalidChoiceException(){
        System.out.println("Please enter a valid choice...");

    }

    public InvalidChoiceException(String e){
        System.out.println("Please enter a valid choice...");
    }

    public void displayMessage(int maxChoice){
        System.out.println("Enter a valid choice between 1 - "+maxChoice);
    }
}
