package com.github.integracao2017.cnes.implementacao.barramento;

/**
 * @author gabriel
 * @version 1.0.0
 *
 * Interface que define como as urls deverao ser passadas
 * para o barramento, cada servico do WebService devera ser
 * uma classe que implemente esta interface.
 */
public interface UrlCNES {

    /**@return Url do servico de producao.*/
    String urlProducao();

    /**@return  Url do servico de homologacao.*/
    String urlHomologacao();
}
