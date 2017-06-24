package com.github.integracao2017.cnes.cnesinterface;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

public class FabricaCNESTest {

    @Test
    public void testCnes() throws Exception {
        Object o = FabricaCNES.cnes(
                "com.github.integracao2017.cnes.cnesinterface.FabricaCNESTest$BarramentoCNESTeste",
                "com.github.integracao2017.cnes.cnesinterface.FabricaCNESTest$ConexaoTeste",
                null);
        if (!(o instanceof BarramentoCNES))
            fail();
    }

    static class BarramentoCNESTeste implements BarramentoCNES {

        @Override
        public void setConexao(Conexao c) {
            // TODO Auto-generated method stub

        }

        @Override
        public void configuraURL(Map<String, String> urls)
                throws IllegalArgumentException {
            // TODO Auto-generated method stub

        }
        
        @Override
        public void consultarEquipamentoCod(String cnes,
                Callback callback) {
            // TODO Auto-generated method stub

        }
        
        @Override
        public void consultarEstabelecimentoCod(String cnes,
                Callback callback) {
            // TODO Auto-generated method stub

        }

        @Override
        public void consultarEstabelecimentoCnpj(String cnpj,
                Callback callback) {
            // TODO Auto-generated method stub

        }

        @Override
        public void detalharVinculacaoProfissional(String cpf,
                Callback callback) {
            // TODO Auto-generated method stub

        }

        @Override
        public void pesquisarVinculacaoProfissional(String cpf,
                Callback callback) {
            // TODO Auto-generated method stub

        }

        @Override
        public void consultarEstabelecimentoSaude(String numeroCnes,
                Callback retorno) {
            // TODO Auto-generated method stub

        }

        @Override
        public void consultarEstabelecimentoSaudePorMunicipio(String codigoIbge,
                Callback retorno) {
            // TODO Auto-generated method stub

        }

        @Override
        public void consultarDadosComplementaresEstabelecimentoSaude(
                String codigoIbge, Callback retorno) {
            // TODO Auto-generated method stub

        }

        @Override
        public void consultarProfissionalSaude(String numeroCns,
                Callback retorno) {
            // TODO Auto-generated method stub

        }

        @Override
        public void consultarProfissionaisSaude(String numeroCnes,
                Callback retorno) {
            // TODO Auto-generated method stub

        }

        @Override
        public void consultarPreCadastroCNESCod(String cnes,
                Callback callback) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void consultarPreCadastroCNESSituacao(String situacao,
                Callback callback) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void localizarEstabelecimentoSaudeLocalizacao(String longitude,
                String latitude, String geoJson, String codigo,
                String descricao, Callback callback) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void localizarEstabelecimentoSaudePaginacao(String longitude,
                String latitude, String geoJson, String codigo,
                String descricao, String posRegistroInicio,
                String qtdRegistroPagina, String qtdRegistros,
                Callback callback) {
            // TODO Auto-generated method stub
            
        }

    }

    static class ConexaoTeste implements Conexao {

        @Override
        public void requisicao(String url, String content,
                Consumer<String> consumer) {
            // TODO Auto-generated method stub

        }

    }
}
