package com.github.integracao2017.cnes.cnesinterface;

import java.util.function.Consumer;

import com.github.integracao2017.cnes.implementacao.CNES;
import com.github.integracao2017.cnes.implementacao.ConexaoCNES;

/**
 * @author gabriel Prover interface entre a classe que faz o parse de XML
 *         {@link CNES} com a classe que realiza o request ao servidor
 *         {@link ConexaoCNES}.
 */
public interface Conexao {

    /**
     * @param url
     *            - URL do serviço.
     * @param content
     *            - Corpo da requisição.
     * @param consumer
     *            - Consumer que tratara a resposta em caso de sucesso.
     */
    void requisicao(String url, String content,
            final Consumer<String> consumer);
}
