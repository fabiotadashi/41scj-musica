package br.com.fiap.musica.configuration;

import br.com.fiap.musica.service.PrecoValidator;
import br.com.fiap.musica.service.PrecoValidatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeansConfig {

    @Bean
    public PrecoValidator precoValidator(){
        return new PrecoValidatorImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
