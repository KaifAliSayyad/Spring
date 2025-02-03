import java.util.*;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import emp.utils.EmployeeUtils;

import emp.storage.DatabaseOperations;
import java.io.*;
import java.sql.*;
import emp.storage.DatabaseOperations;
import emp.utils.Menu;
import emp.utils.EmployeeUtils;


public class EmployeeManagementApp {
    private static Map<Integer, String> designations = new HashMap<>();
    private static Map<Integer, String> departments = new HashMap<>();
  
    public static void main(String[] args){
        EmployeeUtils emp = EmployeeUtils.getObject();
        designations = emp.loadDesignations();
        departments = emp.loadDepartments();

        if(true){
            while(true){
                System.out.println("-----------------------------------------------------------");
                System.out.println("1. Create");
                System.out.println("2. Display");
                System.out.println("3. Appraisal");
                System.out.println("4. Search");
                System.out.println("5. Remove");
                System.out.println("6. Exit");
                System.out.print("->");                
                int choice = Menu.readChoice(6);
                System.out.println("-----------------------------------------------------------");

                switch (choice) {
                    case 1:
                        while(emp.create(designations, departments));
                        break;
                    case 2:
                        while(emp.display());
                        break;
                    case 3:
                        emp.appraisal();
                        break;
                    case 4:
                        emp.search();
                        break;
                    case 5:
                        emp.remove();
                        break;
                    case 6:
                        emp.closeConnection();
                        System.out.println("Exitting...");
                        System.exit(0);
                    break;
                    default : 
                        System.out.println("Invalid option!!");
                        System.exit(0);
                }
            }
        }else{
            System.exit(0);
        }     
    }
}
