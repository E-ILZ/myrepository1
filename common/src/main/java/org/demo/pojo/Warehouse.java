package org.demo.pojo;

import java.io.Serializable;
import java.util.Date;

public class Warehouse implements Serializable {

    private int id;   //仓库编号
    private String name;  //仓库名称
    private Date leaseTime;   //租聘时间
    private int type;  //仓库类型
    private int departmentID; //所属部门
    private String address; //地址
    private String area;  //面积
    private String contacts; //联系人
    private String phone;  //电话
    private int disable;  //是否禁用
    private int defaults;  //是否默认
    private String effect; //作用

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(Date leaseTime) {
        this.leaseTime = leaseTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDisable() {
        return disable;
    }

    public void setDisable(int disable) {
        this.disable = disable;
    }

    public int getDefaults() {
        return defaults;
    }

    public void setDefaults(int defaults) {
        this.defaults = defaults;
    }
}
