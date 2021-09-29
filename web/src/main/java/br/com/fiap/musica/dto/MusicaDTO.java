package br.com.fiap.musica.dto;

import br.com.fiap.musica.entity.Musica;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

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

    @JsonProperty("createdDate")
    private LocalDateTime dataCriacao;

    @JsonProperty("lastUpdatedDate")
    private LocalDateTime dataUltimaAtualizacao;

    public MusicaDTO(){}

    public MusicaDTO(MusicaCreateUpdateDTO musicaCreateUpdateDTO) {
        this.nome = musicaCreateUpdateDTO.getNome();
        this.duracao = musicaCreateUpdateDTO.getDuracao();
        this.autor = musicaCreateUpdateDTO.getAutor();
        this.dataLancamento = musicaCreateUpdateDTO.getDataLancamento();
        this.preco = musicaCreateUpdateDTO.getPreco();
    }

    public MusicaDTO(Musica musica) {
        this.id = musica.getId();
        this.nome = musica.getNome();
        this.duracao = musica.getDuracao();
        this.autor = musica.getAutor();
        this.dataLancamento = musica.getDataLancamento();
        this.preco = musica.getPreco();
        this.dataCriacao = LocalDateTime.ofInstant(musica.getDataCriacao().toInstant(), ZoneOffset.systemDefault());
        this.dataUltimaAtualizacao = LocalDateTime.ofInstant(musica.getDataUltimaAtualizacao().toInstant(), ZoneOffset.systemDefault());
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
}
