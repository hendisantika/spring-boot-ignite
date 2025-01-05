package id.my.hendisantika.ignite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ignite
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/01/25
 * Time: 09.32
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private Integer id, salary;
    private String name;
    private Department department;
}
