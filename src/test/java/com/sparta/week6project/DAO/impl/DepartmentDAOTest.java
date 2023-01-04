package com.sparta.week6project.DAO.impl;

import com.sparta.week6project.DTO.DepartmentDTO;
import com.sparta.week6project.entities.Department;
import com.sparta.week6project.mappers.impl.DepartmentMapperImpl;
import com.sparta.week6project.repositories.DepartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@SpringBootTest
public class DepartmentDAOTest {
    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapperImpl departmentMapper;


    @Test
    void testFindByDept_No() {
        DepartmentDTO result = departmentDAO.findByDept_No("d009").get();
        System.out.println(result);
        Assertions.assertEquals(result.getDeptName(), "Customer Service");
    }

    @Test
    @Commit
    void testSaveMethod_ShouldSave() {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDeptName("MyDepartment");
        departmentDTO.setId("d013");
        departmentDAO.save(departmentDTO);
        Optional<DepartmentDTO> savedDepartment = departmentDAO.findByDept_No("d013");
        DepartmentDTO result = savedDepartment.get();

        Assertions.assertEquals(result.getDeptName(), "MyDepartment");
    }

    @Test
    @Rollback
    void testDeleteByIdMethod_ShouldDelete() {
        if (departmentRepository.findByIdNumber("d013").isEmpty()) {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setDeptName("MyDepartment");
            departmentDTO.setId("d013");
            departmentDAO.save(departmentDTO);
        }
        Optional<DepartmentDTO> result = departmentDAO.findByDept_No("d013");
        if (result.isPresent()) {
            departmentDAO.deleteById("d013");
        }
        Optional<Department> deleted = departmentRepository.findById("d013");

        Assertions.assertTrue(deleted.isEmpty());
    }

    @Test
    @Rollback
    void testUpdate() {
        Optional<Department> departmentOptional = departmentRepository.findByIdNumber("d009");
        if (departmentOptional.isPresent()) {
            DepartmentDTO departmentNew = new DepartmentDTO();
            departmentNew.setDeptName("NewDepartment");
            departmentDAO.update(departmentNew, "d009");
        }
        Optional<Department> result = departmentRepository.findById("d009");
        Assertions.assertEquals(result.get().getDeptName(), "NewDepartment");
    }


    @Test
    void testConstructor() {
        DepartmentDAO departmentDAO1 = new DepartmentDAO();
        Assertions.assertNotNull(departmentDAO1);
    }

    @Test
    void departmentDAOTest() {
        DepartmentDAO departmentDAO1 = new DepartmentDAO(departmentMapper, departmentRepository);
        Assertions.assertNotNull(departmentDAO1);
    }
}

