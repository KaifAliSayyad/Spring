package com.emp.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.emp.storage.DatabaseOperations;

public class EmployeeUtils implements EmployeeDAO{

    private static EmployeeUtils emp = null;

    private EmployeeUtils(){

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
        if(designation_no == n+2)
        return false;
        
        Set<Integer> keySet2 = departments.keySet();
        Object[] department_ids = keySet2.toArray();
        int n1 = departments.size();
        System.out.println("Select the department of the Employee. ");
        for(int i = 1 ; i <= n1; i++){
            System.out.println(i+". "+departments.get((Integer)(department_ids[i-1])));
        }
        System.out.print("-> ");
        int department_no = Menu.readChoice(n1);

        int desig_id = -1;
        int depart_id = -1;
        if(designation_no == n+1){
            desig_id = DatabaseOperations.addDesignation();
            designations = DatabaseOperations.loadDesignations();
        }else{
            desig_id = (Integer)(designation_ids[designation_no-1]);
        }

        depart_id = (Integer)(department_ids[department_no-1]);

        if(!DatabaseOperations.add(desig_id, depart_id)){
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
            case 1 -> "eid";
            case 2 -> "name";
            case 3 -> "designation";
            case 4 -> "age";
            case 5 -> "salary";
            case 6 -> {yield null;}
            default -> {yield null;}
        };

        if(order_by == null){
            return false;
        }else{
            List<List<String>> rs = DatabaseOperations.getRecords(order_by);
            printEmployees(rs);
            return true;
        }
    }

    public void printEmployees(List<List<String>> rs){
        try{
            if(rs.size() == 0){
                return;
            }
            for(List<String> emp : rs){
                printEmployee(emp);
            }
        }catch(Exception e){
            System.out.println("Error occured while printing!! Try again. ERROR :"+e);
            return;
        }
    }

    private void printEmployee(List<String> emp){
        System.out.println("-----------------------------------------------------------");
        System.out.println("ID\t\t: "+emp.get(0));
        System.out.println("Name\t\t: "+emp.get(1));
        System.out.println("Age\t\t: "+emp.get(2));
        System.out.println("Salary\t\t: "+emp.get(3));
        System.out.println("Designation\t: "+emp.get(4));
        System.out.println("Department\t: "+emp.get(5));
        System.out.println("-----------------------------------------------------------");
    }

    public void appraisal(){
        DatabaseOperations.updateSalary();
    }

    public void search(){
        List<String> employee = DatabaseOperations.searchEmployee();
        printEmployee(employee);
    }
    
    public void remove(){
        DatabaseOperations.deleteEmployee();
    }

    public void closeConnection(){
        DatabaseOperations.closeConnection();
    }

    public static EmployeeUtils getObject(){
        if(emp == null) emp = new EmployeeUtils();
        return emp;
    }
}
