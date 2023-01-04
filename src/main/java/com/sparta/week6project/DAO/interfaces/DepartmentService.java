package com.sparta.week6project.DAO.interfaces;

import com.sparta.week6project.DTO.DepartmentDTO;

import java.util.Optional;

public interface DepartmentService extends DepartmentDAOInterface {


//    Map<String, Integer> getDepartmentSizeByYearRange(Integer from, Integer to);

    Optional<DepartmentDTO> findByDept_No(String dept_no);

}
