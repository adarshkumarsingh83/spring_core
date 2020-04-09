package com.adarsh.spring.respository;

import com.adarsh.spring.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface EmployeeRepository {

    public Employee getEmployeeOne();

    public void setEmployeeOne(Employee employeeOne);

    public Employee getEmployeeTwo();

    public void setEmployeeTwo(Employee employeeTwo);
}
