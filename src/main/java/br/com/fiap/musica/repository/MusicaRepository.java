package br.com.fiap.musica.repository;

import br.com.fiap.musica.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    List<Musica> findAllByNomeStartsWith(String nome);

    @Query("from Musica m where m.nome like :nome%")
    List<Musica> buscarPorNome(String nome);

}
