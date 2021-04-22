package com.espark.adarsh.test;

import com.espark.adarsh.configuration.ApplicationConfiguration;
import com.espark.adarsh.exception.EmpployeeNotFoundException;
import com.espark.adarsh.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})
public class ApplicationMainTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testEmployeeService() throws EmpployeeNotFoundException {

        employeeService.getEmployees().stream().forEach(employee -> {

            log.info("Employee Id "+employee.getId());
            log.info("Employee Name "+employee.getName());
            log.info("Employee Email "+employee.getEmail());
        });
    }
}
