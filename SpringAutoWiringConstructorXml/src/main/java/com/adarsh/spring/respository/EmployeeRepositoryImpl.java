package com.adarsh.spring.respository;

import com.adarsh.spring.bean.Employee;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private Employee employee;

    public EmployeeRepositoryImpl() {
    }

    public EmployeeRepositoryImpl(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
