package com.github.integracao2017.cnes.cnesinterface;

import java.util.HashMap;

/**
 * Created by gabriel on 08/05/17.
 */
public interface BarramentoCNES {

    /**
     * Definicao de todas as operacoes fornecidas pelo
     * Component.
     *
     * */
    void consultarEstabelecimento(String cnes, Callback callback);
}
