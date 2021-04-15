package com.adarsh.spring;

import com.adarsh.spring.bean.Employee;
import com.adarsh.spring.respository.EmployeeRepository;
import com.adarsh.spring.service.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        EmployeeServiceImpl employeeService = (EmployeeServiceImpl) context.getBean("employeeService");
       /* Date date = (Date) context.getBean("date");*/
        EmployeeRepository employeeRepository=employeeService.getEmployeeRepository();
        Employee employee=employeeRepository.getEmployee();
        System.out.println(employeeService.getDate()+" "+employee);
    }
}
