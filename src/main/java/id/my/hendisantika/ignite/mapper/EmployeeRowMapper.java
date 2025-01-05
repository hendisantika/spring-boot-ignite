package id.my.hendisantika.ignite.mapper;

import id.my.hendisantika.ignite.model.Department;
import id.my.hendisantika.ignite.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ignite
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/01/25
 * Time: 09.34
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(rs.getInt("id"), rs.getInt("salary"), rs.getString("name"),
                Department.valueOf(rs.getString("department")));
    }
}
