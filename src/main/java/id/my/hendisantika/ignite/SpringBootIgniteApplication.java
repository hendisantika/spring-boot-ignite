package id.my.hendisantika.ignite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;

@SpringBootApplication(exclude = {JdbcRepositoriesAutoConfiguration.class, H2ConsoleAutoConfiguration.class})
public class SpringBootIgniteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIgniteApplication.class, args);
    }

}
