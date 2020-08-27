package org.demo.service;

import org.apache.ibatis.annotations.Param;

import org.demo.mapper.CompanyMapper;
import org.demo.pojo.Company;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyService {

    private int pageSize = 5;

    @Resource
    private CompanyMapper mapper;

    public List<Company> getAllCompany(Integer id,String companyName,Integer page){

        return mapper.getAllCompany(id,companyName,(page-1)*pageSize);
    }

    public int addCompany(Company company){
        return mapper.addCompany(company);
    }

    public int deleteCompany(Integer id){
        return mapper.deleteCompany(id);
    }

    public int updateCompany(Company company){
        return mapper.updateCompany(company);
    }

    public Company getCompanyById(Integer id){
        return mapper.getCompanyById(id);
    }
}
