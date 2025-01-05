package id.my.hendisantika.ignite.service;

import id.my.hendisantika.ignite.model.Department;
import id.my.hendisantika.ignite.model.Employee;
import id.my.hendisantika.ignite.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ignite
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/01/25
 * Time: 09.38
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void saveAll(int numberOfRows) {
        Employee s = new Employee(null, null, null, null);
        s.getSalary();

        employeeRepository.saveAll(numberOfRows);
    }

    public List<Employee> getEmployeesForDepartment(Department department) {
        return employeeRepository.getEmployeesForDepartment(department);
    }
}
