package com.spring.employeeManagement.entity;

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
@Table(name = "department")
public class Department extends BaseEntity{

    @Id
    @Column(updatable = false,length = 50)
    @GenericGenerator(name = "uuid2",strategy  = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "uuid2")
    private String id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_name_en")
    private String departmentNameEn;

    @Column(name = "department_code")
    private String departmentCode;
}
