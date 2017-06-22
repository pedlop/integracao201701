package com.github.integracao2017.cnes.cnesinterface;

/**
 * @author Rony Nogueira
 * Enum que possui todas as chaves necessárias para o Parser de resposta do CnesService
 */
public enum CnesService implements PadraoEnumChave {
    
    /**
     * Definição das chaves utilizadas pelo CnesService
     * Chaves INCOMPLETAS
     * */
    CODIGO_CNES("CodigoCNES"),
    CODIGO_UNIDADE("CodigoUnidade"),
    NOME_FANTASIA("nomeFantasia"),
    NOME_EMPRESARIAL("nomeEmpresarial"),
    ENDERECO_LOGRADOURO("nomeLogradouro"),
    ENDERECO_NUMERO("numero"),
    ENDERECO_COMPLEMENTO("complemento"),
    ENDERECO_BAIRRO("descricaoBairro"),
    ENDERECO_CEP("numeroCEP"),
    ENDERECO_CODIGO_MUNICIPIO("codigoMunicipio"),
    ENDERECO_NOME_MUNICIPIO("nomeMunicipio"),
    ENDERECO_CODIGO_UF("codigoUF"),
    ENDERECO_SIGLA_UF("siglaUF"),
    ENDERECO_DATA_ATUALIZACAO("dataAtualizacao"),
    DIRETOR_CPF("CPF"),
    DIRETOR_NOME("nome"),
    UNIDADE_CODIGO("codigo"),
    UNIDADE_DESCRICAO("descricao"),
    TIPO_TELEFONE_CODIGO("codigoTipoTelefone"),
    TIPO_TELEFONE_DESCRICAO("descricaoTipoTelefone"),
    TIPO_TELEFONE_DDD("DDD"),
    NUMERO_TELEFONE("numeroTelefone"),
    PROFISSIONAL_NOME("Nome"),
    PROFISSIONAL_CNS("numeroCNS"),
    PROFISSIONAL_CPF("numeroCPF"),
    PROFISSIONAL_CBO("codigoCBO"),
    PROFISSIONAL_DESCRICAO_CBO("descricaoCBO"),
    LEITO_CODIGO("codigo"),
    LEITO_DESCRICAO("descricao"),
    LEITO_DATA_ATUALIZACAO("dataAtualizacao"),
    LEITO_QUANTIDADE("quantidadeLeito"),
    LEITO_QUANTIDADE_SUS("quantidadeLeitoSUS"),
    SUMARIO_QTD_PROFISSIONAIS_SAUDE("quantidadeProfissionaisSaude"),
    SUMARIO_QTD_CBOS("quantidadeCBOS"),
    SUMARIO_QTD_LEITOS("quantidadeLeitos"),
    SUMARIO_QTD_HABILITACOES("quantidadeHabilitacoes"),
    SUMARIO_QTD_EQUIPAMENTOS("quantidadeEquipamentos"),
    SUMARIO_QTD_SAMU("quantidadeSamus");
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
