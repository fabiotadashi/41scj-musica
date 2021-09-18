package br.com.fiap.musica.service;

import br.com.fiap.musica.dto.MusicaDTO;

public interface PrecoValidator {

    boolean validate(MusicaDTO musicaDTO);

}
