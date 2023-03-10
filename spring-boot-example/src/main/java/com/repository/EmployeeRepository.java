package com.repository;

import com.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// extend the Jpa Repository and also declaring which entity this repository is responsible for managing
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // We don't see a lot of methods in here because they are inherited from the parents

    // how do we make our own queries:
    // native query means we want psql syntax as opposed to HQL (Hibernate Query Language)
    // We can use @Query to manually write some SQL code:
    //@Query(value = "SELECT * FROM employees", nativeQuery = true)
    //public List<Employee> findEmployees();

    // Derived query, should deduce what we want just based on the method name:
    // https://www.baeldung.com/spring-data-derived-queries
    List<Employee> findByName(String name);


}
