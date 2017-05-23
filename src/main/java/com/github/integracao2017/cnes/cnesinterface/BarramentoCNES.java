package com.github.integracao2017.cnes.cnesinterface;

import java.util.HashMap;

/**
 * @author gabriel
 *         <p>
 *         Interface que define todos os serviços.
 *         Barramento que define todos os serviços definidos, no documento do catálogo de serviços porém
 *         com abstração do componenet, a implementação das requisições são feitas de maneira assíncrona.
 *         Ou seja para cada serviço devera ser passado uma implementação({@link Callback}) que recebera como parâmetro o
 *         objeto retornado pelo serviço seguindo a documentação de cada serviço.
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
     * @param cpf - Número do CPF do profissional de 11 carateres.
     * @param cns - Número do CNS do profissional de no máximo 15 caracteres.
     * @param cnes - Código de no máximo 7 caractres.
     * @param cnpj - CNPJ do estabelcimento de 14 caracteres.
     * @param tipoVinc - Código identificador da vinculação do profissional com o estabelecimento de no máximo 6 caracteres.
     * @param callback - Consumer do HashMap, com as chaves definidas
     *                  no {@link VinculacaoProfissionalService}.
     */
    void detalharVinculacaoProfissional(String cpf/*, String cns, String cnes, String cnpj, String tipoVinc,*/ Callback callback);
    /**
     * @param cpf - Número do CPF do profissional de 11 carateres.
     * @param cns - Número do CNS do profissional de no máximo 15 caracteres.
     * @param cnes - Código de no máximo 7 caractres.
     * @param cnpj - CNPJ do estabelcimento de 14 caracteres.
     * @param pagInicial - Posição inicial do registro na paginação de no máximo 7.
     * @param qtdRegistrosPag - Quantidade de registros por página de no máximo 7.
     * @param qtdTotalRegistros - Quantidade total de registros de no máximo 7.
     * @param callback - Consumer do HashMap, com as chaves definidas
     *                  no {@link VinculacaoProfissionalService}.
     */
    void pesquisarVinculacaoProfissional(String cpf/*, String cns, String cnes, String cnpj, int pagInicial, int qtdRegistrosPag, int qtdTotalRegistros,*/ Callback callback);
}