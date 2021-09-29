package br.com.fiap.musica.controller;

import br.com.fiap.musica.dto.AuthDTO;
import br.com.fiap.musica.dto.TokenDTO;
import br.com.fiap.musica.dto.UsuarioCreateDTO;
import br.com.fiap.musica.dto.UsuarioDTO;
import br.com.fiap.musica.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("users")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO create(@RequestBody UsuarioCreateDTO usuarioCreateDTO){
        return usuarioService.create(usuarioCreateDTO);
    }

    @PostMapping("login")
    public TokenDTO login(@RequestBody AuthDTO authDTO){
        return usuarioService.login(authDTO);
    }

    @GetMapping("me")
    public UsuarioDTO me(){
        return usuarioService.getAuthenticatedUser();
    }
}
