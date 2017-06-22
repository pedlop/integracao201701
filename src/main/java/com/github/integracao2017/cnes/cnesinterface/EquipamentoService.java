package com.github.integracao2017.cnes.cnesinterface;

/**
 * Created by Lucas Vinicios.
 */
public enum EquipamentoService implements PadraoEnumChave {

    CODIGO_EQUIPAMENTO("CODIGO_EQUIPAMENTO"),
    DESCRICAO_EQUIPAMENTO("DESCRICAO_EQUIPAMENTO"),
    CODIGO_TIPOEQUIPAMENTO("CODIGO_TIPOEQUIPAMENTO"),
    DESCRICAO_TIPOEQUIPAMENTO("DESCRICAO_TIPOEQUIPAMENTO"),
    DESTINACAO_EQUIPAMENTO("DESTINACAO_EQUIPAMENTO"),
    QUANTIDADE_EQUIPAMENTO("QUANTIDADE_EQUIPAMENTO"),
    QUANTIDADEUSO_EQUIPAMENTO("QUANTIDADEUSO_EQUIPAMENTO"),
    DISPONIBILIDADESUS_EQUIPAMENTO("DISPONIBILIDADESUS_EQUIPAMENTO");


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
