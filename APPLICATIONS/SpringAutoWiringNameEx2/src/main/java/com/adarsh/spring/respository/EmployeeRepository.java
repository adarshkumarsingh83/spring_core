package com.adarsh.spring.respository;

import com.adarsh.spring.bean.Employee;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface EmployeeRepository {

    public void setEmployee(Employee employee);

    public Employee getEmployee();
}
