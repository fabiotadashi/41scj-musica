package br.com.fiap.musica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MusicaSimpleDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String nome;

    @JsonProperty("price")
    private BigDecimal preco;

    public MusicaSimpleDTO(){}

    public MusicaSimpleDTO(MusicaDTO musicaDTO) {
        this.id = musicaDTO.getId();
        this.nome = musicaDTO.getNome();
        this.preco = musicaDTO.getPreco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
