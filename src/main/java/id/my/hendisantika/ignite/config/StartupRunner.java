package id.my.hendisantika.ignite.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ignite
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/01/25
 * Time: 09.37
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class StartupRunner implements ApplicationRunner {

    private final EmployeeService employeeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("[START] Saving Employee Data");
        employeeService.saveAll(30000);
        log.info("[END] Saving Employee Data");
    }
}
