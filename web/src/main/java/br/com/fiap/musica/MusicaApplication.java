package br.com.fiap.musica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MusicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicaApplication.class, args);
    }

}
