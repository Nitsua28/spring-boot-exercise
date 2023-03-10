package com.entity;

import lombok.*;
import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name= "employee_table")
public class Employee {
    @Id
    private Long id;
    private String name;
    private String location;
    private String email;

//    public Employee(String name, String location, String email) {
//        this.name = name;
//        this.location = location;
//        this.email = email;
//    }
}