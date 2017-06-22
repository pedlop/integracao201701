package com.github.integracao2017.cnes.cnesinterface;

/**
 * @author gabriel
 * @version 1.0.0
 * 
 *          Interface que define o padrão que toda implementação de ENUM de chaves
 *          deverá seguir, interface está que facilita a implementação do código
 *          de teste bem como padroniza o formato dos enuns.
 */
public interface PadraoEnumChave {
    
    /**
     * @return Chave para achar o conteúdo dentro do MAP.
     * */
    String getChave();
}
