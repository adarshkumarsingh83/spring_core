package com.adarsh.spring.respository;

import com.adarsh.spring.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class EmployeeRepositoryImpl implements EmployeeRepository {


    public EmployeeRepositoryImpl() {
    }

    @Autowired(required = false)
    @Qualifier("employeeOne")
    private Employee employeeOne;

    public Employee getEmployeeOne() {
        return employeeOne;
    }

    public void setEmployeeOne(Employee employeeOne) {
        this.employeeOne = employeeOne;
    }

    @Autowired(required = false)
    @Qualifier("employeeTwo")
    private Employee employeeTwo;

    public Employee getEmployeeTwo() {
        return employeeTwo;
    }

    public void setEmployeeTwo(Employee employeeTwo) {
        this.employeeTwo = employeeTwo;
    }
}
