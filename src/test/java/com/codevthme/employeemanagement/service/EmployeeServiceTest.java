package com.codevthme.employeemanagement.service;


import com.codevthme.employeemanagement.model.Employee;
import com.codevthme.employeemanagement.repo.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    private Employee emp;

    @BeforeEach
    void setUp(){
        emp = new Employee();
        emp.setEmp_id(1);
        emp.setFirst_name("Althaf");
    }

    @Test
    public void testGetEmployeeById(){
        Mockito.when(employeeRepository.findById(1)).thenReturn(Optional.of(emp));
        Employee employee = employeeService.getEmployeeById(1);
        assertEquals(emp.getFirst_name(), employee.getFirst_name());

    }
}