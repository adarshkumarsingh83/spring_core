package com.adarsh.spring;

import com.adarsh.spring.bean.Employee;
import com.adarsh.spring.respository.EmployeeRepository;
import com.adarsh.spring.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class ApplicationMain {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        EmployeeRepository employeeRepository=employeeService.getEmployeeRepository();
        Employee employeeOne=employeeRepository.getEmployeeOne();
        log.info(employeeOne.toString());
        Employee employeeTwo=employeeRepository.getEmployeeTwo();
        log.info(employeeTwo.toString());
    }
}
