package com.sparta.week6project.DTO;

import com.sparta.week6project.entities.Employee;
import com.sparta.week6project.entities.TitleId;

import java.time.LocalDate;

public class TitleDTO {


    private TitleId id;


    private Employee empNo;


    private LocalDate toDate;

    public TitleId getId() {
        return id;
    }

    public void setId(TitleId id) {
        this.id = id;
    }

    public Employee getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Employee empNo) {
        this.empNo = empNo;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "TitleDTO{" +
                "id=" + id +
                ", empNo=" + empNo +
                ", toDate=" + toDate +
                '}';
    }
}
