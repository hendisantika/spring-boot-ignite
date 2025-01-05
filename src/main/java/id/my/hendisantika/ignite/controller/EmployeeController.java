package id.my.hendisantika.ignite.controller;

import id.my.hendisantika.ignite.model.Department;
import id.my.hendisantika.ignite.model.Employee;
import id.my.hendisantika.ignite.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ignite
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/01/25
 * Time: 09.39
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(path = "/department/employees/{department}")
    public List<Employee> getEmployeesForDepartment(@PathVariable("department") Department department) {
        return employeeService.getEmployeesForDepartment(department);
    }
}
