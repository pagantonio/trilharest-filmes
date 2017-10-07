package com.opensanca.trilharest.filmes.filmes;

import com.opensanca.trilharest.filmes.comum.Pagina;
import com.opensanca.trilharest.filmes.comum.ParametrosDePaginacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by PEDRO on 07/10/2017.
 */
@RestController
@RequestMapping("/filmes")
public class FilmesAPI {

    @Autowired
    private FilmesRepository filmesRepository;

    @GetMapping("/em-exibicao")
    public Pagina<Filme> getEmExibicao(ParametrosDePaginacao parametrosDePaginacao) {
        return filmesRepository.buscarPaginaEmExibicao(parametrosDePaginacao);
    }
}
