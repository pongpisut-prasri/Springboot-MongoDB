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
import com.spring.employeeManagement.dto.request.DepartmentEditReq;
import com.spring.employeeManagement.dto.request.DepartmentGetReq;
import com.spring.employeeManagement.dto.response.BaseResponse;
import com.spring.employeeManagement.dto.response.DepartmentResp;
import com.spring.employeeManagement.entity.Department;
import com.spring.employeeManagement.repository.DepartmentRepository;
import com.spring.employeeManagement.service.DepartmentService;
import com.spring.employeeManagement.utils.Constant.StatusFlag;

import io.micrometer.common.util.StringUtils;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public BaseResponse editDepartment(DepartmentEditReq req) {
        Optional<Department> department = departmentRepository.findById(!StringUtils.isEmpty(req.getDepartmentId())? req.getDepartmentId():"");
            if (department.isPresent()) {
                department.get().setDepartmentCode(req.getDepartmentCode());
                department.get().setDepartmentName(req.getDepartmentName());
                department.get().setDepartmentNameEn(req.getDepartmentNameEn());
                department.get().setUpdateBy(req.getCurrentUserId());
                department.get().setUpdateDate(LocalDateTime.now());
                departmentRepository.save(department.get());
            } else {
                Department entity = new Department();
                BeanUtils.copyProperties(req, entity);
                entity.setCreateBy(req.getCurrentUserId());
                entity.setCreateDate(LocalDateTime.now());
                entity.setStatusFlag(StatusFlag.ACTIVE.getCode());
                departmentRepository.save(entity);
            }
            return new BaseResponse();
    }

    @Override
    @Transactional(readOnly = true)
    public BaseResponse getDepartmentById(DepartmentGetReq req) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDepartmentById'");
    }

    @Override
    @Transactional(readOnly = true)
    public BaseResponse getAllDepartment(BaseRequest req) {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentResp> response = new ArrayList<>();
        if (departments != null && departments.size() > 0) {
            for (Department department : departments) {
                DepartmentResp dto = new DepartmentResp();
                BeanUtils.copyProperties(department, dto);
                response.add(dto);
            }
        }
        return new BaseResponse(response);
    }

}
