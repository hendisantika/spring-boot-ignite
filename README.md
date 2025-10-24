# Spring Boot Ignite Cache

A demonstration project showcasing Apache Ignite cache integration with Spring Boot for caching employee data with
PostgreSQL database.

## Tech Stack

- **Spring Boot 3.5.7**
- **Java 23** (Note: May have compatibility issues with Java 25)
- **Apache Ignite 2.17.0** - Distributed in-memory cache
- **PostgreSQL 17** - Primary database
- **H2 Database** - For development/testing
- **Docker Compose** - For PostgreSQL containerization
- **Lombok** - For reducing boilerplate code
- **JavaFaker** - For generating test data

## Features

- Employee management with department-based queries
- Apache Ignite distributed caching
- Automatic Docker Compose PostgreSQL setup
- Bulk data generation (30,000 employee records on startup)
- RESTful API endpoint for querying employees by department

## Prerequisites

- Java 23 or compatible JDK
- Maven 3.9+
- Docker and Docker Compose
- At least 4GB of available RAM (for Ignite and PostgreSQL)

## Configuration

### Database Configuration

The application uses PostgreSQL as the primary database. Configuration is in
`src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/emp_db
spring.datasource.username=yu71
spring.datasource.password=53cret
```

### Docker Compose

PostgreSQL is automatically started using Spring Boot Docker Compose support. The `compose.yaml` file defines:

```yaml
services:
  postgres:
    image: postgres:17-alpine3.21
    environment:
      POSTGRES_DB: emp_db
      POSTGRES_USER: yu71
      POSTGRES_PASSWORD: 53cret
    ports:
      - "5432:5432"
```

## Building the Project

```bash
./mvnw clean package
```

## Running the Application

### Standard Run

```bash
./mvnw spring-boot:run
```

### With Java Module Access Flags (Recommended for Java 23+)

Due to Java module system restrictions with Apache Ignite, you may need to run with additional JVM flags:

```bash
MAVEN_OPTS="--add-opens=java.base/jdk.internal.misc=ALL-UNNAMED \
--add-opens=java.base/sun.nio.ch=ALL-UNNAMED \
--add-opens=java.management/com.sun.jmx.mbeanserver=ALL-UNNAMED \
--add-opens=jdk.internal.jvmstat/sun.jvmstat.monitor=ALL-UNNAMED \
--add-opens=java.base/sun.reflect.generics.reflectiveObjects=ALL-UNNAMED \
--add-opens=java.base/java.io=ALL-UNNAMED \
--add-opens=java.base/java.nio=ALL-UNNAMED \
--add-opens=java.base/java.util=ALL-UNNAMED \
--add-opens=java.base/java.lang=ALL-UNNAMED" ./mvnw spring-boot:run
```

### Using JAR

```bash
java -jar target/ignite-0.0.1-SNAPSHOT.jar
```

## API Endpoints

### Get Employees by Department

```bash
GET /department/employees/{department}
```

**Available Departments:**

- HR
- LEGAL
- FINANCE

**Example:**

```bash
curl http://localhost:8080/department/employees/HR
```

**Response:**

```json
[
  {
    "id": 1,
    "name": "John Doe",
    "department": "HR",
    "salary": 50000
  },
  ...
]
```

## How Caching Works

1. The application uses Apache Ignite as the caching provider
2. Employee queries by department are cached using `@Cacheable` annotation
3. First query hits the database and caches the result
4. Subsequent queries for the same department are served from cache
5. Check logs to see when data is read from database vs cache

## Project Structure

```
src/main/java/id/my/hendisantika/ignite/
├── config/
│   ├── IgniteCacheConfig.java       # Ignite cache configuration
│   └── StartupRunner.java            # Initializes database on startup
├── controller/
│   └── EmployeeController.java       # REST API endpoints
├── mapper/
│   └── EmployeeRowMapper.java        # JDBC row mapper
├── model/
│   ├── Department.java               # Department enum
│   └── Employee.java                 # Employee entity
├── repository/
│   └── EmployeeRepository.java       # Data access layer with caching
├── service/
│   └── EmployeeService.java          # Business logic layer
└── SpringBootIgniteApplication.java  # Main application class
```

## Database Schema

```sql
CREATE TABLE employee
(
    id         serial PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    department VARCHAR(48)  NOT NULL,
    salary     INTEGER
);
```

## Startup Process

1. Spring Boot starts and detects `compose.yaml`
2. Docker Compose starts PostgreSQL container
3. Application waits for PostgreSQL to be healthy
4. `StartupRunner` creates the employee table
5. Generates and inserts 30,000 random employee records
6. Application is ready to serve requests

## Known Issues

- **Java 25 Compatibility**: Apache Ignite 2.17.0 has compatibility issues with Java 25. Use Java 23 or add necessary
  `--add-opens` JVM flags
- **Memory Usage**: The application loads 30,000 records on startup which requires adequate memory
- **Spring Data JDBC**: Auto-configuration is disabled to prevent conflicts with Ignite JDBC driver initialization
- **H2 Console**: Auto-configuration is disabled due to driver conflicts

## Performance Notes

- First query to a department: ~100-500ms (database hit)
- Cached queries: <10ms (in-memory cache hit)
- 30,000 records generated at startup takes approximately 30-60 seconds

## Development

### Running Tests

```bash
./mvnw test
```

### Stopping the Application

Press `Ctrl+C` in the terminal, or:

```bash
docker compose down
```

## Troubleshooting

### Port 8080 Already in Use

```bash
lsof -ti:8080 | xargs kill -9
```

### PostgreSQL Connection Issues

Ensure Docker is running and port 5432 is available:

```bash
docker ps
lsof -i:5432
```

### Cache Not Working

Check logs for "Read data from database" messages. If you see this on every request, caching may not be working
properly.

## License

This project is created for demonstration and educational purposes.

## Author

- **Hendi Santika**
- Email: hendisantika@gmail.com
- Telegram: @hendisantika34

## Contributing

Feel free to submit issues and enhancement requests!
