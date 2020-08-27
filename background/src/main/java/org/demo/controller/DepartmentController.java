package org.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.demo.pojo.Department;
import org.demo.service.DepartmentService;
import org.demo.vo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "部门管理类控制器")
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @ApiOperation(value = "获取所有的部门信息")
    @RequestMapping(value = "/getAllDepartment",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name="departmentName",value = "部门名称",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="remarks",value = "备注",dataType = "String",paramType = "query"),
    })
    public ResponseData<List<Department>> getAllDepartment(String departmentName, String remarks){

        ResponseData<List<Department>> responseData = new ResponseData<List<Department>>();

        List<Department> departmentList = service.getAllDepartment(departmentName,remarks);

        if(departmentList.size() != 0){
            responseData.setStatus(200);
            responseData.setMessage("查询成功！");
            responseData.setData(departmentList);
        }else{
            responseData.setStatus(500);
            responseData.setMessage("错误！");
        }

        return responseData;
    }


    @ApiOperation(value = "根据ID获取部门信息")
    @RequestMapping(value = "/getDepartmentById",method = RequestMethod.GET)
    public ResponseData<Department> getDepartmentById(int id){

        ResponseData<Department> responseData = new ResponseData<Department>();

        Department department = service.getDepartmentById(id);
        if(department != null){
            responseData.setStatus(200);
            responseData.setMessage("查询成功！");
            responseData.setData(department);
        }else{
            responseData.setStatus(500);
            responseData.setMessage("失败！");
        }

        return responseData;
    }


    @ApiOperation(value = "添加部门信息")
    @RequestMapping(value = "/addDepartment",method = RequestMethod.POST)
    public ResponseData<Department> addDepartment(Department department){
        ResponseData responseData = new ResponseData();

        int count = service.addDepartment(department);

        if(count > 0){
            responseData.setStatus(200);
            responseData.setMessage("添加成功！");
        }else{
            responseData.setStatus(500);
            responseData.setMessage("添加失败！");
        }

        return responseData;

    }


    @ApiOperation(value = "删除部门信息")
    @RequestMapping(value = "/deleteDepartment",method = RequestMethod.DELETE)
    public ResponseData deleteDepartment(int id){
        ResponseData responseData = new ResponseData();

        int count = service.deleteDepartment(id);

        if(count > 0){
            responseData.setStatus(200);
            responseData.setMessage("删除成功！");
        }else{
            responseData.setStatus(500);
            responseData.setMessage("删除失败！");
        }

        return responseData;
    }

    @ApiOperation(value = "修改部门信息")
    @RequestMapping(value = "/updateDepartment",method = RequestMethod.POST)
    public ResponseData updateDepartment(@RequestBody Department department){
        ResponseData responseData = new ResponseData();

        int count = service.updateDepartment(department);

        if(count > 0 ){
            responseData.setStatus(200);
            responseData.setMessage("修改成功！");
        }else {
            responseData.setStatus(500);
            responseData.setMessage("修改失败！");
        }

        return responseData;
    }
}
