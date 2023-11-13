package com.selfcode.spring.rest.dao;

import com.selfcode.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Employee> getAllEmps() {
        Session session = sessionFactory.getCurrentSession();

//        List<Employee> allEmps = session.createQuery("from Employee", Employee.class).getResultList();

        Query<Employee> query = session.createQuery("from Employee" , Employee.class);
        List<Employee> allEmps = query.getResultList();
        return allEmps;
    }

    @Override
    public void saveEmps(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmp(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmp(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee " +
                "where id =:empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
