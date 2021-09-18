package br.com.fiap.musica.service;

import br.com.fiap.musica.dto.MusicaDTO;

public class PrecoValidatorImpl implements PrecoValidator {

    @Override
    public boolean validate(MusicaDTO musicaDTO) {
        return !(musicaDTO.getDuracao() <= 60 && musicaDTO.getPreco().doubleValue() > 5);
    }

}
