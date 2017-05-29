package com.github.integracao2017.cnes.implementacao;

import com.github.integracao2017.cnes.cnesinterface.BarramentoCNES;
import com.github.integracao2017.cnes.cnesinterface.Callback;

import com.github.integracao2017.cnes.implementacao.servicos.EstabelecimentoSaudeServiceParser;

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
        if (cnes == null || cnes.length() != 7) {
            throw new ParametroError("Código CNES utilizado para consulta" +
                    "; TIPO: Texto; TAM: 7.");
        }
        /**Tratamento do xml para retornar o map.*/
        conexao.consultarEstabelecimento(cnes, new EstabelecimentoSaudeServiceParser(c));
    }
}
