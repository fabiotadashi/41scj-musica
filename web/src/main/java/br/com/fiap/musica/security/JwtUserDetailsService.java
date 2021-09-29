package br.com.fiap.musica.security;

import br.com.fiap.musica.entity.Usuario;
import br.com.fiap.musica.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    public JwtUserDetailsService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findFirstByNome(username);
        if(usuario == null){
            throw new UsernameNotFoundException("username.not.found");
        }

        return new User(
                usuario.getNome(),
                usuario.getSenha(),
                new ArrayList<>() // Roles
        );
    }

}
