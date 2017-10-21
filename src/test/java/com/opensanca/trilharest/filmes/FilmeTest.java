package com.opensanca.trilharest.filmes;

import com.opensanca.trilharest.filmes.filmes.Filme;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by PEDRO on 21/10/2017.
 */
public class FilmeTest {

    @Test
    public void foraDeExibicaoSeDatasNulas() {
        LocalDate today = LocalDate.of(2017, 10, 20);
        Filme filme = new Filme(null, null, null, null, null, null);
        Assert.assertFalse(filme.emExibicao(today));
    }

    @Test
    public void foraDeExibicaoSeForaDeIntervaloDeDatas() {
        LocalDate inicioExibicao = LocalDate.of(2017, 10, 1);
        LocalDate fimExibicao = LocalDate.of(2017, 10, 13);

        LocalDate hoje = LocalDate.of(2017, 10, 20);

        Filme filme = new Filme(null, null, null, null, inicioExibicao, fimExibicao);

        Assert.assertFalse(filme.emExibicao(hoje));
    }

    @Test
    public void emExibicaoSeDentroDeIntervaloDeDatas() {
        LocalDate inicioExibicao = LocalDate.of(2017, 10, 1);
        LocalDate fimExibicao = LocalDate.of(2017, 10, 30);

        LocalDate hoje = LocalDate.of(2017, 10, 20);

        Filme filme = new Filme(null, null, null, null, inicioExibicao, fimExibicao);

        Assert.assertTrue(filme.emExibicao(hoje));
    }

    @Test
    public void emExibicaoSeInicioExatamenteHoje() {
        LocalDate inicioExibicao = LocalDate.of(2017, 10, 1);
        LocalDate fimExibicao = LocalDate.of(2017, 10, 30);

        Filme filme = new Filme(null, null, null, null, inicioExibicao, fimExibicao);

        Assert.assertTrue(filme.emExibicao(inicioExibicao));
    }

    @Test
    public void emExibicaoSeFimExatamenteHoje() {
        LocalDate fimExibicao = LocalDate.of(2017, 10, 5);
        Filme filme = new Filme(null, null, null, null,
                LocalDate.of(2017, 10, 1),
                fimExibicao);

        Assert.assertTrue(filme.emExibicao(fimExibicao));
    }
}
