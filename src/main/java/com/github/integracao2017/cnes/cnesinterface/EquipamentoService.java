package com.github.integracao2017.cnes.cnesinterface;

/**
 * @author Lucas Vinicios
 * <p>
 *     Objetivo: marcar todas as chaves do HashMap
 *     da consulta do equipamento cadastrado no CNES.
 * </p>
 */

public enum EquipamentoService implements PadraoEnumChave {
	
	//Operacao: consultarEquipamento
	
	/** C�DIGO DO EQUIPAMENTO DO ESTABELECIMENTO DE SA�DE - TEXTO  */
    CODIGO_EQUIPAMENTO("CODIGO_EQUIPAMENTO"),
    /** DESCRI��O EQUIPAMENTO DO ESTABELECIMENTO DE SA�DE - TEXTO */
    DESCRICAO_EQUIPAMENTO("DESCRICAO_EQUIPAMENTO"),
    /** CODIGO DO TIPO DE EQUIPAMENTO DO ESTABELECIMENTO DE SA�DE - TEXTO */
    CODIGO_TIPOEQUIPAMENTO("CODIGO_TIPOEQUIPAMENTO"),
    /** DESCRI��O DO TIPO DE EQUIPAMENTO DO ESTABELECIMENTO DE SA�DE - TEXTO */
    DESCRICAO_TIPOEQUIPAMENTO("DESCRICAO_TIPOEQUIPAMENTO"),
    /** DESTINA��O DO EQUIPAMENTO - SUS, N�O SUS, AMBOS - TEXTO */
    DESTINACAO_EQUIPAMENTO("DESTINACAO_EQUIPAMENTO"),
    /** QUANTIDADE DE EQUIPAMENTOS NO ESTABELECIMENTO DE SA�DE - INTEGER*/
    QUANTIDADE_EQUIPAMENTO("QUANTIDADE_EQUIPAMENTO"),
    /** QUANTIDADE DE EQUIPAMENTOS EM USO NO ESTABELECIMENTO DE SA�DE - INTEGER*/
    QUANTIDADEUSO_EQUIPAMENTO("QUANTIDADEUSO_EQUIPAMENTO"),
    /** INDICA SE O EQUIPAMENTO EST� DISPON�VEL PARA O SUS. 1- SIM. 2 - N�O. - INDICADORSUSTYPE - TEXTO - TAMANHO M�NIMO:1 - TAMANHO M�XIMO:1*/
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
