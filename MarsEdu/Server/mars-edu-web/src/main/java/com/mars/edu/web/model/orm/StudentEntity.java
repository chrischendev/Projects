package com.mars.edu.web.model.orm;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:13
 * Use for:
 */
@Entity
@Table(name = "sch_student", schema = "db_mars_edu", catalog = "")
public class StudentEntity {
    private int id;
    private String code;
    private String firstName;
    private String lastName;
    private Byte age;
    private String address;
    private String custodianName;
    private String custodianPhone;
    private String description;
    private byte status;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 20)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 4)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 10)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 128)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "custodian_name", nullable = true, length = 20)
    public String getCustodianName() {
        return custodianName;
    }

    public void setCustodianName(String custodianName) {
        this.custodianName = custodianName;
    }

    @Basic
    @Column(name = "custodian_phone", nullable = true, length = 20)
    public String getCustodianPhone() {
        return custodianPhone;
    }

    public void setCustodianPhone(String custodianPhone) {
        this.custodianPhone = custodianPhone;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 20)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id &&
                status == that.status &&
                Objects.equals(code, that.code) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(age, that.age) &&
                Objects.equals(address, that.address) &&
                Objects.equals(custodianName, that.custodianName) &&
                Objects.equals(custodianPhone, that.custodianPhone) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, firstName, lastName, age, address, custodianName, custodianPhone, description, status);
    }
}
