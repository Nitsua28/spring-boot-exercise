package com.service;

import com.entity.Employee;
import com.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Because we have 2 different implementations of the PetService interface
// we need to declare this as primary so Spring knows which implementation
// to autowire
//@Primary
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Employee insert(Employee pet) {
        // From the petRepository, we get the save method
        return employeeRepository.save(pet);
    }

    @Override
    public Employee getById(Long id) {
        // findById returns an Optional of the value so we need to .get() the value from that:
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public boolean delete(Long id) {
        boolean found = employeeRepository.existsById(id);
        // only try to delete the pet if id is found:
        if(found) employeeRepository.deleteById(id);
        return found;
    }

    @Override
    public List<Employee> getAll(String flag) {
        System.out.println(flag);
        // this overloaded method takes in a flag and calls the corresponding Repository method:
        switch(flag) {
            case "cats":
                //return employeeRepository.findAll();
            default:
                return employeeRepository.findAll();
        }
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

}
