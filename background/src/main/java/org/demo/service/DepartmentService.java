package org.demo.service;

import org.apache.ibatis.annotations.Param;
import org.demo.mapper.DepartmentMapper;
import org.demo.pojo.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentService {

    @Resource
    private DepartmentMapper mapper;

    public List<Department> getAllDepartment(String departmentName,String remarks){
        return mapper.getAllDepartment(departmentName,remarks);
    }

    public int addDepartment(Department department){
        return mapper.addDepartment(department);
    }

    public int deleteDepartment(Integer id){
        return mapper.deleteDepartment(id);
    }

    public int updateDepartment(Department department){
        return mapper.updateDepartment(department);
    }

    public Department getDepartmentById(Integer id){
        return mapper.getDepartmentById(id);
    }
}
