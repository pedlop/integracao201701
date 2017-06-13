package com.github.integracao2017.cnes.implementacao;

import java.util.function.Consumer;

/**
 * @author gabriel
 * Prover interface entre a classe que faz o parse
 * de XML {@link CNES} com a classe que realiza o request
 * ao servidor {@link ConexaoCNES}.
 */
public interface Conexao {

    /**@param cnes - Codigo numero cnes.
     * @param consumer - Consumer<String> que ira
     * tratar a String XML assim que a mesma chegar ao servidor.*/
    void consultarEstabelecimento(String cnes, Consumer<String> consumer);
    
    
    
    /**@param numeroCns - Codigo numero cns do profissional.
     * @param consumer - Consumer<String> que ira
     * tratar a String XML assim que a mesma chegar ao servidor.*/
    void consultarProfissionalSaude(String numeroCns, Consumer<String> consumer);
    
    /**@param numeroCnes - Codigo numero cnes.
     * @param consumer - Consumer<String> que ira
     * tratar a String XML assim que a mesma chegar ao servidor.*/
    void consultarProfissionaisSaude(String numeroCnes, Consumer<String> consumer);
}
