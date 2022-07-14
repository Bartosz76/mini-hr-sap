package bm.app.minihrsap.controller;

import bm.app.minihrsap.model.Employee;
import bm.app.minihrsap.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     * The below service returns a database entity. It can be done if what's in the entity can be
     * represented in the service. Though usually they should be mapped to a DTO.
     */
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    /**
     * The id within the path is mapped to a parameter by the PathVariable annotation. The parameters
     * in the path are required by default. If id was optional and was not provided, the above method
     * would be used to handle the request.
     */
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }
}
