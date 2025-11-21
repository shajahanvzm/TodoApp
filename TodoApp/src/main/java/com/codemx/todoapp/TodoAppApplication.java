package com.codemx.todoapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Account microservcies REST API Decumentation",
                description = "SBank Account microservcies REST API Decumentatio",
                version = "v1",
                contact = @Contact(
                        name = "Shajahan P",
                        email = "shajahanvzm@gmail.com",
                        url = "www.codemx.in"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "www.codemx.in"
                )

        )
)
public class TodoAppApplication {

    @Value("${spring.application.name}")
    private String appName;

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApplication.class, args);
    }

    @GetMapping
    public String index() {
        return "Website of " + appName +" is up!";
    }

}
