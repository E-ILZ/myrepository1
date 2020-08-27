package org.demo.service;

import org.apache.ibatis.annotations.Param;
import org.demo.mapper.WarehouseMapper;
import org.demo.pojo.Warehouse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WarehouseService {

    private int pageSize = 5;

    @Resource
    private WarehouseMapper mapper;

    public List<Warehouse> getAllWarehouse(Integer id,String name,
                                           Integer departmentID,Integer type,Integer page){

        return mapper.getAllWarehouse(id,name,departmentID,type,(page-1)*pageSize);
    }

    public int addWarehouse(Warehouse warehouse){
        return mapper.addWarehouse(warehouse);
    }

    public int deleteWarehouse(Integer id){
        return mapper.deleteWarehouse(id);
    }

    public int updateWarehouse(Warehouse warehouse){
        return mapper.updateWarehouse(warehouse);
    }

    public Warehouse getWareById(Integer id){
        return mapper.getWareById(id);
    }
}
