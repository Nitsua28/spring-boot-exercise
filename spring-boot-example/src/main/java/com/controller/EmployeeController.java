package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.service.EmployeeService;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    // insert service here

    // we do a post mapping for inserting new data
    @PostMapping()
    public Employee insert(@RequestBody Employee employee) {
        return employeeService.insert(employee);
    }

    // configuring this method to run when we send a get request to the end point /pets
    // http://localhost:8080/pets => [list of pets]
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Employee> getAll(@RequestParam(required = false, value = "flag") String flag) {
        // if we don't pass in a request parameter flag, we should just get all pets
        if(flag == null) return employeeService.getAll();
        // Otherwise, call the overloaded method:
        else return employeeService.getAll(flag);
    }

    // @GetMapping is basically a shortcut for @RequestMapping method = RequestMethod.Get):
    // REST rule: for specific pet, we just add the id as a path variable instead of having a totally
    //separate endpoint:
//    @GetMapping("/{petId}")
//    // just make sure that the value passed into @PathVariable matches what we have in the request
//    public Pet getById(@PathVariable("petId") Long id) {
//        return petService.getById(id);
//    }
//
//    @GetMapping("/{petName}")
//    public List<Pet> getByName(@PathVariable("petName") String name) {
//        return petService.findByName(name);
//    }
    @GetMapping("/{employeeIdentifier}")
    public Employee getByIdOrName(@PathVariable("employeeIdentifier") String identifier) {
        try {
            Long id = Long.parseLong(identifier);
            return employeeService.getById(id);
        } catch(Exception e) {
            return employeeService.findByName(identifier).get(0);
        }
    }

    //@RequestMapping (value = "", method = RequestMethod.PUT, produces = "application/json" )
    @PutMapping()
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return employeeService.delete(id);
    }
}