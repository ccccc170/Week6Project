package com.sparta.week5project.DAO.interfaces;

import com.sparta.week5project.DTO.DepartmentDTO;
import com.sparta.week5project.entities.Department;

import java.util.Map;
import java.util.Optional;

public interface DepartmentService extends DepartmentDAOInterface {


    Map<String, Integer> getDepartmentSizeByYearRange(Integer from, Integer to);

    Optional<DepartmentDTO> findByDept_No(String dept_no);
}
