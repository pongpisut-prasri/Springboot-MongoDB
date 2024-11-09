package com.spring.employeeManagement.entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "emp_data",indexes = {
    @Index(name="idx_employee_name",columnList = "emp_name"),
    @Index(name="idx_employee_department",columnList = "department_id")
})
public class Employee extends BaseEntity{
    @Id
    @Column(updatable = false)
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "uuid2")
    private String id;
    
    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_surname")
    private String surname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "department_id")
    private String departmentId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",nullable = true,insertable = false,updatable = false)
    private Department department;

    public String getFullName(){
        return this.name + " "  +this.surname;
    }
}
