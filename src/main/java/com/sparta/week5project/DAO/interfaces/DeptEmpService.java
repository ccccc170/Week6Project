package com.sparta.week5project.DAO.interfaces;

import com.sparta.week5project.DTO.DepartmentSummaryDTO;
import com.sparta.week5project.DTO.DeptEmpDTO;
import com.sparta.week5project.entities.DeptEmpId;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DeptEmpService<T> {

    public Integer getDepartmentsCount(String departmentNo, LocalDate fromDate, LocalDate toDate);
    public Map<String, Integer> getSummary(LocalDate fromDate, LocalDate toDate);

}
