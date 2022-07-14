package bm.app.minihrsap.controller;

import bm.app.minihrsap.model.Employee;
import bm.app.minihrsap.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RestController annotation informs Spring this is the bean where my services are defined.
 * Inside RestController there's ResponseBody annotation. It makes Spring convert what one of
 * my services (methods) returns into a proper response. So in this case it will be converted
 * into a JSON and displayed within the response's body. Due to this annotation being present
 * within RestController I don't need to add it under every method's mapping.
 */
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    /**
     * In REST API resources are marked with nouns in the plural form.
     */
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
}