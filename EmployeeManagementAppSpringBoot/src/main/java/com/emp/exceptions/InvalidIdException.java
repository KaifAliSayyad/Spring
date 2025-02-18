package com.emp.exceptions;


public class InvalidIdException extends RuntimeException{
    public InvalidIdException(){
        System.out.println("Please enter a valid id..");
    }

    public InvalidIdException(String e){
        System.out.println("Please enter a valid id..");
    }
}