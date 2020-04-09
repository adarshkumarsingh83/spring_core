package com.adarsh.spring.respository;

import com.adarsh.spring.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface EmployeeRepository {

    public Employee getEmployee();
}
