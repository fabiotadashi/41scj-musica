package br.com.fiap.musica.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MusicaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnMusicaList() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/songs")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.equalTo("Pais e Filhos")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price", Matchers.equalTo(5.2)));
    }

}
