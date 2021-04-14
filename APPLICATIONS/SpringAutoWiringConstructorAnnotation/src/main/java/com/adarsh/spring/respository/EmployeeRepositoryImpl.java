package com.adarsh.spring.respository;

import com.adarsh.spring.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {


    private Employee employee;

    @Autowired(required = true)
    public EmployeeRepositoryImpl(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
