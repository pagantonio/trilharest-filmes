package com.opensanca.trilharest.filmes.filmes;

import com.opensanca.trilharest.filmes.exception.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

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
    public Page<FilmeResumidoDTO> getEmExibicao(Pageable parametrosDePaginacao) {
        if (parametrosDePaginacao == null) {
            parametrosDePaginacao = new PageRequest(0, 3);
        }
        return filmesRepository.buscarPaginaEmExibicao(parametrosDePaginacao, LocalDate.now());
    }

    @GetMapping("/{id}")
    public FilmeDetalhadoDTO getPorId(@PathVariable UUID id) {
        final Filme entidade = filmesRepository.findOne(id);
        if (entidade == null) throw new NotFoundException();

        return new FilmeDetalhadoDTO(entidade);
    }

    @PostMapping
    public UUID cadastrar(@RequestBody FilmeFormDTO dados) {
        Filme entidade = dados.construir();
        filmesRepository.save(entidade);
        return entidade.getId();
    }

    @PutMapping("/{id}")
    public void alterar(@RequestBody FilmeFormDTO dados, @PathVariable UUID id) {
        Filme entidade = filmesRepository.findOne(id);
        dados.preencher(entidade);
        filmesRepository.save(entidade);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable UUID id) {
        filmesRepository.delete(id);
    }
}
