package com.adarsh.spring.service;

import com.adarsh.spring.respository.EmployeeRepository;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
