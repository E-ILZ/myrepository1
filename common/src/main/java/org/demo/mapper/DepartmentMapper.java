package org.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.demo.pojo.Department;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    public List<Department> getAllDepartment(@Param("departmentName")String departmentName,
                                             @Param("remarks")String remarks);

    public int addDepartment(Department department);

    public int deleteDepartment(@Param("id")Integer id);

    public int updateDepartment(Department department);

    public Department getDepartmentById(@Param("id")Integer id);
}
