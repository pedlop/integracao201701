package com.github.integracao2017.cnes.implementacao;

import com.github.integracao2017.cnes.cnesinterface.Callback;

import java.util.function.Consumer;

/**
 * Created by gabriel on 08/05/17.
 */
public interface Conexao {

    void consultarEstabelecimento(String cnes, Consumer<String> consumer);
}
