package com.opensanca.trilharest.filmes.comum;

/**
 * Created by PEDRO on 07/10/2017.
 */
public class ParametrosDePaginacao {

    private Integer pagina; // 0-based
    private Integer tamanhoDaPagina;

    public ParametrosDePaginacao() {
        this.pagina = 0;
        this.tamanhoDaPagina = 10;
    }

    public ParametrosDePaginacao(Integer pagina, Integer tamanhoDaPagina) {
        this.pagina = pagina;
        this.tamanhoDaPagina = tamanhoDaPagina;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Integer getTamanhoDaPagina() {
        return tamanhoDaPagina;
    }

    public void setTamanhoDaPagina(Integer tamanhoDaPagina) {
        this.tamanhoDaPagina = tamanhoDaPagina;
    }
}
