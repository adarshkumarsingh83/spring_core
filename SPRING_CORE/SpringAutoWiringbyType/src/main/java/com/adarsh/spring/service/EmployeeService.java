package com.adarsh.spring.service;

import com.adarsh.spring.respository.EmployeeRepository;

import java.util.Date;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface EmployeeService {

    public Date getDate();

    public void setDate(Date date);

    public EmployeeRepository getEmployeeRepository();

    public void setEmployeeRepository(EmployeeRepository employeeRepository);
}
