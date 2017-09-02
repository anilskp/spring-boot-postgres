package com.askp.springbootpostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("5000","Raj","Finance")
            ));

    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;

    }

    public Employee getEmploye(String id){

        return employeeRepository.findOne(id);
    }


    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    public void updateEmployee( Employee employee){
       // employeeRepository.save(employeeRepository.findOne(id));
        employeeRepository.save(employee);
    }

    public void deleteEmployee(String id){
        employeeRepository.delete(id);

    }
}
