package com.opensanca.trilharest.filmes.filmes;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by PEDRO on 07/10/2017.
 */
public class Filme {

    private UUID id;
    private String nome;
    private String sinopse;
    private Duration duracao;
    private LocalDate inicioExibicao;
    private LocalDate fimExibicao;

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

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public LocalDate getInicioExibicao() {
        return inicioExibicao;
    }

    public void setInicioExibicao(LocalDate inicioExibicao) {
        this.inicioExibicao = inicioExibicao;
    }

    public LocalDate getFimExibicao() {
        return fimExibicao;
    }

    public void setFimExibicao(LocalDate fimExibicao) {
        this.fimExibicao = fimExibicao;
    }
}
