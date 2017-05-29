package com.github.integracao2017.cnes.cnesinterface;

/**
 * @author pedro
 * <p>
 *     Objetivo: marcar todas as chaves do HashMap
 *     da consulta da vinculação do profissional de saúde.
 * </p>
 */

public enum VinculacaoProfissionalService {

    //Operação: detalharVinculacaoProfissionalSaude
    /** NOME DO PROFISSIONAL DE SAÚDE - TEXTO - MÁX 150 CARACTERES.*/
    PROF_NOME("PROF_NOME"),
    /** CPF DO PROFISSIONAL DE SAÚDE - TEXTO - MÁX 15 CARACTERES.*/
    PROF_CPF("PROF_CPF"),
    /** CNS DO PROFISSIONAL DE SAÚDE - TEXTO - MÁX 15 CARACTERES.*/
    PROF_CNS_NUM("PROF_CNS_NUM"),
    /** DATA DE ATRIBUIÇÃO DO CARTÃO - DATA */
    PROF_CNS_DATA_ATRIB("PROF_CNS_DATA_ATRIB"),
    /** TIPO DO CARTÃO: [P=Provisório, D=Definitivo] - DOMÍNIO - MÁX 7 CARACTERES */
    PROF_CNS_TIPO_CARTAO("PROF_CNS_TIPO_CARTAO"),
    /** IDENTIFICA SE O CARTÃO FOI ADICIONADO - BOOLEANO */
    PROF_CNS_MANUAL("PROF_CNS_MANUAL"),
    /** JUSTIFICATIVA P/ ADIÇÃO DO CARTÃO MANUAL - TEXTO - MÁX 200 CARATERES */
    PROF_CNS_JUST_MANUAL("PROF_CNS_JUST_MANUAL"),
    /** CÓDIGO CNES DO ESTABELIECIMENTO - TEXTO - MÁX 7 CARACTERES */
    CODIGO_CNES("CODIGO_CNES"),
    /** NOME FANTASIA DO ESTABELECIMENTO - TEXTO - MÁX 150 CARACTERES */
    NOME_FANTASIA("NOME_FANTASIA"),
    /** CÓDIGO IDENTIFICADOR DA VINCULAÇÃO - TEXTO - MÁX 8 CARACTERES */
    VINCULACAO_IND("VINCULACAO_IND"),
    /** CÓDIGO DA MODALIDADE DO VÍNCULO - TEXTO - MÁX 8 CARACTERES */
    VINCULO_COD_MOD("VINCULO_COD_MOD"),
    /** DESCRIÇÃO DA MODALIDADE DO VÍNCULO - TEXTO - MÁX 100 CARACTERES */
    VINCULO_COD_MOD_DESC("VINCULO_COD_MOD_DESC"),
    /** CÓDIGO DO TIPO DA MODALIDADE DO VÍNCULO - TEXTO - MÁX 8 CARACTERES */
    VINCULO_COD_MOD_TIPO("VINCULO_COD_MOD_TIPO"),
    /** DESCRIÇÃO DO TIPO DA MODALIDADE DO VÍNCULO - TEXTO - MÁX 100 CARACTERES */
    VINCULO_COD_MOD_TIPO_DESC("VINCULO_COD_MOD_TIPO_DESC"),
    /** CÓDIGO DO SUBTIPO DA MODALIDADE DO VÍNCULO - TEXTO - MÁX 8 CARACTERES */
    VINCULO_COD_MOD_SUB_TIPO("VINCULO_COD_MOD_SUB_TIPO"),
    /** DESCRIÇÃO DO SUBTIPO DA MODALIDADE DO VÍNCULO - TEXTO - MÁX 100 CARACTERES */*/
    VINCULO_COD_MOD_SUB_TIPO_DESC("VINCULO_COD_MOD_SUB_TIPO_DESC"),
    /** CÓDIGO IDENTIFICADOR DO CBO */
    CBO_COD("CBO_COD"),
    /** DESCRIÇÃO DO CBO */
    CBO_DESC("CBO_DESC"),
    /** CARGA HORÁRIA AMBULATORIAL DO PROFISSIONAL NO ESTABELECIMENTO */
    QTD_CARGA_HR_AMUBULATOTIAL("QTD_CARGA_HR_AMUBULATOTIAL"), //NOME (AMBULATORIAL) ESCRITO ERRONEAMENTE NO DOCUMENTO DO CNES
    /** CARGA HORÁRIA DE OUTROS TIPOS DO PROFISSIONAL NO ESTABELECIMENTO */
    QTD_CARGA_HR_OUTROS("QTD_CARGA_HR_OUTROS"),
    /** CARGA HORÁRIA HOSPITAL SUS */
    QTD_CARGA_HR_HOSP_SUS("QTD_CARGA_HR_HOSP_SUS"),
    /** DATA DE INÍCIO DO VINCULO */
    COMPT_INICIO("COMPT_INICIO"),
    /** DATA DE TÉRMINO DO VINCULO */
    COMPT_FIM("COMPT_FIM"),

    /** VARIÁVEIS QUE NÃO EXISTEM ACIMA */
    //Operação: pesquisarVinculacaoProfissionalSaude
    /** POSIÇÃO INICIAL DO REGISTRO NA PAGINAÇÃO - NUMÉRICO - MÁX 7 CARACTERES */
    PAG_POS_INICIAL_REGISTRO("PAG_POS_INICIAL_REGISTRO"),
    /** QUANTIDADE DE REGISTROS POR PÁGINA - NUMÉRICO - MÁX 7 CARACTERES */
    PAG_QTD_REGISTROS("PAG_QTD_REGISTROS"),
    /** QUANTIDADE TOTAL DE REGISTROS - NUMÉRICO - MÁX 7 CARACTERES */
    PAG_TOTAL_REGISTROS("PAG_TOTAL_REGISTROS");


    /** Variavel para guardar o valor do campo.*/
    private String chave;

    /**@return Nome do campo.*/
    public String getChave() {
        return chave;
    }

    /**@param e - Nome do campo.*/
    VinculacaoProfissionalService(String e) {
        chave = e;
    }

}