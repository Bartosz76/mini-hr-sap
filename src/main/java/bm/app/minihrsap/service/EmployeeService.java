package bm.app.minihrsap.service;

import bm.app.minihrsap.model.Employee;
import bm.app.minihrsap.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * .findById returns an Optional. It has an .orElseThrow method which throws
     * an exception of NoSuchElement in case the value is not found.
     */
    public Employee getEmployee(Long id) {
        return (Employee) employeeRepository.findById(id).orElseThrow();
    }

}
