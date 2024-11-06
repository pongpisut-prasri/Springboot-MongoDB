package com.spring.employeeManagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "emp_data")
public class Employee {
    @Id
    @Column
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "uuid2")
    private String id;
    
    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_surname")
    private String surname;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;
}
