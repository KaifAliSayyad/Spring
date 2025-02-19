package com.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.emp.utils.EmployeeUtils;
import com.emp.utils.Menu;
import com.emp.storage.DatabaseOperations;


@SpringBootApplication
public class EmployeeManagementAppSpringBootApplication {
	public static Map<Integer, String> designations = new HashMap<>();
	public static Map<Integer, String> departments = new HashMap<>();
	

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EmployeeManagementAppSpringBootApplication.class, args);
		
        designations = DatabaseOperations.loadDesignations();
        departments = DatabaseOperations.loadDepartments();
        EmployeeUtils emp = EmployeeUtils.getObject();

        if(designations != null && departments != null && designations.size() > 0 && departments.size() > 0){
            while(true){
                System.out.println("1. Create");
                System.out.println("2. Display");
                System.out.println("3. Appraisal");
                System.out.println("4. Search");
                System.out.println("5. Remove");
                System.out.println("6. Exit");
                System.out.print("->");
                int choice = Menu.readChoice(6);
                
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
