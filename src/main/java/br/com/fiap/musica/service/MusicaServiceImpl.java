package br.com.fiap.musica.service;

import br.com.fiap.musica.dto.MusicaCreateUpdateDTO;
import br.com.fiap.musica.dto.MusicaDTO;
import br.com.fiap.musica.dto.MusicaPrecoDTO;
import br.com.fiap.musica.dto.MusicaSimpleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Override
    public List<MusicaSimpleDTO> list(String nome) {
        return null;
    }

    @Override
    public MusicaDTO findById(long id) {
        return null;
    }

    @Override
    public MusicaDTO create(MusicaCreateUpdateDTO musicaCreateUpdateDTO) {
        return null;
    }

    @Override
    public MusicaDTO update(long id, MusicaCreateUpdateDTO musicaCreateUpdateDTO) {
        return null;
    }

    @Override
    public MusicaDTO updatePreco(long id, MusicaPrecoDTO musicaPrecoDTO) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
