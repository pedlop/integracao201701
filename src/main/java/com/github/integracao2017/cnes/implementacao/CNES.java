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

    public void detalharVinculacaoProfissional(String cpf, Callback callback) {
        // TODO implementar método
    }

    public void pesquisarVinculacaoProfissional(String cpf, Callback callback) {
        // TODO implementar método 
    }
    @Override
    public void consultarEstabelecimentoSaude(String numeroCnes, Callback retorno) {
        // TODO implementar método
    }

    @Override
    public void consultarEstabelecimentoSaudePorMunicipio(String codigoIbge, Callback retorno) {
        // TODO implementar método
    }

    @Override
    public void consultarDadosComplementaresEstabelecimentoSaude(String codigoIbge, Callback retorno) {
        // TODO implementar método
    }
}
