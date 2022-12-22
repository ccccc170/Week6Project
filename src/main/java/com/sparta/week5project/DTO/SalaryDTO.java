package com.sparta.week5project.DTO;

import com.sparta.week5project.entities.Employee;
import com.sparta.week5project.entities.SalaryId;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

public class SalaryDTO {


    private SalaryId id;


    private Employee empNo;


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

    public Employee getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Employee empNo) {
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
