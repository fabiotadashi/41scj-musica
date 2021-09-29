package br.com.fiap.musica.service;

import br.com.fiap.musica.dto.AuthDTO;
import br.com.fiap.musica.dto.TokenDTO;
import br.com.fiap.musica.dto.UsuarioCreateDTO;
import br.com.fiap.musica.dto.UsuarioDTO;

public interface UsuarioService {

    UsuarioDTO create(UsuarioCreateDTO usuarioCreateDTO);
    TokenDTO login(AuthDTO authDTO);
    UsuarioDTO getAuthenticatedUser();

}
