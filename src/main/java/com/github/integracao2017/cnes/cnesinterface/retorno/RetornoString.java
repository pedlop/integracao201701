package com.github.integracao2017.cnes.cnesinterface.retorno;

/**
 * @author gabriel
 * @version 1.0.0
 * Retorno de string simples.
 */
public class RetornoString extends Retorno {

    //RETORNO.
    private String retorno;

    /**@param retorno - conteudo do retorno.*/
    public RetornoString(String retorno) {
        this.retorno = retorno;
    }
    
    /**@return String simples de algum
     * atributo do xml.*/
    public String getRetorno() {
        return retorno;
    }
}
