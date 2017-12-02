package com.opensanca.trilharest.filmes.filmes;

import java.time.Duration;
import java.util.UUID;

/**
 * Created by PEDRO on 28/10/2017.
 */
public class FilmeResumidoDTO {

    private UUID id;
    private String nome;
    private Duration duracao;

    public FilmeResumidoDTO(UUID id, String nome, Duration duracao) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }
}
