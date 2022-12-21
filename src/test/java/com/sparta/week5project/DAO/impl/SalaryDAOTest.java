package com.sparta.week5project.DAO.impl;

import com.sparta.week5project.DTO.SalaryDTO;
import com.sparta.week5project.entities.*;
import com.sparta.week5project.mappers.EmployeeMapper;
import com.sparta.week5project.repositories.DeptEmpRepository;
import com.sparta.week5project.repositories.SalaryRepository;
import com.sparta.week5project.repositories.TitleRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class SalaryDAOTest {

    @Autowired
    private SalaryDAO salaryDAO;
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DeptEmpRepository deptEmpRepository;
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private TitleRepository titleRepository;

    @Test
    void findById() {
        SalaryId salaryId = new SalaryId();
        salaryId.setEmpNo(10001);
        salaryId.setFromDate(LocalDate.of(1986,06,26));
        System.out.println(salaryDAO.findById(salaryId).get().getId().getFromDate());
    }

    @Test
    @Commit
    void save() {
        SalaryDTO salaryDTO= new SalaryDTO();
        SalaryId salaryId = new SalaryId();

        salaryId.setEmpNo(10001);
        salaryId.setFromDate(LocalDate.of(2000,06,26));

        salaryDTO.setSalary(90000);
        salaryDTO.setToDate(LocalDate.of(2020,12,15));
        salaryDTO.setId(salaryId);
        salaryDTO.setEmpNo(employeeMapper.dtoToEmployee(employeeDAO.findById(salaryId.getEmpNo()).get()));
        salaryDAO.save(salaryDTO);
    }

    @Test
    @Commit
    void update() {
        SalaryId salaryId = new SalaryId();

        salaryId.setEmpNo(10001);
        salaryId.setFromDate(LocalDate.of(1986,06,26));
        salaryDAO.update(salaryDAO.findById(salaryId).get());
    }

    @Test
    void deleteById() {
        SalaryId salaryId = new SalaryId();

        salaryId.setEmpNo(10001);
        salaryId.setFromDate(LocalDate.of(2000,06,26));

        salaryDAO.deleteById(salaryId);
    }

    @Test
    @DisplayName("Given a department name and date, get average salary")
    void averageSalaryForDepartmentAndDate() {

        String departmentNumber = "d005";
        LocalDate givenDate = LocalDate.of(2000,01,01);

        System.out.println("Getting employees from department");
        List<DeptEmp> deptEmpList = deptEmpRepository.findAllByDeptNumberSQL(departmentNumber);
//        for (DeptEmp d: deptEmpList) {
//            System.out.println(d.getEmpNo().getId());
//
//        }
        List<Integer> salaryList = new ArrayList<>();
        System.out.println("\nGetting employee salaries\n");

//        for (DeptEmp d: deptEmpList){
//            Integer empNo = d.getEmpNo().getId();
        for (int i = 0;i < 10;i++) { //Only the first 10
            Integer empNo = deptEmpList.get(i).getEmpNo().getId();

            Optional<Integer> someSalary = salaryRepository.findSalaryByEmpNoAndDateSQL(empNo,givenDate);
            if (someSalary.isPresent()){
                salaryList.add(someSalary.get());
            }
        }
        System.out.println("\nCalculating average...\n");
        int total = 0;
        for (int i : salaryList) {
            total += i;
        }
        System.out.println("-------------");

        double average = total/salaryList.size();

        System.out.println(average);
    }

    //TODO
    //Add null checks
    @Test
    @DisplayName("Given a job title and a year, display the range of salary values")
    void getSalaryRangeByJobTitleAndYear() {
        String givenTitle = "Engineer";
        int givenYear = 1989;
        LocalDate givenYearStart = LocalDate.of(givenYear,01,01);//To
        LocalDate givenYearEnd = LocalDate.of(givenYear+1,01,01);//From

        List<Integer> empNoList = titleRepository.findAllByTitle(givenTitle,givenYearStart); //Works
        List<Integer> salaryList = new ArrayList<>();

        for (Integer empNo: empNoList){
            List<Integer> someSalary = salaryRepository.findSalaryByEmpNoAndDateRange(empNo,givenYearStart,givenYearEnd);
            for (Integer salary : someSalary){
                salaryList.add(salary);
            }
        }
        Collections.sort(salaryList);
//        System.out.println(salaryList);

        int range = salaryList.get(salaryList.size()-1) - salaryList.get(0);

        System.out.println(salaryList.get(salaryList.size()-1) + " - " + salaryList.get(0) + " = " + range);

    }

    @Test
    @DisplayName("Quantify the gender pay gap")
    void getGenderPayGap(){
        String departmentNumber = "d005";
        LocalDate givenYear = LocalDate.of(9999,01,01);
        System.out.println("Getting employees from department");
        List<DeptEmp> deptEmpList = deptEmpRepository.findAllByDeptNumberAndDateSQL(departmentNumber,givenYear);
        List<Employee> maleEmps = new ArrayList<>();
        List<Employee> femEmps = new ArrayList<>();
        List<Integer> maleSalaries = new ArrayList<>();
        List<Integer> femSalaries = new ArrayList<>();
        int maleSalaryTotal = 0;
        int femSalaryTotal = 0;

        for (DeptEmp d : deptEmpList){
            if(Objects.equals(d.getEmpNo().getGender(), "M")){
                maleEmps.add(d.getEmpNo());
            } else{
                femEmps.add(d.getEmpNo());
            }
        }

//        System.out.println(maleEmps);
//        System.out.println(femEmps);

        for(int i = 0; i < 50; i++){
            if (salaryRepository.findSalaryByEmpNoAndToDate(maleEmps.get(i).getId(), givenYear).isPresent()){
                maleSalaries.add(salaryRepository.findSalaryByEmpNoAndToDate(maleEmps.get(i).getId(), givenYear).get());
            }
        }

//        for (Employee e: maleEmps) {
//            if (salaryRepository.findCurrentSalaryByEmpNo(e.getId()).isPresent()){
//                maleSalaries.add(salaryRepository.findCurrentSalaryByEmpNo(e.getId()).get());
//            }
//        }

        for(int i = 0; i < 50; i++){
            if (salaryRepository.findSalaryByEmpNoAndToDate(femEmps.get(i).getId(),givenYear).isPresent()){
                femSalaries.add(salaryRepository.findSalaryByEmpNoAndToDate(femEmps.get(i).getId(),givenYear).get());
            }
        }

//        for (Employee e: femEmps) {
//            if (salaryRepository.findCurrentSalaryByEmpNo(e.getId()).isPresent()){
//            femSalaries.add(salaryRepository.findCurrentSalaryByEmpNo(e.getId()).get());
//            }
//        }


        for (Integer salary : maleSalaries) {
        maleSalaryTotal += salary;
        }

        double maleSalaryAverage = maleSalaryTotal/maleSalaries.size();

        for (Integer salary : femSalaries) {
            femSalaryTotal += salary;
        }
        double femSalaryAverage = femSalaryTotal/femSalaries.size();

        if (maleSalaryAverage > femSalaryAverage){
            System.out.println("The men in " + departmentNumber + " earn " + (maleSalaryAverage - femSalaryAverage) + " more!" );
        }
        else if (femSalaryAverage > maleSalaryAverage){
            System.out.println("The women in " + departmentNumber + " earn " + (femSalaryAverage - maleSalaryAverage) + " more!" );
        } else{
            System.out.println("There is no gender pay gap!");
        }

    }
}