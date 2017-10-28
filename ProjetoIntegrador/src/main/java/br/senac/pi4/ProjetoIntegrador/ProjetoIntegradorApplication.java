package br.senac.pi4.ProjetoIntegrador;

import javax.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoIntegradorApplication {

    public static void main(String[] args) {

        Persistence.generateSchema("projeto4", null);
        SpringApplication.run(ProjetoIntegradorApplication.class, args);

    }
}
