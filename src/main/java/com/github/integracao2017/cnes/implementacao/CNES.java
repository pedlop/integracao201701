package com.github.integracao2017.cnes.implementacao;

import com.github.integracao2017.cnes.cnesinterface.BarramentoCNES;
import com.github.integracao2017.cnes.cnesinterface.Callback;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by gabriel on 08/05/17.
 */
public class CNES implements BarramentoCNES {

    private Conexao conexao;

    private void setConexao(Conexao c) {
        conexao = c;
    }

    @Override
    public void consultarEstabelecimento(String cnes, Callback c) {
        /**Tratamento do xml para retornar o map.*/
        Map<String, String> mapa = new HashMap<>();
        Consumer<String> trataXml = (String s) -> {
            mapa.put("TESTE","CONTEUDO TESTE");
            c.funcao(mapa);
        };
        conexao.consultarEstabelecimento(cnes, trataXml);

    }
}
