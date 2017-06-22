package com.github.integracao2017.cnes.cnesinterface;

/**
 * @author  gabriel
 * @version 1.0.0
 *         <p>
 *         Objetivo marcar todas as chaves do HasMap da consulta de
 *         estabelecimento de saúde. Objetivo marcar todas as chaves do HasMap
 *         da consulta de estabelecimento de saúde.
 *         </p>
 */
public enum EstabelecimentoSaudeService implements PadraoEnumChave {

    /** CÓDIGO NUMÉRICO DE NO MÁXIMO 7 CARACTERES.*/
    CODIGO_CNES("CODIGO_CNES"),
    
    /** */
    CODIGO_UNIDADE("CODIGO_UNIDADE"),
    
    NOME_FANTASIA("NOME_FANTASIA"),
    NOME_EMPRESARIAL("NOME_EMPRESARIAL"),
    CNPJ("CNPJ"),
    INDENTIFICADOR("INDENTIFICADOR"),
    TIPO_ENDERECO("TIPO_ENDERECO"),
    COD_TIPO_LORGADOURO("COD_TIPO_LORGADOURO"),
    DESC_TIPO_LORGADOURO("DESC_TIPO_LORGADOURO"),
    NOME_LORGADOURO("NOME_LORGADOURO"),
    NUM_ENDERECO("NUM_ENDERECO"),
    CMPLMT_ENDERECO("CMPLMT_ENDERECO"),
    COD_BAIRRO("COD_BAIRRO"),
    DESC_BAIRRO("DESC_BAIRRO"),
    NUM_CEP("NUM_CEP"),
    COD_MUNICIPIO("COD_MUNICIPIO"),
    NOME_MUNICIPIO("NOME_MUNICIPIO"),
    COD_UF("COD_UF"),
    SIGLA_UF("SIGLA_UF"),
    COD_REGIAO("COD_REGIAO"),
    NOME_UF("NOME_UF"),
    COD_PAIS("COD_PAIS"),
    COD_PAIS_ANT("COD_PAIS_ANT"),
    NOME_PAIS("NOME_PAIS"),
    MUNICIPIO_INTERN("MUNICIPIO_INTERN"),
    DATA_ATUALIZACAO("DATA_ATUALIZACAO"),
    DIRT_CPF("DIRT_CPF"),
    DIRT_NOME("DIRT_NOME"),
    TIP_UN_COD("TIP_UN_COD"),
    TIP_UN_DESC("TIP_UN_DESC"),
    ESF_ADM_COD("ESF_ADM_COD"),
    ESF_ADM_DESC("ESF_ADM_DESC"),
    MN_GEST_COD_MUNI("MN_GEST_COD_MUNI"),
    MN_GEST_NOME_MUNI("MN_GEST_NOME_MUNI"),
    MN_GEST_COD_UF("MN_GEST_COD_UF"),
    MN_GEST_SIGLA_UF("MN_GEST_SIGLA_UF"),
    MN_GEST_COD_REG("MN_GEST_COD_REG"),
    MN_GEST_NOME_UF("MN_GEST_NOME_UF"),
    TELEFONES("TELEFONES"),
    EMAIL_INDENTF("EMAIL_INDENTF"),
    EMAIL_DESC("EMAIL_DESC"),
    EMAIL_TIPO("EMAIL_TIPO"),
    EMAIL_VALID("EMAIL_VALID"),
    LONGINTUDE("LONGINTUDE"),
    LATITUDE("LATITUDE"),
    GEO_JSON("GEO_JSON"),
    PERT_SIST_SUS("PERT_SIST_SUS");


    /** Variavel para guardar o valor do campo.*/
    private String chave;

    /**@return Nome do campo.*/
    public String getChave() {
        return chave;
    }

    /**@param e - Nome do campo.*/
    EstabelecimentoSaudeService(String e) {
        chave = e;
    }
}
