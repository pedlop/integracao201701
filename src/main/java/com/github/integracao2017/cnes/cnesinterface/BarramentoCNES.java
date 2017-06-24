package com.github.integracao2017.cnes.cnesinterface;

import java.util.Map;

/**
 * @author gabriel
 * @version 1.0.0
 *          <p>
 *          Interface que define todos os servicos. Barramento que define todos
 *          os servicos definidos, no documento do catalogo de servicos porem
 *          com abstracao do componenet, a implementação das requisicoes sao
 *          feitas de maneira assincrona. Ou seja para cada servico devera ser
 *          passado uma implementacao({@link Callback}) que recebera como
 *          parametro o objeto retornado pelo servico seguindo a documentacao de
 *          cada servico.
 *          </p>
 */
public interface BarramentoCNES {

    /**
     * @param c
     *            - Instancia de conexão que tera de fato a impletação concreta
     *            do codigo de fazer a request ao servidor.
     */
    void setConexao(Conexao c);

    /**
     * Configuração das URLs de serviços, sendo que fica definida uma chave
     * única para cada serviço afim de quem esteja usando da fábrica passe a
     * respectivas urls para cada serviço de acordo com a documentação de
     * serviços barramento CNES.
     * 
     * Acesse o cátalogo de serviços em: <a href=
     * "http://datasus.saude.gov.br/interoperabilidade/catalogo-de-servicos">
     * Catálogo de Serviços</a>
     * 
     * <ul>
     * <li>ConsultarEstabelecimentoSaude</li>
     * <li>VinculacaoProfissionalService</li>
     * <li>ProfissionalSaudeService</li>
     * <li>LeitoService</li>
     * <li>EquipamentoService</li>
     * <li>CnesService</li>
     * </ul>
     * 
     * @throws IllegalArgumentException
     *             - Caso alguma chave de url seja passada como nula.
     */
    void configuraURL(Map<String, String> urls) throws IllegalArgumentException;
    
    /**
     * EquipamentoService
     * 
     * @param cnes
     *            - C�digo CNES utilizado para consulta, tamanho 7 s� n�meros.
     * @param callback
     *            - Consumer do HashMap, com as chaves definidas no
     *            {@link EquipamentoService}.
     */
    void consultarEquipamentoCod(String cnes, Callback callback);

    /**
     * EstabelecimentoSaudeService
     * 
     * @param cnes
     *            - Código CNES utilizado para consulta, tamanho 7 só números.
     * @param callback
     *            - Consumer do HashMap, com as chaves definidas no
     *            {@link EstabelecimentoSaudeService}.
     */
    void consultarEstabelecimentoCod(String cnes, Callback callback);

    /**
     * EstabelecimentoSaudeService
     * 
     * @param cnpj
     *            - CNPJ utilizado para consulta, tamanho 15 só números.
     * @param callback
     *            - Consumer do HashMap, com as chaves definidas no
     *            {@link EstabelecimentoSaudeService}.
     */
    void consultarEstabelecimentoCnpj(String cnpj, Callback callback);
    
    
    /**
     * EstabelecimentoSaudeService
     * 
     * @param cnes
     *            - Código CNES utilizado para consulta, tamanho 7 só números.
     * @param callback
     *            - Consumer do HashMap, com as chaves definidas no
     *            {@link EstabelecimentoSaudeService}.
     */
    void consultarPreCadastroCNESCod(String cnes, Callback callback);
    
    
    /** 
     * @param longitude 
     *            - Longitude do estabelecimento. 
     * @param latitude 
     *            - Latitude do estabelecimento. 
     * @param geoJson 
     *            - Geojson do estabelecimento 
     * @param callback 
     *            - Consumer do HashMap, com as chaves definidas no 
     *            {@link EstabelecimentoSaudeService}. 
     */ 
    void localizarEstabelecimentoSaudeLocalizacao(String longitude, String latitude, 
            String geoJson, String codigo, String descricao, Callback callback); 
 
    /** 
     * @param longitude 
     *            - Longitude do estabelecimento. TEXTO 9 
     * @param latitude 
     *            - Latitude utilizada para consulta. TEXTO 9 
     * @param geoJson 
     *            - Geojson do estabelecimento. EX. 
     *            {"type":"Feature","geometry":{"type":"Point","coordinates":["-45.84121","-3.68787"]}} 
     * @param codigo 
     *            - Código do Tipo de Unidade do Estabelecimento de Saúde. TEXTO 
     *            2 só números. 
     * @param descricao 
     *            - Descrição do Tipo de Unidade do Estabelecimento de Saúde. 
     * @param posRegistroInicio 
     *            - Posição de inicio do registro. 
     * @param qtdRegistroPagina 
     *            - Quantidade de registros por página. 
     * @param qtdRegistros 
     *            - Quantidade de registros total da consulta. 
     * @param callback 
     *            - - Consumer do HashMap, com as chaves definidas no 
     *            {@link EstabelecimentoSaudeService}. 
     */ 
    void localizarEstabelecimentoSaudePaginacao(String longitude, 
            String latitude, String geoJson, String codigo, String descricao, 
            String posRegistroInicio, String qtdRegistroPagina, 
            String qtdRegistros, Callback callback); 

    /**
     * EstabelecimentoSaudeService
     * 
     * @param situacao
     *            - Situação do Pré Cadastro: [A=ATIVO,D=DESATIVADO, E=EXCLUIDO]
     *            valores permitidos {A, D ou E}.
     * @param callback
     *            - Consumer do HashMap, com as chaves definidas no
     *            {@link EstabelecimentoSaudeService}.
     */
    void consultarPreCadastroCNESSituacao(String situacao, Callback callback);
    
    /**
     * VinculacaoProfissionalService
     * 
     * @param cpf
     *            - Numero do CPF do profissional de 11 carateres.
     * @param cns
     *            - Numero do CNS do profissional de no maximo 15 caracteres.
     * @param cnes
     *            - Codigo de no maximo 7 caractres.
     * @param cnpj
     *            - CNPJ do estabelcimento de 14 caracteres.
     * @param tipoVinc
     *            - Codigo identificador da vinculacao do profissional com o
     *            estabelecimento de no maximo 6 caracteres.
     * @param callback
     *            - Consumer do HashMap, com as chaves definidas no
     *            {@link VinculacaoProfissionalService}.
     */
    void detalharVinculacaoProfissional(
            String cpf/*
                       * , String cns, String cnes, String cnpj, String
                       * tipoVinc,
                       */, Callback callback);

    /**
     * @param cpf
     *            - Numero do CPF do profissional de 11 carateres.
     * @param cns
     *            - Numero do CNS do profissional de no maximo 15 caracteres.
     * @param cnes
     *            - Codigo de no maximo 7 caractres.
     * @param cnpj
     *            - CNPJ do estabelcimento de 14 caracteres.
     * @param pagInicial
     *            - Posicao inicial do registro na paginacao de no maximo 7.
     * @param qtdRegistrosPag
     *            - Quantidade de registros por pagina de no maximo 7.
     * @param qtdTotalRegistros
     *            - Quantidade total de registros de no maximo 7.
     * @param callback
     *            - Consumer do HashMap, com as chaves definidas no
     *            {@link VinculacaoProfissionalService}.
     */
    void pesquisarVinculacaoProfissional(String cpf,
            /*
             * , String cns, String cnes, String cnpj, int pagInicial, int
             * qtdRegistrosPag, int qtdTotalRegistros,
             */ Callback callback);

    /**
     * Declaracao para metodo de consulta dados de estabelecimento
     * 
     * @param numeroCnes
     *            - Numero do CNES para o estabelecimento (7 digitos)
     * @param retorno
     *            - Consumer do HashMap com as as chaves definidas em
     *            {@link CnesService}
     */
    void consultarEstabelecimentoSaude(String numeroCnes, Callback retorno);

    /**
     * Declaracao para metodo de consulta dados do estabelecimento por municipio
     * 
     * @param codigoIbge
     *            - Codigo IBGE do municipio que sera consultado
     * @param retorno
     *            - Consumer do HashMap com as chaves definidas em
     *            {@link CnesService}
     */
    void consultarEstabelecimentoSaudePorMunicipio(String codigoIbge,
            Callback retorno);

    /**
     * @param codigoIbge
     *            - Codigo IBGE do municipio que sera consultado
     * @param retorno
     *            - Consumer do HashMap com as chaves definidas em
     *            {@link CnesService}
     */
    void consultarDadosComplementaresEstabelecimentoSaude(String codigoIbge,
            Callback retorno);

    /**
     * Declaracao para o metodo de consulta dos dados de um profissional da
     * saude cadastrado
     * 
     * @param numeroCns
     *            - Numero do CNS do profissional de no maximo 15 caracteres.
     * @param dataAtribuicao
     * @param tipoCartao
     * @param manual
     * @param justificativa
     *            manual
     * @param numeroCPF
     * @param retorno
     *            - Consumer do HashMap com as chaves definidas em
     *            {@link CnesService}
     */
    void consultarProfissionalSaude(String numeroCns, Callback retorno);

    /**
     * Declaracao para o metodo de consulta dos dados de varios profissionais da
     * saude cadastrado
     * 
     * @param numeroCnes
     *            - Numero do CNES para o estabelecimento (texto Max: 7
     *            caracteres)
     * @param numeroCNPJ
     *            - Numero do CNPJ do establecimento (texto Max: 14 caracteres)
     * @param retorno
     *            - Consumer do HashMap com as chaves definidas em
     *            {@link CnesService}
     */
    void consultarProfissionaisSaude(String numeroCnes, Callback retorno);
}
