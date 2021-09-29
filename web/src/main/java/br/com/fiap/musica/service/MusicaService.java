package br.com.fiap.musica.service;

import br.com.fiap.musica.dto.MusicaCreateUpdateDTO;
import br.com.fiap.musica.dto.MusicaDTO;
import br.com.fiap.musica.dto.MusicaPrecoDTO;
import br.com.fiap.musica.dto.MusicaSimpleDTO;

import java.util.List;

public interface MusicaService {

    List<MusicaSimpleDTO> list(String nome);
    MusicaDTO findById(long id);
    MusicaDTO create(MusicaCreateUpdateDTO musicaCreateUpdateDTO);
    MusicaDTO update(long id, MusicaCreateUpdateDTO musicaCreateUpdateDTO);
    MusicaDTO updatePreco(long id, MusicaPrecoDTO musicaPrecoDTO);
    void delete(long id);

}
