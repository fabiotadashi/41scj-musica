package br.com.fiap.musica.controller;

import br.com.fiap.musica.dto.MusicaSimpleDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MusicaControllerTest {

    @Test
    public void shouldFilterByName(){

        MusicaController musicaController = new MusicaController();

        List<MusicaSimpleDTO> musicaList = musicaController.list("Pais");

        assertThat(musicaList.size(), equalTo(1));
        assertThat(musicaList.get(0).getNome(), equalTo("Pais e Filhos"));
        assertThat(musicaList.get(0).getPreco(), equalTo(BigDecimal.valueOf(5.2)));

    }

}
