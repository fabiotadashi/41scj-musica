package br.com.fiap.musica.security;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private Logger logger = Logger.getLogger(JwtRequestFilter.class.getName());

    private JwtTokenUtil jwtTokenUtil;
    private JwtUserDetailsService jwtUserDetailsService;

    public JwtRequestFilter(
            JwtTokenUtil jwtTokenUtil,
            JwtUserDetailsService jwtUserDetailsService
    ) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        String nome = null;

        if (requestToken != null && requestToken.startsWith("Bearer ")) {
            try {
                nome = jwtTokenUtil.getUserFromToken(requestToken);
            } catch (IllegalArgumentException illegalArgumentException) {
                logger.info("Erro ao fazer parse do token");
            } catch (ExpiredJwtException expiredJwtException) {
                logger.info("Token expirado");
            }
        } else {
            logger.info("Token inválido ou não começa com Bearer");
        }

        if(nome != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(nome);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);

    }

}
