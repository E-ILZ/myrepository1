package org.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.demo.pojo.Warehouse;

import java.util.List;

@Mapper
public interface WarehouseMapper {

    public List<Warehouse> getAllWarehouse(@Param("id") Integer id,@Param("name")String name,
                                           @Param("departmentID") Integer departmentID,
                                           @Param("type") Integer type,@Param("page")Integer page);

    public int addWarehouse(Warehouse warehouse);

    public int deleteWarehouse(@Param("id")Integer id);

    public int updateWarehouse(Warehouse warehouse);

    public Warehouse getWareById(@Param("id")Integer id);
}
