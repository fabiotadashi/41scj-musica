package br.com.fiap.musica.dto;

import br.com.fiap.musica.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("username")
    private String nome;

    public UsuarioDTO(){}

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }

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

}
