package emp.utils;
import java.util.Map;


import java.util.List;

public interface EmployeeDAO{
    public boolean add(String designation_name, String department_name);
    public List<List<String>> getRecords(String order_by);
    public void printEmployees(List<String> i);
    public boolean updateSalary();
    public List<String> search();
    public boolean delete();
}