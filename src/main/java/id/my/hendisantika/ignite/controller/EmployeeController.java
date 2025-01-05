package id.my.hendisantika.ignite.controller;

import id.my.hendisantika.ignite.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

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
}
