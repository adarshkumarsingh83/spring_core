package com.adarsh.spring.service;

import com.adarsh.spring.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeServiceImpl() {
    }

    @Autowired(required = false)
    private EmployeeRepository employeeRepository;

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
