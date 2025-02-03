package emp.utils;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import java.util.List;

public interface EmployeeDAO{
    public boolean add(String designation_name, String department_name);
    public FindIterable<Document> getRecords(String order_by);
    public void printEmployees(FindIterable<Document> i);
    public boolean updateSalary();
    public Document search();
    public boolean delete();
}