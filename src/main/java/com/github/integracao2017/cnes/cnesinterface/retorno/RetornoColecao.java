package com.github.integracao2017.cnes.cnesinterface.retorno;

import java.util.Collection;

/**
 * @author gabriel
 * @version 1.0.0
 *
 * Objetivo reprentar colecoes de retorno que
 * poderao ser atribuidas a um atributo do hashmap.
 *
 */
public class RetornoColecao extends Retorno {

    /** Colecao de atributos.*/
    private Collection<? extends Retorno> colecao;

    /**@param c - Colecao que sera atribuida a uma
     * chave do hasmap.*/
    public RetornoColecao(Collection<? extends Retorno> c) {
        colecao = c;
    }

    /**@return Colecao de atributos que correponde a uma
     * chave do hash map.*/
    public Collection<? extends Retorno> getColecao() {
        return colecao;
    }

}
