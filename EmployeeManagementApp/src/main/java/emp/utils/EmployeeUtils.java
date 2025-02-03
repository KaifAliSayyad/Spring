package emp.utils;

import java.util.*;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import emp.storage.DatabaseOperations;
import emp.utils.EmployeeDAO;

public class EmployeeUtils{
	
	private static DatabaseOperations db = null;

    private static EmployeeUtils emp = null;

    private EmployeeUtils(){
    	db = DatabaseOperations.getObject();
    	db.establishConnection();
    }
    
    public Map<Integer, String> loadDesignations(){
    	return db.loadDesignations();
    }
    
    public Map<Integer, String> loadDepartments(){
    	return db.loadDepartments();
    }
    public boolean create(Map<Integer, String> designations, Map<Integer, String> departments){
        Set<Integer> keySet1 = designations.keySet();
        Object[] designation_ids = keySet1.toArray();
        int n = designation_ids.length;
        System.out.println("Select the designation of the Employee. ");
        for(int i = 1 ; i <= n; i++){
            System.out.println(i+". "+designations.get((Integer)(designation_ids[i-1])));
        }
        System.out.println((n+1)+". Others");
        System.out.println((n+2)+". Exit");
        System.out.print("-> ");
        int designation_no = Menu.readChoice(n+2);
        if(designation_no == n+2) {
        	return false;
        }
        
        
        Set<Integer> keySet2 = departments.keySet();
        Object[] department_ids = keySet2.toArray();
        int n1 = departments.size();
        System.out.println("Select the department of the Employee. ");
        for(int i = 1 ; i <= n1; i++){
            System.out.println(i+". "+departments.get((Integer)(department_ids[i-1])));
        }
        System.out.print("-> ");
        int department_no = Menu.readChoice(n1);

        String designation_name = "";
        String department_name = "";
        department_name = departments.get(department_no);
        
        System.out.println((n+1)+", "+designation_no);
        if(designation_no == n+1){
        	
        	designation_name = db.addDesignation();
            designations = db.loadDesignations();
            
        }else {
        	designation_name = designations.get(designation_no);
        }

        
        if(!db.add(designation_name, department_name)){
            return false;
        }else{
            return true;
        }
    }

    public boolean display(){
        System.out.println("1. By ID");
        System.out.println("2. Name");
        System.out.println("3. Designation");
        System.out.println("4. Age");
        System.out.println("5. Salary");
        System.out.println("6. Exit");
        System.out.print("->");
        int choice = Menu.readChoice(6);
        String order_by = switch(choice){
            case 1 -> "_id";
            case 2 -> "name";
            case 3 -> "designation_name";
            case 4 -> "age";
            case 5 -> "salary";
            case 6 -> {yield null;}
            default -> {yield null;}
        };

        if(order_by == null){
            return false;
        }else{
            FindIterable<Document> i = db.getRecords(order_by);
            return true;
        }
    }

    public void appraisal(){
        db.updateSalary();
    }

    public void search(){
        Document employee = db.search();
    }
    
    public void remove(){
        db.delete();
    }

    public void closeConnection(){
        db.closeConnection();
    }

    public static EmployeeUtils getObject(){
        if(emp == null) {
        	
        	emp = new EmployeeUtils();
        }
        return emp;
    }
}
