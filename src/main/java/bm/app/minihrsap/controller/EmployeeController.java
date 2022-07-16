package bm.app.minihrsap.controller;

import bm.app.minihrsap.model.Employee;
import bm.app.minihrsap.model.EmployeeDto;
import bm.app.minihrsap.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    public static final Long EMPTY_ID = null; //For entity-dto mapping to provide instead of null.
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

    /**
     * RequestBody annotation means that when my application receives a HTTP request with something
     * inside it so if there's a JSON in body that fits my object Spring will automatically
     * convert that JSON to that object.
     * A mapping from Dto is being performed upon the creation of the Employee.
     */
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(new Employee(
                EMPTY_ID,
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.isActive(),
                employeeDto.getCreated()
        ));
    }

    /**
     * There are two ids available here. If a DTO was used, there would be no problem, because
     * it would just not have the id. If there's no DTO I can overwrite the id field in the
     * entity with the id coming in from the path.
     */
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(new Employee(
                EMPTY_ID,
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.isActive(),
                employeeDto.getCreated()
        ));
    }
}
