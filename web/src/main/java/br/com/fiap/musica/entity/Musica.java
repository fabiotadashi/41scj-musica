package br.com.fiap.musica.entity;

import br.com.fiap.musica.dto.MusicaCreateUpdateDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "TB_MUSICA")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nome;

    @Column
    private int duracao;

    @Column
    private String autor;

    @Column
    private LocalDate dataLancamento;

    @Column
    private BigDecimal preco;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    @CreatedDate
    private Date dataCriacao;

    @Column(name = "data_ultima_atualizacao")
    @LastModifiedDate
    private Date dataUltimaAtualizacao;

    public Musica(MusicaCreateUpdateDTO musicaCreateUpdateDTO) {
        this.nome = musicaCreateUpdateDTO.getNome();
        this.duracao = musicaCreateUpdateDTO.getDuracao();
        this.autor = musicaCreateUpdateDTO.getAutor();
        this.dataLancamento = musicaCreateUpdateDTO.getDataLancamento();
        this.preco = musicaCreateUpdateDTO.getPreco();
    }

    public Musica() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
}
