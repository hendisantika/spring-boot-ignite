package id.my.hendisantika.ignite.repository;

import com.github.javafaker.Faker;
import id.my.hendisantika.ignite.model.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ignite
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/01/25
 * Time: 09.35
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Repository
public class EmployeeRepository {
    final Department[] departments = {Department.HR, Department.LEGAL, Department.FINANCE};
    private final Faker faker = new Faker();
    private final JdbcTemplate jdbcTemplate;
    private final Random random = new Random();

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void saveAll(int numberOfRows) {
        for (int i = 0; i < numberOfRows; i++) {
            jdbcTemplate.update("INSERT INTO employee (name, department, salary) " + "VALUES (?, ?, ?)",
                    faker.name().firstName(), departments[random.nextInt(3)].name(),
                    faker.number().numberBetween(10000, 10000000));
        }
    }
}
