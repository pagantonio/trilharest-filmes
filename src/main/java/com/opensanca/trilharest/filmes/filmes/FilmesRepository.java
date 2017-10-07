package com.opensanca.trilharest.filmes.filmes;

import com.opensanca.trilharest.filmes.comum.Pagina;
import com.opensanca.trilharest.filmes.comum.ParametrosDePaginacao;

import java.util.UUID;

/**
 * Created by PEDRO on 07/10/2017.
 */
public interface FilmesRepository {

    Pagina<Filme> buscarPaginaEmExibicao(ParametrosDePaginacao parametrosDePaginacao);

    Filme buscarPorId(UUID id);
}
