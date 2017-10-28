package com.opensanca.trilharest.filmes.filmes;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by PEDRO on 07/10/2017.
 */
@Entity
public class Filme {

    @Id
    private UUID id;
    private String nome;
    private String sinopse;

    @ApiModelProperty("Duração do filme sem trailers")
    private Duration duracao;

    private LocalDate inicioExibicao;
    private LocalDate fimExibicao;

    public Filme() {
    }

    public Filme(UUID id, String nome, String sinopse, Duration duracao, LocalDate inicioExibicao, LocalDate fimExibicao) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.inicioExibicao = inicioExibicao;
        this.fimExibicao = fimExibicao;
    }

    public Boolean emExibicao(LocalDate today) {
        return !(inicioExibicao == null || fimExibicao == null)
                && (today.isEqual(inicioExibicao) || today.isAfter(inicioExibicao))
                && (today.isEqual(fimExibicao) || today.isBefore(fimExibicao));
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
