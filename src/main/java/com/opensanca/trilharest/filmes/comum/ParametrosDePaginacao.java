package com.opensanca.trilharest.filmes.comum;

import io.swagger.annotations.ApiParam;

/**
 * Created by PEDRO on 07/10/2017.
 */
public class ParametrosDePaginacao {

    @ApiParam(value = "Número da página desejada", defaultValue = "0")
    private Integer pagina;

    @ApiParam(value = "Tamanho máximo da página", defaultValue = "3")
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
