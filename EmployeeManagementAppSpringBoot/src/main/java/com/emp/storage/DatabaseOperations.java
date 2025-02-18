package com.emp.storage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.JdbcRowSet;

import com.emp.models.Employee;
import com.emp.utils.Menu;

public class DatabaseOperations {

    private static final JdbcRowSet rs;

    static{
        rs = DBConnection.rs;
    }

    public static boolean add(Employee emp){
        
        try{
            rs.setCommand("select * from employee limit 1");
            rs.execute();
            rs.moveToInsertRow();
            rs.updateString("name", emp.getName());
            rs.updateInt("age", emp.getAge());
            rs.updateFloat("salary", emp.getSalary());
            rs.updateInt("designation",emp.getDesignation());
            rs.updateInt("department", emp.getDepartment());
            rs.insertRow();

            System.out.println("Employee added to the database.");
            return true;
        }catch(Exception e){
            System.out.println("Error : failed to add employee. "+e);
            return false;
        }
    }

    public static Map<Integer, String> loadDesignations(){
        try{
            rs.setCommand("select * from designation_table");
            rs.execute();
            Map<Integer, String> desing = new HashMap<>();
            while(rs.next()){
                desing.put(rs.getInt(1), rs.getString(2));
            }

            return desing;
        }catch(Exception e){
            System.out.println("Some error occured while loading designations. Please restart the app! ERROR : "+e);
            return null;
        }
    }

    public static Map<Integer, String> loadDepartments(){
        try{
            rs.setCommand("select * from department_table");
            rs.execute();
            Map<Integer, String> department = new HashMap<>();
            while(rs.next()){
                department.put(rs.getInt(1), rs.getString(2));
            }

            return department;
        }catch(Exception e){
            System.out.println("Some error occured while loading departments. Please restart the app! ERROR : "+e);
            return null;
        }
    }

    public static int addDesignation(){
        int new_id = -1;
        try{
            System.out.print("Enter the name of new designation ");
            String design = Menu.readDesignation();
            rs.setCommand("insert into designation_table(designation_name) values ('?')");
            rs.execute();
            rs.moveToInsertRow();
            rs.setString(1, design);
            rs.insertRow();
            System.out.println("Designation added successfully!!");
            rs.setCommand("select designation_id from designation_table where designation_name = '"+design+"'");
            rs.execute();
            while(rs.next()){
                new_id = rs.getInt(1);
            }

            return new_id;
        }catch(Exception e){
            System.out.println("Some error occured while adding new designation. "+e);
        }
        return new_id;
    }

    public static List<List<String>> getRecords(String order_by){
        try{
            String query = "select e.eid, e.name, e.age, e.salary, ds.designation_name, dp.department_name from employee e join designation_table as ds on e.designation = ds.designation_id join department_table as dp on e.department = dp.department_id order by "+order_by;
            String query1 = "select e.eid, e.name, e.age, e.salary, ds.designation_name, dp.department_name from employee e join designation_table as ds on e.designation = ds.designation_id join department_table as dp on e.department = dp.department_id order by ds.designation_name";
            if(order_by.equals("designation")) query = query1;
            rs.setCommand(query);
            rs.execute();
            List<List<String>> employees = new ArrayList<>();
            while(rs.next()){
                List<String> temp  = new ArrayList<>();
                temp.add(rs.getString(1));
                temp.add(rs.getString(2));
                temp.add(rs.getString(3));
                temp.add(rs.getString(4));
                temp.add(rs.getString(5));
                temp.add(rs.getString(6));
                employees.add(temp);
            }


            return employees;
        }catch(Exception e){
            System.out.println("Cannot fetch records from database. ERROR :"+e);
            return null;
        }
    }

    public static void updateSalary(){
        try{
            System.out.print("Enter the ID of the employee you want to increment salary of ");
            int id = Menu.readId();
            rs.setCommand("select salary from employee where eid = "+id);
            rs.execute();
            float salary = (float)0.00;

            while(rs.next()) salary = rs.getFloat(1);
            if(salary == 0.00f){
                throw new Exception("Employee not present");
            }
            System.out.print("Enter the increment amount ");
            float inc = Menu.readSalary();
            salary += Math.max(0, inc);

            DecimalFormat df = new DecimalFormat("0.00");
            df.setMaximumFractionDigits(2);

            salary = Float.parseFloat(df.format(salary));

            rs.setCommand("select * from employee where eid = ?");
            rs.setInt(1, id);
            rs.execute();
            if(rs.next()){
                System.out.println(rs.getString(4));
                rs.updateFloat("salary", salary);
                rs.updateRow();
            }
            System.out.println("Salary of employee updated.");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(){
        try{
            System.out.print("Enter the id of the employee you want to remove ");
            int id = Menu.readId();
            
            rs.setCommand("select eid from employee where eid ="+id);
            rs.execute();
            int eid = -1;
            while(rs.next()) eid = rs.getInt(1);
            if(eid == -1) throw new Exception("No employee present..");

            System.out.println("Do you really want to delete this employee? (1. Yes/ 2. No)");
            int confirm = Menu.readChoice(2);
            if(confirm == 1){
                rs.setCommand("delete from employee where eid = "+id);
                rs.execute();
                // System.out.println(affected+" employee deleted successfully.");
            }else{
                System.out.println("Employee deletetion cancelled!!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> searchEmployee(){
        try{
            System.out.print("Enter the id of the employee you want to search ");
            int id = Menu.readId();
            String query = "select e.eid, e.name, e.age, e.salary, ds.designation_name, dp.department_name from employee e join designation_table as ds on e.designation = ds.designation_id join department_table as dp on e.department = dp.department_id where eid = "+id;
            rs.setCommand(query);
            rs.execute();

            List<String> temp = new ArrayList<>();
            while(rs.next()){
                temp.add(rs.getString(1));
                temp.add(rs.getString(2));
                temp.add(rs.getString(3));
                temp.add(rs.getString(4));
                temp.add(rs.getString(5));
                temp.add(rs.getString(6));
            }

            if(temp.size() == 0) throw new Exception("No employees present..");
            return temp;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static boolean closeConnection(){
        return DBConnection.closeConnection() && Menu.closeReader();
    }

}
