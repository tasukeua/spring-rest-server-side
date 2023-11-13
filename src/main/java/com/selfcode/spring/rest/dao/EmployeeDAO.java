package com.selfcode.spring.rest.dao;

import com.selfcode.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmps();

    public void saveEmps(Employee employee);

    public Employee getEmp(int id);

    void deleteEmp(int id);
}
