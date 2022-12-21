package com.sparta.week5project.DTO;

import com.sparta.week5project.entities.Department;
import com.sparta.week5project.entities.DeptEmpId;
import com.sparta.week5project.entities.Employee;

import java.time.LocalDate;

public class DeptEmpDTO {


//    private DeptEmpId id;

    private DeptEmpId id;


    private Employee empNo;


    private Department deptNo;


    private LocalDate fromDate;


    private LocalDate toDate;

//    public DeptEmpId getId() {
//        return id;
//    }

//    public void setId(DeptEmpId id) {
//        this.id = id;
//    }


    public DeptEmpId getId() {
        return id;
    }

    public void setId(DeptEmpId id) {
        this.id = id;
    }

    public Employee getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Employee empNo) {
        this.empNo = empNo;
    }

    public Department getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Department deptNo) {
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
}
