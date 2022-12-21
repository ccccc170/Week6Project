package com.sparta.week5project.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class DepartmentDTO {
    public DepartmentDTO(String id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    public DepartmentDTO() {
    }

    private String id;

    private String deptName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id='" + id + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
