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
	
	/** CÓDIGO DO EQUIPAMENTO DO ESTABELECIMENTO DE SAÚDE - TEXTO  */
    CODIGO_EQUIPAMENTO("CODIGO_EQUIPAMENTO"),
    /** DESCRIÇÃO EQUIPAMENTO DO ESTABELECIMENTO DE SAÚDE - TEXTO */
    DESCRICAO_EQUIPAMENTO("DESCRICAO_EQUIPAMENTO"),
    /** CODIGO DO TIPO DE EQUIPAMENTO DO ESTABELECIMENTO DE SAÚDE - TEXTO */
    CODIGO_TIPOEQUIPAMENTO("CODIGO_TIPOEQUIPAMENTO"),
    /** DESCRIÇÃO DO TIPO DE EQUIPAMENTO DO ESTABELECIMENTO DE SAÚDE - TEXTO */
    DESCRICAO_TIPOEQUIPAMENTO("DESCRICAO_TIPOEQUIPAMENTO"),
    /** DESTINAÇÃO DO EQUIPAMENTO - SUS, NÃO SUS, AMBOS - TEXTO */
    DESTINACAO_EQUIPAMENTO("DESTINACAO_EQUIPAMENTO"),
    /** QUANTIDADE DE EQUIPAMENTOS NO ESTABELECIMENTO DE SAÚDE - INTEGER*/
    QUANTIDADE_EQUIPAMENTO("QUANTIDADE_EQUIPAMENTO"),
    /** QUANTIDADE DE EQUIPAMENTOS EM USO NO ESTABELECIMENTO DE SAÚDE - INTEGER*/
    QUANTIDADEUSO_EQUIPAMENTO("QUANTIDADEUSO_EQUIPAMENTO"),
    /** INDICA SE O EQUIPAMENTO ESTÁ DISPONÍVEL PARA O SUS. 1- SIM. 2 - NÃO. - INDICADORSUSTYPE - TEXTO - TAMANHO MÍNIMO:1 - TAMANHO MÁXIMO:1*/
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
