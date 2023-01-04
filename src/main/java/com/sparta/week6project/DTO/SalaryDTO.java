package com.sparta.week6project.DTO;

import com.sparta.week6project.entities.Employee;
import com.sparta.week6project.entities.SalaryId;

import java.time.LocalDate;

public class SalaryDTO {


    private SalaryId id;


    private Integer empNo;


    private Integer salary;


    private LocalDate toDate;

    public SalaryId getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SalaryDTO{" +
                "id=" + id +
                ", empNo=" + empNo +
                ", salary=" + salary +
                ", toDate=" + toDate +
                '}';
    }
    public void setId(SalaryId id) {
        this.id = id;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
