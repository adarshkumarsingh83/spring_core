package com.adarsh.spring.respository;


import com.adarsh.spring.bean.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Repository
public class EmployeeRepository {



    private int id=101;


    private String name="adarsh kumar singh";

    public Employee getEmployee() {
        return new Employee(id, name);
    }
}
