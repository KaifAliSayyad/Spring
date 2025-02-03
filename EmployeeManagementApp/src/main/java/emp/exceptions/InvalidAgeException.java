package emp.exceptions;


public class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(){

    }


    public InvalidAgeException(int minAge, int maxAge){
        System.out.println("Age should be between "+minAge+" - "+maxAge);
    }
    public InvalidAgeException(String e){

    }
}
