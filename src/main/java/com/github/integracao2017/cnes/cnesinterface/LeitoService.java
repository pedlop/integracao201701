package com.github.integracao2017.cnes.cnesinterface;

/**
 * @author  gabriel
 * @version 1.0.0
 *         <p>
 *         Objetivo marcar todas as chaves do HasMap da consulta de
 *         estabelecimento de saúde. Objetivo marcar todas as chaves do HasMap
 *         da consulta de estabelecimento de saúde.
 *         </p>
 */
public enum LeitoService implements PadraoEnumChave {

    /** CÓDIGO NUMÉRICO DE NO MÁXIMO 7 CARACTERES.*/
    CODIGO("CODIGO"),

    /** */
    DESCRICAO("DESCRICAO"),

    DATA_ATUALIZACAO("DATA_ATUALIZACAO"),
    QUANTIDADE_LEITO("QUANTIDADE_LEITO"),
    QUANTIDADE_LEITO_SUS("QUANTIDADE_LEITO_SUS");

    /** Variavel para guardar o valor do campo.*/
    private String chave;

    /**@return Nome do campo.*/
    public String getChave() {
        return chave;
    }

    /**@param e - Nome do campo.*/
    LeitoService(String e) {
        chave = e;
    }
}
