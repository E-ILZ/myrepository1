package org.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.demo.pojo.Company;

import java.util.List;

@Mapper
public interface CompanyMapper {


    public List<Company> getAllCompany(@Param("id")Integer id,
                                       @Param("companyName")String companyName,
                                       @Param("page")Integer page);

    public int addCompany(Company company);

    public int deleteCompany(@Param("id")Integer id);

    public int updateCompany(Company company);

    public Company getCompanyById(@Param("id")Integer id);
}
