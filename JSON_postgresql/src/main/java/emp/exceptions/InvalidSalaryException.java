package emp.exceptions;

public class InvalidSalaryException extends RuntimeException{
    public InvalidSalaryException(){
        System.out.println("Salary cannot be negative..");
    }

    public InvalidSalaryException(String e){
        System.out.println("Salary cannot be negative..");
    }
}