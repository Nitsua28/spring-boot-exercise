package com.service;

import java.util.List;

import com.entity.*;

public interface EmployeeService {
    Employee insert(Employee employee);
    Employee getById(Long id);
    List<Employee> getAll();
    Employee update(Employee employee);
    boolean delete(Long id);
    List<Employee> getAll(String flag);
    List<Employee> findByName(String name);
}