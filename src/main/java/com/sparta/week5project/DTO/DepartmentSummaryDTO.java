package com.sparta.week5project.DTO;

import java.time.LocalDate;
import java.util.List;

public class DepartmentSummaryDTO {
    private String departmentNo;
    private List<EmployeeDTO> listOfEmployees;
    private LocalDate fromDate;
    private LocalDate toDate;

    public String getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo;
    }

    public List<EmployeeDTO> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(List<EmployeeDTO> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
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
