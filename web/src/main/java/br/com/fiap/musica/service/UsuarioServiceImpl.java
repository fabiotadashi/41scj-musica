package br.com.fiap.musica.service;

import br.com.fiap.musica.dto.AuthDTO;
import br.com.fiap.musica.dto.TokenDTO;
import br.com.fiap.musica.dto.UsuarioCreateDTO;
import br.com.fiap.musica.dto.UsuarioDTO;
import br.com.fiap.musica.entity.Usuario;
import br.com.fiap.musica.repository.UsuarioRepository;
import br.com.fiap.musica.security.JwtTokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            AuthenticationManager authenticationManager,
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UsuarioDTO create(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioCreateDTO.getNome());
        usuario.setSenha(passwordEncoder.encode(usuarioCreateDTO.getSenha()));

        Usuario usuarioSaved = usuarioRepository.save(usuario);

        return new UsuarioDTO(usuarioSaved);
    }

    @Override
    public TokenDTO login(AuthDTO authDTO) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authDTO.getNome(), authDTO.getSenha());
        try {
            authenticationManager.authenticate(authentication);
        } catch (DisabledException disabledException) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user.disabled");
        } catch (BadCredentialsException badCredentialsException) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "bad.credentials");
        }

        String token = jwtTokenUtil.generateToken(authDTO.getNome());

        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(token);

        return tokenDTO;
    }

    @Override
    public UsuarioDTO getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails details = (UserDetails) authentication.getPrincipal();
        String username = details.getUsername();
        Usuario usuario = usuarioRepository.findFirstByNome(username);
        return new UsuarioDTO(usuario);
    }
}
