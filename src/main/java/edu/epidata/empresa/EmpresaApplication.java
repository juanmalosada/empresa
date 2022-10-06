package edu.epidata.empresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EmpresaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpresaApplication.class, args);
    }

}
