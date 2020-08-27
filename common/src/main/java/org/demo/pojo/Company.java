package org.demo.pojo;

import java.io.Serializable;

public class Company implements Serializable {

    private int id;    //单位编号
    private String companyName;  //单位名称
    private String remarks;    //备注

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
