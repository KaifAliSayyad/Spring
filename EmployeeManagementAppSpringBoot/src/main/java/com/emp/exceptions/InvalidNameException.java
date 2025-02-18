package com.emp.exceptions;

public class InvalidNameException extends RuntimeException{
    public InvalidNameException(){
        System.out.println("error : Invalid name \n1. each word in name should start with capital letter only.\n2. Name can contain only english alphanet letters.\n3. Name should have 2 words");
    }

    public InvalidNameException(String e){
        System.out.println("error : Invalid name \n1. Name should start with capital letter only.\n2. Name can contain only english alphanet letters.\n3. Name can have maximum 2 words");
    }
}