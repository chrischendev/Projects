package com.mars.edu.web.model.xio;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:13
 * Use for:
 */
@XlsSheet("student")
public class StudentXio {
    @XlsColumn("编码")
    private String code;
    @XlsColumn("姓")
    private String firstName;
    @XlsColumn("名")
    private String lastName;
    @XlsColumn("年龄")
    private Byte age;
    @XlsColumn("地址")
    private String address;
    @XlsColumn("监护人姓名")
    private String custodianName;
    @XlsColumn("监护人电话")
    private String custodianPhone;
    @XlsColumn("描述")
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustodianName() {
        return custodianName;
    }

    public void setCustodianName(String custodianName) {
        this.custodianName = custodianName;
    }

    public String getCustodianPhone() {
        return custodianPhone;
    }

    public void setCustodianPhone(String custodianPhone) {
        this.custodianPhone = custodianPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
