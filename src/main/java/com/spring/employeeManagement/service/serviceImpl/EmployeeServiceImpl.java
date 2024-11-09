package com.spring.employeeManagement.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.employeeManagement.dto.request.BaseRequest;
import com.spring.employeeManagement.dto.request.EmployeeEditReq;
import com.spring.employeeManagement.dto.response.BaseResponse;
import com.spring.employeeManagement.dto.response.EmployeeInformationResp;
import com.spring.employeeManagement.entity.Employee;
import com.spring.employeeManagement.repository.EmployeeRepository;
import com.spring.employeeManagement.service.EmployeeService;
import com.spring.employeeManagement.utils.Constant.HttpResponse;
import com.spring.employeeManagement.utils.Constant.StatusFlag;

import io.micrometer.common.util.StringUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public BaseResponse editEmployee(EmployeeEditReq req) {
        Optional<Employee> employee = employeeRepository.findById(StringUtils.isEmpty(req.getId()) ? "" : req.getId());

        if (employee.isPresent()) {
            employee.get().setName(req.getName());
            employee.get().setSurname(req.getSurname());
            employee.get().setUpdateDate(LocalDateTime.now());
            employee.get().setDepartmentId(req.getDepartmentId());
            employee.get().setDateOfBirth(req.getDateOfBirth());
            if (!StringUtils.isEmpty(req.getStatus())) {
                employee.get().setStatusFlag(req.getStatus());
            }
            employee.get().setUpdateBy(req.getCurrentUserId());
            employeeRepository.save(employee.get());
        } else {
            Employee entity = new Employee();
            BeanUtils.copyProperties(req, entity);
            entity.setCreateDate(LocalDateTime.now());
            entity.setCreateBy(req.getCurrentUserId());
            entity.setStatusFlag(StatusFlag.ACTIVE.getCode());
            employeeRepository.save(entity);
        }
        return new BaseResponse();

    }

    @Override
    @Transactional(readOnly = true)
    public BaseResponse getEmployeeInformation(BaseRequest req) {
        Employee entity = employeeRepository.findById(StringUtils.isEmpty(req.getId()) ? "" : req.getId()).get();
        if (entity != null) {
            EmployeeInformationResp response = new EmployeeInformationResp();
            BeanUtils.copyProperties(entity, response);
            return new BaseResponse(response);
        }
        return new BaseResponse(HttpResponse.BAD_REQUEST.getHttpStatusCode(), HttpResponse.BAD_REQUEST.getStatusCode());
    }

    @Override
    @Transactional(readOnly = true)
    public BaseResponse getEmployeeByDepartment(String departmentId) {
        List<Employee> employeeList = employeeRepository.findByDepartmentId(departmentId);
        List<EmployeeInformationResp> response = new ArrayList<>();
        if (employeeList != null && !employeeList.isEmpty()) {
            for (Employee employee : employeeList) {
                EmployeeInformationResp model = new EmployeeInformationResp();
                BeanUtils.copyProperties(employee, model);
                response.add(model);
            }
        }
        return new BaseResponse(response);
    }

}
