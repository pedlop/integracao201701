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
     * @param cnes - Codigo de no maximo 7 caractres.
     * @param  callback - Consumer do HashMap, com as chaves definidas
     *                  no {@link EstabelecimentoSaudeService}.
     */
    void consultarEstabelecimento(String cnes, Callback callback);
}
