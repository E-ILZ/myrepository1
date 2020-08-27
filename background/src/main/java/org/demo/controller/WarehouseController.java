package org.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.demo.pojo.Warehouse;
import org.demo.service.WarehouseService;
import org.demo.vo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "仓库管理类控制器")
@RequestMapping(value = "/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService service;

    @ApiOperation(value = "获取所有的仓库信息")
    @RequestMapping(value = "/getAllWarehouse",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "编号",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="name",value = "名称",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="departmentID",value = "部门ID",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="type",value = "仓库类型",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="page",value = "页数",dataType = "int",paramType = "query")
    })
    public ResponseData<List<Warehouse>> getAllWarehouse(Integer id,String name,Integer departmentID,Integer type,Integer page){
        ResponseData<List<Warehouse>> responseData = new ResponseData<List<Warehouse>>();

        List<Warehouse> wareList = service.getAllWarehouse(id,name,departmentID,type,page);

        if(wareList.size() != 0){
            responseData.setStatus(200);
            responseData.setMessage("查询成功！");
            responseData.setData(wareList);
        }else{
            responseData.setStatus(500);
            responseData.setMessage("错误！");
        }

        return responseData;
    }

    @ApiOperation(value = "根据ID获取仓库信息")
    @RequestMapping(value = "/getWareById",method = RequestMethod.GET)
    public ResponseData<Warehouse> getWareById(int id){
        ResponseData<Warehouse> responseData = new ResponseData<Warehouse>();

        Warehouse ware = service.getWareById(id);
        if(ware != null){
            responseData.setStatus(200);
            responseData.setMessage("查询成功！");
            responseData.setData(ware);
        }else{
            responseData.setStatus(500);
            responseData.setMessage("失败！");
        }

        return responseData;
    }


    @ApiOperation(value = "添加仓库信息")
    @RequestMapping(value = "/addWarehouse",method = RequestMethod.POST)
    public ResponseData<Warehouse> addWarehouse(Warehouse warehouse){
        ResponseData responseData = new ResponseData();

        int count = service.addWarehouse(warehouse);

        if(count > 0){
            responseData.setStatus(200);
            responseData.setMessage("添加成功！");
        }else{
            responseData.setStatus(500);
            responseData.setMessage("添加失败！");
        }

        return responseData;

    }


    @ApiOperation(value = "删除仓库信息")
    @RequestMapping(value = "/deleteWarehouse",method = RequestMethod.DELETE)
    public ResponseData deleteWarehouse(int id){
        ResponseData responseData = new ResponseData();

        int count = service.deleteWarehouse(id);

        if(count > 0){
            responseData.setStatus(200);
            responseData.setMessage("删除成功！");
        }else{
            responseData.setStatus(500);
            responseData.setMessage("删除失败！");
        }

        return responseData;
    }

    @ApiOperation(value = "修改仓库信息")
    @RequestMapping(value = "/updateWarehouse",method = RequestMethod.POST)
    public ResponseData updateWarehouse(@RequestBody Warehouse warehouse){
        ResponseData responseData = new ResponseData();

        int count = service.updateWarehouse(warehouse);

        if(count > 0 ){
            responseData.setStatus(200);
            responseData.setMessage("修改成功！");
        }else {
            responseData.setStatus(500);
            responseData.setMessage("修改失败！");
        }

        return responseData;
    }

//    @ApiOperation(value = "登录")
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public ResponseData Login(String user_name, String password){
//        ResponseData responseData = new ResponseData();
//
//        User user = service.login(user_name,password);
//
//        if(user != null){
//            responseData.setStatus(200);
//            responseData.setMessage("登录成功！");
//            responseData.setData(user);
//        }else{
//            responseData.setStatus(500);
//            responseData.setMessage("登录失败！");
//        }
//        return responseData;
//    }
//
//
//    @ApiOperation(value = "获取所有的用户信息")
//    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
//    public ResponseData<List<Users>> getUsers(){
//        ResponseData<List<Users>> responseData = new ResponseData<List<Users>>();
//        try{
//            List<Users> userList = service.getAllUser();
//            responseData.setStatus(200);
//            responseData.setMessage("查询成功！");
//            responseData.setData(userList);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return responseData;
//    }
//
//    @ApiOperation(value = "根据ID获取用户信息")
//    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
//    public ResponseData<Users> getUserById(int id){
//        ResponseData<Users> responseData = new ResponseData<Users>();
//        try{
//            Users user = service.getUserById(id);
//            responseData.setStatus(200);
//            responseData.setMessage("查询成功！");
//            responseData.setData(user);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return responseData;
//    }
//
//
//    @ApiOperation(value = "添加用户")
//    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
//    public ResponseData<Users> addUser(Users user){
//        ResponseData responseData = new ResponseData();
//
//        int count = service.addUser(user);
//
//        if(count > 0){
//            responseData.setStatus(200);
//            responseData.setMessage("添加成功！");
//        }else{
//            responseData.setStatus(500);
//            responseData.setMessage("添加失败！");
//        }
//
//        return responseData;
//
//    }
//
//    @ApiOperation(value = "删除用户")
//    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
//    public ResponseData deleteUser(int id){
//        ResponseData responseData = new ResponseData();
//
//        int count = service.deleteUser(id);
//
//        if(count > 0){
//            responseData.setStatus(200);
//            responseData.setMessage("删除用户成功！");
//        }else{
//            responseData.setStatus(500);
//            responseData.setMessage("删除用户失败！");
//        }
//
//        return responseData;
//    }

}
