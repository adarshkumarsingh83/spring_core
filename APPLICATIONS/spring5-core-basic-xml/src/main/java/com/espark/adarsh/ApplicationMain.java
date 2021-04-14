package com.espark.adarsh;

import com.espark.adarsh.exception.EmpployeeNotFoundException;
import com.espark.adarsh.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class ApplicationMain {
    public static void main(String[] args) throws EmpployeeNotFoundException {
        @SuppressWarnings("resource")
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext( "application-configuration.xml" );

        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);

        employeeService.showMessage();
        
        employeeService.getEmployees().stream().forEach(employee -> {

            log.info("Employee Id "+employee.getId());
            log.info("Employee Name "+employee.getName());
            log.info("Employee Email "+employee.getEmail());
        });
    }
}
