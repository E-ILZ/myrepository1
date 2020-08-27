package org.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.demo.pojo.Company;
import org.demo.pojo.Warehouse;
import org.demo.service.CompanyService;
import org.demo.vo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "单位管理类控制器")
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @ApiOperation(value = "获取所有的单位信息")
    @RequestMapping(value = "/getAllCompany",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "编号",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="companyName",value = "单位名称",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="page",value = "页数",dataType = "int",paramType = "query"),
    })
    public ResponseData<List<Company>> getAllWarehouse(Integer id, String companyName, Integer page){

        ResponseData<List<Company>> responseData = new ResponseData<List<Company>>();

        List<Company> companyList = service.getAllCompany(id,companyName,page);

        if(companyList.size() != 0){
            responseData.setStatus(200);
            responseData.setMessage("查询成功！");
            responseData.setData(companyList);
        }else{
            responseData.setStatus(500);
            responseData.setMessage("错误！");
        }

        return responseData;
    }


    @ApiOperation(value = "根据ID获取单位信息")
    @RequestMapping(value = "/getCompanyById",method = RequestMethod.GET)
    public ResponseData<Company> getCompanyById(int id){

        ResponseData<Company> responseData = new ResponseData<Company>();

        Company company = service.getCompanyById(id);
        if(company != null){
            responseData.setStatus(200);
            responseData.setMessage("查询成功！");
            responseData.setData(company);
        }else{
            responseData.setStatus(500);
            responseData.setMessage("失败！");
        }

        return responseData;
    }


    @ApiOperation(value = "添加单位信息")
    @RequestMapping(value = "/addCompany",method = RequestMethod.POST)
    public ResponseData<Company> addCompany(Company company){
        ResponseData responseData = new ResponseData();

        int count = service.addCompany(company);

        if(count > 0){
            responseData.setStatus(200);
            responseData.setMessage("添加成功！");
        }else{
            responseData.setStatus(500);
            responseData.setMessage("添加失败！");
        }

        return responseData;

    }


    @ApiOperation(value = "删除单位信息")
    @RequestMapping(value = "/deleteCompany",method = RequestMethod.DELETE)
    public ResponseData deleteCompany(int id){
        ResponseData responseData = new ResponseData();

        int count = service.deleteCompany(id);

        if(count > 0){
            responseData.setStatus(200);
            responseData.setMessage("删除成功！");
        }else{
            responseData.setStatus(500);
            responseData.setMessage("删除失败！");
        }

        return responseData;
    }

    @ApiOperation(value = "修改单位信息")
    @RequestMapping(value = "/updateCompany",method = RequestMethod.POST)
    public ResponseData updateCompany(@RequestBody Company company){
        ResponseData responseData = new ResponseData();

        int count = service.updateCompany(company);

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
