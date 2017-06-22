package com.github.integracao2017.cnes.cnesinterface;

/**
 * Created by Lucas Vinicios.
 */
public enum EquipamentoService implements PadraoEnumChave {

    CODIGO_EQUIPAMENTO("CODIGO_CNES"),
    DESCRICAO_EQUIPAMENTO("CODIGO_UNIDADE"),
    CODIGO_TIPOEQUIPAMENTO("NOME_FANTASIA"),
    DESCRICAO_TIPOEQUIPAMENTO("NOME_EMPRESARIAL"),
    DESTINACAO_EQUIPAMENTO("CNPJ"),
    QUANTIDADE_EQUIPAMENTO("INDENTIFICADOR"),
    QUANTIDADEUSO_EQUIPAMENTO("LONGINTUDE"),
    DISPONIBILIDADESUS_EQUIPAMENTO("LATITUDE");


    /** Variavel para guardar o valor do campo.*/
    private String chave;

    /**@return Nome do campo.*/
    public String getChave() {
        return chave;
    }

    /**@param e - Nome do campo.*/
    EquipamentoService(String e) {
       chave = e;
    }
}
