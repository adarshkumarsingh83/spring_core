package com.adarsh.spring.service;

import com.adarsh.spring.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class EmployeeServiceImpl implements EmployeeService {

    private Date date;
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
