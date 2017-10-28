package com.opensanca.trilharest.filmes.filmes;

import com.opensanca.trilharest.filmes.comum.Pagina;
import com.opensanca.trilharest.filmes.comum.ParametrosDePaginacao;
import com.opensanca.trilharest.filmes.exception.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

/**
 * Created by PEDRO on 07/10/2017.
 */
@RestController
@RequestMapping("/filmes")
@Api
public class FilmesAPI {

    @Autowired
    private FilmesRepository filmesRepository;

    @GetMapping("/em-exibicao")
    @ApiOperation(
            value = "Buscar página de filmes em exibição",
            notes = "Permite a busca paginada de filmes em exibição, " +
                    "ou seja, filmes que possuam data de início e término " +
                    "de exibição e cujo período engloba a data atual")
    public Pagina<Filme> getEmExibicao(ParametrosDePaginacao parametrosDePaginacao) {
        if (parametrosDePaginacao == null) {
            parametrosDePaginacao = new ParametrosDePaginacao();
        }
        return filmesRepository.buscarPaginaEmExibicao(parametrosDePaginacao, LocalDate.now());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getPorId(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(filmesRepository.buscarPorId(id), OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }
}
