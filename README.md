# JPA/Hibernate project

## Overview

Using Spring Boot we were tasked with designing a Java programme that can connect to a MySQL employee database and use object relational mapping to create methods and provide functionality.

Our team of 7 followed the Scrum framework for organising our work. The project lasted 2 and a half days and
consisted of 3 sprints.

## Specific Requirements

### Scrum
- We assigned roles with Liam as our Scrum Master and Abdullah as our Git guru

- A Product Backlog was created and increments from there were chosen for our Sprints
- Each sprint consisted of a Sprint Plan, Backlog, Retrospective and Review
- Each day included a daily stand-up meeting where we discussed our progress
and any changes that needed to be made

### Product

1. Develop JPA entities and repositories for all 6 tables in the employees sample databse in MySQL
  - departments
  - dept_emp
  - dept_manager
  - employeeSample
  - salaries
  - titles

2. Create DAO and DTO classes to abstract the data access layer

3. Add the methods to enable the following functionality:
  - Find employees by last name
  - Find all the employees who worked in a named department on a given date
  - What is the average salary for a named department on a given date?
  - Given a job title name, what is the range of salary values within a given year?
  - Provide a summary of the size of each department (number of staff) over a given period (start year to end year)
  - Is there a gender pay gap? If so, quantify it


4. Add 3 methods of your own to investigate similar questions

5. Configure a Spring Boot application to host the JPA classes

6. Use Spring Boot Test to create a comprehensive suite for your JPA classes and your DAO/DTO classes

7. Include the result of your testing in the README.md file for the project on GitHub


## User Stories

Our first step towards creating the programme was to write user stories to cement our
understanding of the require product. We had to think of what the user would want from
the product. We also had to think of how a developer would want the code to be formatted
in case they want to make alterations.

| As a user I want... | As a developer I want...|
| --------            | ---------------------|
| To be able to access the database from the programme so that I can use the data from it | To use Spring Boot to avoid boiler plate coding|
| Simple crud functionality for the entities, so I can run simple methods on the Database | An interface superclass that defines the crud methods so that I do not need to write them for each DAO|
| To be able to run methods which use multiple entities | The objects to be loosely coupled to create dependency injection|
| To be confident that the functionality works so the results I get are accurate| To use Test Driven Development to make sure that each stage of the code functions as it should do|
| To be able to investigate the gender pay gap within the company to know if it is a fair company to work for| To create a gender pay gap test for each department to eliminate department bias|

## Sprint 1

### Plan
Scrum Master, Liam led the first sprint plan and we assigned the following increments to each person:

| Patryk | Cameron | Liam | Hanibal | Omari | Abdullah |Craig |
|------- | ------ | ----- |-------| ------  | --------  | ---- |
|Create design pattern | Create Entities | Begin Documentation | Create repositories | Create Mappers | Create Mappers| Create Mappers         |
| Create DAOs| Create DTOs | Investigate logic for methods | Create DAOs | Create DTOs | Set up git repository | Investigate logic for methods|
|            |          |        |       |          | Set up spring boot intelliJ project|      |


### Review

The design for the project was completed. Entities and repositories were created as well as the DAOs and DTOs. The project was
all set up for creating the methods.

### Retrospective

Pretty straight forward day. Patryck did most of the work as he has experience with Spring and was very helpful at explaining the design.

## Sprint 2
### Plan
The second sprint was simple. We split into two groups and created crud methods and the methods in our requirements. The aim was to get most of them done and incorporate Test Driven Development

| Patryk | Cameron | Liam | Hanibal | Omari | Abdullah |Craig |
|------- | ------ | ----- |-------| ------  | --------  | ---- |
|Crud Methods | Salary Method 1 | Salary Method 1 | Crud Methods | Crud Methods | Crud Methods | Crud Methods  |
| Department Method |  Salary Method 2 | Salary Method 2 | Department Method | Salary Method 2 | Salary Method 2| Gender Pay Gap Method|
|            |  Gender Pay Gap Method |  Gender Pay Gap Method |       |      | Gender Pay Gap Method | |


### Review

Most methods were completed. Department Method still needs to be completed as well as some Crud methods.

### Retrospective
As a team we worked flexibly and determinedly to make good progress and resolved issues well.
Better communication needed between the split teams to avoid issues we faced when merging projects

## Sprint 3

### Plan

Finish the methods and carry out comprehensive testing

| Patryk | Cameron | Liam | Hanibal | Omari | Abdullah |Craig |
|------- | ------ | ----- |-------| ------  | --------  | ---- |
|Crud Methods | Department Method | Documentation | Department Methods | Department Method | Department Method | Department Method  |
| Crud method Testing |  Salary Method Testing |  | Department Method Testing | Department Method Testing | Crud Method Testing| Mapper Testing|
| DAO Testing |DAO Testing |   |       |      |      |      |

## Methods

### Find employees by last name

```Java
@Override
   public List<Employee> findEmployeeByLastName(String lastname) {
       return employeeRepository.findAll()
               .stream()
               .filter(a->a.getLastName().equals(lastname))
                       .collect(Collectors.toList());
   }

   @Test
       void testFindEmployeeByLastNameMethod() {
           List<Employee> employeesByLatName = employeeDAO.findEmployeeByLastName("Aamodt");
           System.out.println(employeesByLatName);
           Assertions.assertTrue(!employeesByLatName.isEmpty());
       }
```
### Find all the employees who worked in a named department on a given date
```Java
Integer FindAllEmployeesByGivenDate(String departmentNumber, LocalDate givenDate) {
       Optional<Integer> allEmpsOptional = deptEmpRepository.findAllByDepartmentNameAndDate(departmentNumber,givenDate);
       return allEmpsOptional.orElse(0);
   }
   
@Test
    void testFindAllEmployeesByGivenDate() {
        Assertions.assertEquals(13399,deptEmpDAO.FindAllEmployeesByGivenDate("d003",LocalDate.of(1999,01,01)));
    }

```


### What is the average salary for a named department on a given date?
```Java
double averageSalaryForDepartmentAndDate(String departmentNumber, LocalDate givenDate) {

        List<DeptEmp> deptEmpList = deptEmpRepository.findAllByDeptNumberSQL(departmentNumber);
        double average = 0.0;

        List<Integer> salaryList = new ArrayList<>();

        for (int i = 0; i < 10; i++) { //Only the first 10
            Integer empNo = deptEmpList.get(i).getEmpNo().getId();
            List<Integer> someSalary = salaryRepository.findSalaryByEmpNoAndDateSQL(empNo, givenDate);
            salaryList.addAll(someSalary);
        }

        int total = 0;
        for (int i : salaryList) {
            total += i;
        }

        if (salaryList.size() != 0) {
            average = total / salaryList.size();
        }
        return average;
    }

    @Test
    @DisplayName("Given a department name and date, get average salary")
    void averageSalaryForDepartmentAndDateTest() {
        double expected = 63193.0;
        double result = salaryDAO.averageSalaryForDepartmentAndDate("d005", LocalDate.of(2000,01,01));
        Assertions.assertEquals(expected,result);
    }

```

### Given a job title name, what is the range of salary values within a given year?
```Java
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

@Test
   @DisplayName("Given a job title and a year, display the range of salary values")
   void getSalaryRangeByJobTitleAndYearTest() {
       String expected = "103005 - 39177 = 63828";
       String result = salaryDAO.getSalaryRangeByJobTitleAndYear("Engineer",1989);
       Assertions.assertEquals(expected,result);
   }
```

### Provide a summary of the size of each department (number of staff) over a given period (start year to end year)
```java
@Override
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
        Integer count = getDepartmentsCount(departmentsSummary.get(i), fromDate, toDate);
        String dName = departmentRepository.findDeptNameByDeptNo(departmentsSummary.get(i));
        //System.out.println(count);
        summary.put(dName, count);

    }
    return summary;
}

@Test
    void testGetDepartmentSummary(){
        Integer count = deptEmpDAO.getDepartmentsCount("d005", LocalDate.of(1999,1,1), LocalDate.of(2000,1,1));
        System.out.println(count);
        Assertions.assertEquals(319, count);
    }
    @Test
    void testGetAllDepartmentsSummary(){
        Map<String, Integer> departmentsSummary = new HashMap<>();
        departmentsSummary = deptEmpDAO.getSummary(LocalDate.of(1999,1,1), LocalDate.of(2000,1,1));
        departmentsSummary.entrySet().stream().forEach(a -> System.out.println(a));
        Integer result = departmentsSummary.get("Development");
        Assertions.assertEquals(319, result);
    }

```
### Is there a gender pay gap? If so, quantify it
```Java
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


        for(int i = 0; i < 50; i++){
            if (salaryRepository.findSalaryByEmpNoAndToDate(femEmps.get(i).getId(),givenYear).isPresent()){
                femSalaries.add(salaryRepository.findSalaryByEmpNoAndToDate(femEmps.get(i).getId(),givenYear).get());
            }
        }


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
    @Test
    @DisplayName("Quantify the gender pay gap")
    void getGenderPayGapTest(){
        String expected = "The women in d005 earn 3469.0 more!";
        String result = salaryDAO.getGenderPayGap("d005",LocalDate.of(9999,01,01));
        Assertions.assertEquals(expected, result);

    }
