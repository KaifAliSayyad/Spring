package emp.storage;
import java.text.DecimalFormat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;

import emp.utils.*;

public class DatabaseOperations implements EmployeeDAO{
	
	private static final DatabaseOperations db = new DatabaseOperations();
	private DatabaseOperations() {}
	public static DatabaseOperations getObject() {
		return db;
	}
	
	private static MongoCollection<Document> employeeCollection = null;
	private static MongoCollection<Document> designationCollection = null;
	private static MongoCollection<Document> departmentCollection = null;
	
	public boolean establishConnection() {
		try {
			employeeCollection = DBConnection.getCollection("mydb", "employee");
			designationCollection = DBConnection.getCollection("mydb", "designation");
			departmentCollection = DBConnection.getCollection("mydb", "department");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean closeConnection() {
		try {
			DBConnection.closeClient();
			Menu.closeReader();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public Map<Integer, String> loadDesignations(){
        try{

    		FindIterable<Document> i = designationCollection.find();
            Map<Integer, String> design = new HashMap<>();
            for(Document d : i) {
            	design.put(d.getInteger("designation_id"), (String) d.get("designation_name"));
            }

            return design;
        }catch(Exception e){
            System.out.println("Some error occured while loading designations. Please restart the app! ERROR : "+e);
            return null;
        }
    }

    public Map<Integer, String> loadDepartments(){
    	try{
    		FindIterable<Document> i = departmentCollection.find();
            Map<Integer, String> design = new HashMap<>();
            for(Document d : i) {
            	design.put(d.getInteger("department_id"), (String) d.get("department_name"));
            }

            return design;
        }catch(Exception e){
            System.out.println("Some error occured while loading departments. Please restart the app! ERROR : "+e);
            return null;
        }
    }
    
    public String addDesignation(){
        try{
        	System.out.print("Enter the id for new Designation ");
        	int id = Menu.readId();
            System.out.print("Enter the name of new designation ");
            String design = Menu.readDesignation();
            if(designationCollection.find(Filters.eq("designation_name", design.toUpperCase())).first() == null) designationCollection.insertOne(new Document().append("designation_id", id).append("designation_name", design.toUpperCase()));
            else {
            	System.out.println("Designation already present!");
            	return design;
            }
            
            System.out.println("Designation added successfully!!");
            return design;
        }catch(Exception e){
            System.out.println("Some error occured while adding new designation. "+e);
        }
        return "";
    }

	public boolean add(String designation_name, String department_name) {
		// TODO Auto-generated method stub
		int id = -1;
		while(true) {
			System.out.print("Enter the id of the new Employee..");
			id = Menu.readId();
			if(employeeCollection.find(Filters.eq("_id", id)).first() != null) {
				System.out.println("Employee already present..");
			}else {
				break;
			}
		}
		String name = Menu.readName();
        int age = Menu.readAge(21, 65);
        float salary = Menu.readSalary();
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        salary = Float.parseFloat(df.format(salary));

        try{
        	Document doc = new Document();
        	doc.append("_id", id);
        	doc.append("name", name);
        	doc.append("age", age);
        	doc.append("salary", salary);
        	doc.append("designation_name", designation_name);
        	doc.append("department_name", department_name);
            employeeCollection.insertOne(doc);

            System.out.println("Employee added to the database.");
            return true;
        }catch(Exception e){
            System.out.println("Error : failed to add employee. "+e);
            return false;
        }
	}

	@Override
	public FindIterable<Document> getRecords(String order_by) {
		// TODO Auto-generated method stub
		Bson sort = Sorts.ascending(order_by);
		FindIterable<Document> emps = employeeCollection.find().sort(sort);
		printEmployees(emps);
		return emps;
	}

	@Override
    public void printEmployees(FindIterable<Document> i){
        try{
            if(i.first() == null){
                return;
            }
            for(Document emp : i){
                printEmployee(emp);
            }
        }catch(Exception e){
            System.out.println("Error occured while printing!! Try again. ERROR :"+e);
            return;
        }
    }

    private void printEmployee(Document emp){
        System.out.println("-----------------------------------------------------------");
        System.out.println("ID\t\t: "+emp.get("_id"));
        System.out.println("Name\t\t: "+emp.get("name"));
        System.out.println("Age\t\t: "+emp.get("age"));
        System.out.println("Salary\t\t: "+emp.get("salary"));
        System.out.println("Designation\t: "+emp.get("designation_name"));
        System.out.println("Department\t: "+emp.get("department_name"));
        System.out.println("-----------------------------------------------------------");
    }

	@Override
	public boolean updateSalary() {
		// TODO Auto-generated method stub
		 try{
	            System.out.print("Enter the ID of the employee you want to increment salary of ");
	            int id = Menu.readId();
	            Document emp = employeeCollection.find(Filters.eq("id", id)).first();
	            if(emp == null) {
	            	System.out.println("No Employee was found with id = "+id);
	            	return false;
	            }
	            
	            float salary = (float)0.00;

	            salary = (Float)emp.get("salary");
	            
	            System.out.print("Enter the increment amount ");
	            float inc = Menu.readSalary();
	            salary += Math.max(0, inc);

	            DecimalFormat df = new DecimalFormat("0.00");
	            df.setMaximumFractionDigits(2);

	            salary = Float.parseFloat(df.format(salary));

	            employeeCollection.updateOne(Filters.eq("_id" , id), Updates.set("salary" , salary));
	            System.out.println("Salary of employee updated.");
	            return true;
	        }catch(Exception e){
	            e.printStackTrace();
	            return false;
	        }
	}

	@Override
	public Document search() {
		// TODO Auto-generated method stub
		System.out.print("Enter the ID of the employee you want to search for");
        int id = Menu.readId();
        Document emp = employeeCollection.find(Filters.eq("_id", id)).first();
        printEmployee(emp);
        return emp;
	}	
	
	@Override
	public boolean delete() {
		System.out.print("Enter the ID of the employee you want to search for");
        int id = Menu.readId();
        employeeCollection.findOneAndDelete(Filters.eq("_id", id));
        return true;
	}
	
}