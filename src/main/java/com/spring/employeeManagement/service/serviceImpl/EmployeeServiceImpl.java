package com.spring.employeeManagement.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employeeManagement.dto.request.EmployeeEditReq;
import com.spring.employeeManagement.dto.response.BaseResponse;
import com.spring.employeeManagement.entity.Employee;
import com.spring.employeeManagement.repository.EmployeeRepository;
import com.spring.employeeManagement.service.EmployeeService;

import io.micrometer.common.util.StringUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public BaseResponse editEmployee(EmployeeEditReq req) {
        Optional<Employee> employee =  employeeRepository.findById(StringUtils.isEmpty(req.getId())? "":req.getId());
        if (employee.isPresent()) {
            employee.get().setName(req.getName());
            employee.get().setSurname(req.getSurname());
            employeeRepository.save(employee.get());
        }else{
            Employee entity = new Employee();
            BeanUtils.copyProperties(req, entity);
            employeeRepository.save(entity);
        }
        return new BaseResponse();
    }
    
}
