package com.sparta.week6project.DTO;

import com.sparta.week6project.entities.Department;
import com.sparta.week6project.entities.DeptManagerId;
import com.sparta.week6project.entities.Employee;

import java.time.LocalDate;

public class DeptManagerDTO {

    private DeptManagerId id;


    private Integer empNo;


    private String deptNo;


    private LocalDate fromDate;


    private LocalDate toDate;

    public DeptManagerId getId() {
        return id;
    }

    public void setId(DeptManagerId id) {
        this.id = id;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "DeptManagerDTO{" +
                "id=" + id +
                ", empNo=" + empNo +
                ", deptNo=" + deptNo +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
