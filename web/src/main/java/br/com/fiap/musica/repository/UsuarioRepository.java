package br.com.fiap.musica.repository;

import br.com.fiap.musica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findFirstByNome(String nome);

}
