package br.com.fiap.musica.configuration;

import br.com.fiap.musica.service.PrecoValidator;
import br.com.fiap.musica.service.PrecoValidatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public PrecoValidator precoValidator(){
        return new PrecoValidatorImpl();
    }

}
