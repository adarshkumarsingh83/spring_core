package com.espark.adarsh.repository;

import com.espark.adarsh.bean.Employee;
import com.espark.adarsh.exception.EmpployeeAlreadyExisitException;
import com.espark.adarsh.exception.EmpployeeNotFoundException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    static Map<Integer, Employee> employeeStore = new HashMap<>();

    @PostConstruct
    void init() {
        Employee employee1 = new Employee();
        employee1.setId(100);
        employee1.setName("adarsh kumar");
        employee1.setEmail("adarsh@kumar");
        employeeStore.put(employee1.getId(), employee1);
        Employee employee2 = new Employee();
        employee2.setId(200);
        employee2.setName("radha singh");
        employee2.setEmail("radha@singh");
        employeeStore.put(employee2.getId(), employee2);
    }

    public Employee saveEmployee(Employee employee) throws EmpployeeAlreadyExisitException {
        if (!employeeStore.containsKey(employee.getId())) {
            employeeStore.put(employee.getId(), employee);
            return employee;
        }
        throw new EmpployeeAlreadyExisitException();
    }


    public Employee updateEmployee(Employee employee) throws EmpployeeNotFoundException {
        if (employeeStore.containsKey(employee.getId())) {
            employeeStore.put(employee.getId(), employee);
            return employee;
        }
        throw new EmpployeeNotFoundException();
    }

    public Employee getEmployee(Integer employeeId) throws EmpployeeNotFoundException {
        if (employeeStore.containsKey(employeeId)) {
            return employeeStore.get(employeeId);
        }
        throw new EmpployeeNotFoundException();
    }

    public Employee deleteEmployee(Integer employeeId) throws EmpployeeNotFoundException {
        if (employeeStore.containsKey(employeeId)) {
            return employeeStore.remove(employeeId);
        }
        throw new EmpployeeNotFoundException();
    }

    public List<Employee> getEmployees() throws EmpployeeNotFoundException {
        if (!employeeStore.isEmpty()) {
            return employeeStore.values().stream().collect(Collectors.toList());
        }
        throw new EmpployeeNotFoundException();
    }
}

