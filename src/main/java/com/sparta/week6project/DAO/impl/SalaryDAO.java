package com.sparta.week6project.DAO.impl;

import com.sparta.week6project.DAO.interfaces.SalaryService;
import com.sparta.week6project.DTO.SalaryDTO;
import com.sparta.week6project.entities.DeptEmp;
import com.sparta.week6project.entities.Employee;
import com.sparta.week6project.entities.SalaryId;
import com.sparta.week6project.mappers.SalaryMapper;
import com.sparta.week6project.repositories.DeptEmpRepository;
import com.sparta.week6project.repositories.SalaryRepository;
import com.sparta.week6project.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.time.LocalDate;
import java.util.*;

@Service
@EnableAutoConfiguration
public class SalaryDAO implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    DeptEmpRepository deptEmpRepository;

    @Autowired
    TitleRepository titleRepository;

    public SalaryDAO(SalaryMapper salaryMapper, SalaryRepository salaryRepository) {
        this.salaryMapper = salaryMapper;
        this.salaryRepository = salaryRepository;
    }

    public SalaryDAO (){

    }

    @Override
    public Optional<SalaryDTO> findById(SalaryId id) {
        return Optional.of(salaryMapper.salaryToDTO(salaryRepository.findById(id).get()));
    }

    @Override
    public SalaryDTO save(SalaryDTO e) {
        return salaryMapper.salaryToDTO(salaryRepository.save(salaryMapper.dtoToSalary(e)));
    }

    @Override
    public void update(SalaryDTO e) {
        e.setSalary(e.getSalary()+10000);
        salaryRepository.save(salaryMapper.dtoToSalary(e));
    }

    @Override
    public void deleteById(SalaryId id) {
        salaryRepository.deleteById(id);
    }

    double averageSalaryForDepartmentAndDate(String departmentNumber, LocalDate givenDate) {
//        System.out.println("Getting employees from department");
        List<DeptEmp> deptEmpList = deptEmpRepository.findAllByDeptNumberSQL(departmentNumber);
        double average = 0.0;
//        for (DeptEmp d: deptEmpList) {
//            System.out.println(d.getEmpNo().getId());
//
//        }
        List<Integer> salaryList = new ArrayList<>();
//        System.out.println("\nGetting employee salaries\n");
//        for (DeptEmp d: deptEmpList){
//            Integer empNo = d.getEmpNo().getId();
        for (int i = 0; i < 10; i++) { //Only the first 10
            Integer empNo = deptEmpList.get(i).getEmpNo().getId();
            List<Integer> someSalary = salaryRepository.findSalaryByEmpNoAndDateSQL(empNo, givenDate);
            salaryList.addAll(someSalary);
        }
//        System.out.println("\nCalculating average...\n");
        int total = 0;
        for (int i : salaryList) {
            total += i;
        }

        if (salaryList.size() != 0) {
            average = total / salaryList.size();
        }
        return average;
    }

    public String getSalaryRangeByJobTitleAndYear(String givenTitle, int givenYear) {
        LocalDate givenYearStart = LocalDate.of(givenYear, 01, 01);//To
        LocalDate givenYearEnd = LocalDate.of(givenYear + 1, 01, 01);//From

        List<Integer> empNoList = titleRepository.findAllByTitle(givenTitle, givenYearStart); //Works
        List<Integer> salaryList = new ArrayList<>();

        for (Integer empNo : empNoList) {
            List<Integer> someSalary = salaryRepository.findSalaryByEmpNoAndDateRange(empNo, givenYearStart, givenYearEnd);
            for (Integer salary : someSalary) {
                salaryList.add(salary);
            }
        }
        Collections.sort(salaryList);
        int range = salaryList.get(salaryList.size() - 1) - salaryList.get(0);
       return (salaryList.get(salaryList.size() - 1) + " - " + salaryList.get(0) + " = " + range);
    }

    public String getGenderPayGap(String departmentNumber, LocalDate givenYear){
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
            return("The men in " + departmentNumber + " earn " + (maleSalaryAverage - femSalaryAverage) + " more!" );
        }
        else if (femSalaryAverage > maleSalaryAverage){
            return("The women in " + departmentNumber + " earn " + (femSalaryAverage - maleSalaryAverage) + " more!" );
        } else{
            return("There is no gender pay gap!");
        }
    }
}
