package com.espark.adarsh.configuration;

import com.espark.adarsh.bean.Employee;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.espark.adarsh")
@PropertySource("classpath:/properties/application.properties")
public class ApplicationConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean("employeeStore")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static Map<Integer, Employee> employeeStore() {
        Map<Integer, Employee> employeeStore = new HashMap<>();
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
        return employeeStore;
    }
}
