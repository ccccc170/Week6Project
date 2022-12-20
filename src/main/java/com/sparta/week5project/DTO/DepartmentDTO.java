package com.sparta.week5project.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class DepartmentDTO {

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
}
