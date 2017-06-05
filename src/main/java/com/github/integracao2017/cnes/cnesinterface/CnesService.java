package com.github.integracao2017.cnes.cnesinterface;

/**
 * @author Rony Nogueira
 * Enum que possui todas as chaves necessárias para o Parser de resposta do CnesService
 */
public enum CnesService {
    /**
     * Definição das chaves utilizadas pelo CnesService
     * Chaves INCOMPLETAS
     * */
    IBGE("ibge");
    /**
     * Guarda o valor da chave
     */
    private String chave;
    /**
     * Retorna o valor para a chave especificada
     * @return String
     * */
    public String getChave() {
        return this.chave;
    }
    /**
     * @param chave - nome da chave
     * */
    CnesService(String chave) {
        this.chave = chave;
    }

}
