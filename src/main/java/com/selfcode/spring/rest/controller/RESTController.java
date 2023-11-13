package com.selfcode.spring.rest.controller;

import com.selfcode.spring.rest.entity.Employee;
import com.selfcode.spring.rest.exception.NoSuchDataException;
import com.selfcode.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showEmps() {
        List<Employee> allEmps = employeeService.getAllEmps();
        return allEmps;
    }

    @GetMapping("/employees/{id}")
    public Employee showEpmById(@PathVariable int id) {
        Employee employee = employeeService.getEmp(id);
        if (employee == null) {
            throw new NoSuchDataException("Employee with ID " + id + " doesn't exist.");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee newEmp(@RequestBody Employee employee){
        employeeService.saveEmps(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee upEmp(@RequestBody Employee employee){
        employeeService.saveEmps(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmp(@PathVariable int id){
        if (employeeService.getEmp(id) != null) {
            employeeService.deleteEmp(id);
            return "Employee with ID " + id + " was deleted.";
        }
        throw new NoSuchDataException("Employee with ID " + id + " doesn't exist.");
    }
}