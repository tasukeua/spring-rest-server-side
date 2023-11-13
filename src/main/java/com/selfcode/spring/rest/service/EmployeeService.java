package com.selfcode.spring.rest.service;

import com.selfcode.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmps();
    public void saveEmps(Employee employee);
    public Employee getEmp(int id);
    public void deleteEmp(int id);
}
