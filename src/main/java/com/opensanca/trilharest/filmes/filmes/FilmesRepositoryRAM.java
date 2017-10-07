package com.opensanca.trilharest.filmes.filmes;

import com.opensanca.trilharest.filmes.comum.Pagina;
import com.opensanca.trilharest.filmes.comum.ParametrosDePaginacao;

import java.util.UUID;

/**
 * Created by PEDRO on 07/10/2017.
 */
public class FilmesRepositoryRAM implements FilmesRepository {

    @Override
    public Pagina<Filme> buscarPaginaEmExibicao(ParametrosDePaginacao parametrosDePaginacao) {
        return null;
    }

    @Override
    public Filme buscarPorId(UUID id) {
        throw new UnsupportedOperationException("Nao deu tempo");
    }
}
