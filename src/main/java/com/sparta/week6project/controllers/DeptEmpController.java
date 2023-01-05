package com.sparta.week6project.controllers;

import com.sparta.week6project.DAO.impl.DepartmentDAO;
import com.sparta.week6project.DAO.impl.DeptEmpDAO;
import com.sparta.week6project.DAO.impl.EmployeeDAO;
import com.sparta.week6project.repositories.DeptEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/dept_employees")
public class DeptEmpController {

    @Autowired
    DeptEmpDAO deptEmpDAO;

    @Autowired
    DepartmentDAO departmentDAO;

    @Autowired
    DeptEmpRepository deptEmpRepository;

    @GetMapping("/getCount")
    public Integer getDepartmentsCount(@RequestParam String departmentNo, @RequestParam LocalDate fromDate, @RequestParam LocalDate toDate) {
        Integer deptEmps = deptEmpDAO.getDepartmentsCount(departmentNo, fromDate, toDate);
        //System.out.println((deptEmps.get(0).getEmpNo()));
        return deptEmps;
    }

    @GetMapping("/getSummary")
    public Map<String, Integer> getSummary(@RequestParam LocalDate fromDate, @RequestParam LocalDate toDate){

        return deptEmpDAO.getSummary(fromDate, toDate);

    }

    @GetMapping("/getEmployeesByGivenDate")
    public Integer FindAllEmployeesByGivenDate(@RequestParam String departmentNumber, @RequestParam LocalDate givenDate) {
        Integer allEmployees = deptEmpDAO.FindAllEmployeesByGivenDate(departmentNumber,givenDate);
        return allEmployees;
    }

}
