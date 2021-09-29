package br.com.fiap.musica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioCreateDTO {

    @JsonProperty("username")
    private String nome;

    @JsonProperty("password")
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
