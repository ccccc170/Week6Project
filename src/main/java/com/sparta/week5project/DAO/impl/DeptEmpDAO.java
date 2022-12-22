package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DAO.interfaces.DAO;


import com.sparta.week5project.DAO.interfaces.DeptEmpService;

import com.sparta.week5project.DTO.DepartmentSummaryDTO;
import com.sparta.week5project.DTO.DeptEmpDTO;
import com.sparta.week5project.entities.DeptEmp;
import com.sparta.week5project.entities.DeptEmpId;
import com.sparta.week5project.mappers.DeptEmpMapper;
import com.sparta.week5project.repositories.DepartmentRepository;
import com.sparta.week5project.repositories.DeptEmpRepository;
import com.sparta.week5project.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
@EnableAutoConfiguration
public class DeptEmpDAO implements DeptEmpService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DeptEmpRepository deptEmpRepository;

    @Autowired
    private DeptEmpMapper deptEmpMapper;

    public DeptEmpDAO(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, DeptEmpRepository deptEmpRepository, DeptEmpMapper deptEmpMapper) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.deptEmpRepository = deptEmpRepository;
        this.deptEmpMapper = deptEmpMapper;
    }

    public DeptEmpDAO() {
    }

    @Override
    public Optional findById(DeptEmpId id) {
        return Optional.of(deptEmpMapper.deptEmpToDTO(deptEmpRepository.findById(id).get()));
    }

    @Override
    public DeptEmpDTO save(DeptEmpDTO e) {
        return deptEmpMapper.deptEmpToDTO(deptEmpRepository.save(deptEmpMapper.dtoToDeptEmp(e)));
    }

    @Override
    public void update(DeptEmpDTO e) {

    }

    @Override
    public void deleteById(DeptEmpId id) {
        deptEmpRepository.deleteById(id);

    }

    public Integer getDepartmentsSummaryCount(String departmentNo, LocalDate fromDate, LocalDate toDate) {
        Optional<Integer> deptEmps = deptEmpRepository.getDepartmentsSummary(departmentNo, fromDate, toDate);
        //System.out.println((deptEmps.get(0).getEmpNo()));
        return deptEmps.get();
    }

    public Map<String, Integer> getSummary(LocalDate fromDate, LocalDate toDate){
        Map<Integer, String> departmentsSummary = new HashMap<>();
        departmentsSummary.put(0, "d001");
        departmentsSummary.put(1, "d002");
        departmentsSummary.put(2, "d003");
        departmentsSummary.put(3, "d004");
        departmentsSummary.put(4, "d005");
        departmentsSummary.put(5, "d006");
        departmentsSummary.put(6, "d007");
        departmentsSummary.put(7, "d008");
        departmentsSummary.put(8, "d009");

        Map<String, Integer> summary = new HashMap<>();
        for(int i = 0; i<departmentsSummary.size(); i++){
            Integer count = getDepartmentsSummaryCount(departmentsSummary.get(i), fromDate, toDate);
            String dName = departmentRepository.findDeptNameByDeptNo(departmentsSummary.get(i));
            //System.out.println(count);
            summary.put(dName, count);

        }
        return summary;
    }

}
