package com.espark.adarsh.repository;

import com.espark.adarsh.bean.Employee;
import com.espark.adarsh.exception.EmpployeeAlreadyExisitException;
import com.espark.adarsh.exception.EmpployeeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class EmployeeRepository {

    @Autowired
    @Qualifier("employeeStore")
    Map<Integer, Employee> employeeStore;

    @PostConstruct
    public void init() {
        log.info("EmployeeStore size {}", employeeStore.size());
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

