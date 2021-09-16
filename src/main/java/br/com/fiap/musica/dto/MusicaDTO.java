package br.com.fiap.musica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MusicaDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String nome;

    @JsonProperty("duration")
    private int duracao;

    @JsonProperty("author")
    private String autor;

    @JsonProperty("releaseDate")
    private LocalDate dataLancamento;

    @JsonProperty("price")
    private BigDecimal preco;

    public MusicaDTO(){}

    public MusicaDTO(MusicaCreateUpdateDTO musicaCreateUpdateDTO) {
        this.nome = musicaCreateUpdateDTO.getNome();
        this.duracao = musicaCreateUpdateDTO.getDuracao();
        this.autor = musicaCreateUpdateDTO.getAutor();
        this.dataLancamento = musicaCreateUpdateDTO.getDataLancamento();
        this.preco = musicaCreateUpdateDTO.getPreco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
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
