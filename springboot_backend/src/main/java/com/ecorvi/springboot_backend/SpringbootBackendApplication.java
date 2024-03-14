package com.ecorvi.springboot_backend;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@SpringBootApplication
public class SpringbootBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }
}

@Configuration
class AppConfig {
    
    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure().load();
    }
}

@Configuration
class DatabaseConfig {

    @Bean
    public DataSource dataSource(Dotenv dotenv) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Retrieve the JDBC URL from the environment variable using dotenv
        String jdbcUrl = dotenv.get("SPRING_DATASOURCE_URL");
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(dotenv.get("SPRING_DATASOURCE_USERNAME"));
        dataSource.setPassword(dotenv.get("SPRING_DATASOURCE_PASSWORD"));
        return dataSource;
    }
}
