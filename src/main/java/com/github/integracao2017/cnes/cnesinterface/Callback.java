package com.github.integracao2017.cnes.cnesinterface;

import com.github.integracao2017.cnes.cnesinterface.retorno.Retorno;

import java.util.Map;

/**
 * @author gabriel
 *         <p>
 *         Interface Callback como a implementação de todas as requisições feitas pelo serviço funcionam de
 *         maneria assíncrona, deve-se passar uma implementação implementação desta interface para
 *         “escutar” a resposta do servidor, desta maneira a equipe visa a performasse da aplicação de usuário
 *         onde o mesmo não precisa fazer com que o aplicativo pare para esperar a resposta do servidor,
 *         fazer diversas requisições sem ter de esperar que cada uma termine e esta implementação também
 *         facilita estratégia de busca de dados onde ter uma thread rodando de forma paralela ao fluxo de
 *         execução principal da aplicação cliente e de fácil implementação.
 *         </p>
 */
public interface Callback {
    void funcao(Map<String, Retorno> retorno);
}
