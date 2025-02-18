package com.emp.utils;

import java.util.Map;
import java.util.List;

public interface EmployeeDAO{
    public boolean create(Map<Integer, String> designations, Map<Integer, String> departments);
    public boolean display();
    public void printEmployees(List<List<String>> rs);
    public void appraisal();
    public void search();
    public void remove();
}