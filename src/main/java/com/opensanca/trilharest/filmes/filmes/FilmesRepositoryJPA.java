package com.opensanca.trilharest.filmes.filmes;

import com.opensanca.trilharest.filmes.comum.Pagina;
import com.opensanca.trilharest.filmes.comum.ParametrosDePaginacao;
import com.opensanca.trilharest.filmes.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by PEDRO on 28/10/2017.
 */
@Repository
@Primary
public class FilmesRepositoryJPA implements FilmesRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Pagina<Filme> buscarPaginaEmExibicao(ParametrosDePaginacao parametrosDePaginacao, LocalDate referencia) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Filme> selectCriteria = cb.createQuery(Filme.class);
        Root<Filme> selectRoot = selectCriteria.from(Filme.class);
        selectCriteria.where(construirPredicadoEmExibicao(referencia, cb, selectRoot));

        TypedQuery<Filme> selectQuery = entityManager.createQuery(selectCriteria);
        selectQuery.setFirstResult(parametrosDePaginacao.getPagina() * parametrosDePaginacao.getTamanhoDaPagina());
        selectQuery.setMaxResults(parametrosDePaginacao.getTamanhoDaPagina());
        // select * from filmes where ? between f.inicioExibicao and f.fimExibicao

        CriteriaQuery<Long> countCriteria = cb.createQuery(Long.class);
        Root<Filme> countRoot = countCriteria.from(Filme.class);

        countCriteria.select(cb.count(cb.literal(1)));
        countCriteria.where(construirPredicadoEmExibicao(referencia, cb, countRoot));

        TypedQuery<Long> countQuery = entityManager.createQuery(countCriteria);
        // select count(1) from filmes where ? between f.inicioExibicao and f.fimExibicao

        Pagina<Filme> pagina = new Pagina<>();
        pagina.setRegistros(selectQuery.getResultList());
        pagina.setTotalDeRegistros(countQuery.getSingleResult().intValue());

        return pagina;
    }

    @Override
    public Filme buscarPorId(UUID id) throws NotFoundException {
        return entityManager.find(Filme.class, id);
    }

    private Predicate construirPredicadoEmExibicao(LocalDate referencia, CriteriaBuilder cb, Path<Filme> countRoot) {
        return cb.between(
                cb.literal(referencia),
                countRoot.get("inicioExibicao"),
                countRoot.get("fimExibicao")

        );
    }
}
