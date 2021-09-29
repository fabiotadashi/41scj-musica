package br.com.fiap.musica.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("properties")
@ConditionalOnProperty(value = "fiap.debug", havingValue = "true")
public class PropertyController {

    private Environment env;

    public PropertyController(Environment env){
        this.env = env;
    }

    @GetMapping
    public String get(@RequestParam String name){
        return env.getProperty(name);
    }

}
