package com.github.integracao2017.cnes.cnesinterface;

/**
 * @author gabriel
 *         <p>
 *         Interface que define todos os servicos.
 *         Barramento que define todos os servicos definidos, no documento do catalogo de servicos porem
 *         com abstracao do componenet, a implementação das requisicoes sao feitas de maneira assincrona.
 *         Ou seja para cada servico devera ser passado uma implementacao({@link Callback}) que recebera como parametro o
 *         objeto retornado pelo servico seguindo a documentacao de cada servico.
 *         </p>
 */
public interface BarramentoCNES {

    /**
     * EstabelecimentoSaudeService
     * @param cnes - Codigo de no maximo 7 caractres.
     * @param  callback - Consumer do HashMap, com as chaves definidas
     *                  no {@link EstabelecimentoSaudeService}.
     */
    void consultarEstabelecimento(String cnes, Callback callback);


    /**
     * VinculacaoProfissionalService
     * @param cpf - Numero do CPF do profissional de 11 carateres.
     * @param cns - Numero do CNS do profissional de no maximo 15 caracteres.
     * @param cnes - Codigo de no maximo 7 caractres.
     * @param cnpj - CNPJ do estabelcimento de 14 caracteres.
     * @param tipoVinc - Codigo identificador da vinculacao do profissional com o estabelecimento de no maximo 6 caracteres.
     * @param callback - Consumer do HashMap, com as chaves definidas
     *                  no {@link VinculacaoProfissionalService}.
     */
    void detalharVinculacaoProfissional(String cpf/*, String cns, String cnes, String cnpj, String tipoVinc,*/, Callback callback);
    /**
     * @param cpf - Numero do CPF do profissional de 11 carateres.
     * @param cns - Numero do CNS do profissional de no maximo 15 caracteres.
     * @param cnes - Codigo de no maximo 7 caractres.
     * @param cnpj - CNPJ do estabelcimento de 14 caracteres.
     * @param pagInicial - Posicao inicial do registro na paginacao de no maximo 7.
     * @param qtdRegistrosPag - Quantidade de registros por pagina de no maximo 7.
     * @param qtdTotalRegistros - Quantidade total de registros de no maximo 7.
     * @param callback - Consumer do HashMap, com as chaves definidas
     *                  no {@link VinculacaoProfissionalService}.
     */
    void pesquisarVinculacaoProfissional(String cpf,/*, String cns, String cnes, String cnpj, int pagInicial, int qtdRegistrosPag, int qtdTotalRegistros,*/ Callback callback);
    /**
     * Declaracao para metodo de consulta dados de estabelecimento
     * @param numeroCnes - Numero do CNES para o estabelecimento (7 digitos)
     * @param retorno - Consumer do HashMap com as as chaves definidas em {@link CnesService}
     * */
    void consultarEstabelecimentoSaude(String numeroCnes, Callback retorno);
    /**
     * Declaracao para metodo de consulta dados do estabelecimento por municipio
     * @param codigoIbge - Codigo IBGE do municipio que sera consultado
     * @param retorno - Consumer do HashMap com as chaves definidas em {@link CnesService}
     * */
    void consultarEstabelecimentoSaudePorMunicipio(String codigoIbge, Callback retorno);
    /**
     * @param codigoIbge - Codigo IBGE do municipio que sera consultado
     * @param retorno - Consumer do HashMap com as chaves definidas em {@link CnesService}
     * */
    void consultarDadosComplementaresEstabelecimentoSaude(String codigoIbge, Callback retorno);
    
    
    /**
     * Declaracao para o metodo de consulta dos dados de um profissional da saude cadastrado
     * @param numeroCns - Numero do CNS do profissional de no maximo 15 caracteres.
     * @param dataAtribuicao
     * @param tipoCartao
     * @param manual
     * @param justificativa manual
     * @param numeroCPF
     * @param retorno - Consumer do HashMap com as chaves definidas em {@link CnesService}
     */
    void consultarProfissionalSaude(String numeroCns, Callback retorno);
    
    /**
     * Declaracao para o metodo de consulta dos dados de varios profissionais da saude cadastrado
     * @param numeroCnes - Numero do CNES para o estabelecimento (texto Max: 7 caracteres)
     * @param numeroCNPJ - Numero do CNPJ do establecimento (texto Max: 14 caracteres)
     * @param retorno - Consumer do HashMap com as chaves definidas em {@link CnesService}
     */
    void consultarProfissionaisSaude(String numeroCnes, Callback retorno);
}