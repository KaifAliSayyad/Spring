package emp.utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class Patterns{
    public static boolean validateName(String name){
        
        String regularExpression = "^[A-Z][a-z]+ [A-Z][a-z]+$";
        Pattern p1 = Pattern.compile(regularExpression);
        Matcher m1 = p1.matcher(name);
        // System.out.println(m1.find());
        return m1.find();
    }
    public static void main(String[] args) {
        System.out.println(Patterns.validateName("Kaif        Ali"));
    }
}