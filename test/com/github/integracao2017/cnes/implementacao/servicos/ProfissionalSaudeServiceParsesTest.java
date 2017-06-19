package com.github.integracao2017.cnes.implementacao.servicos;

import static org.junit.Assert.fail;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.EstabelecimentoSaudeService;
import com.github.integracao2017.cnes.cnesinterface.ProfissionalSaudeService;
import com.github.integracao2017.cnes.cnesinterface.retorno.Retorno;
import com.github.integracao2017.cnes.cnesinterface.retorno.RetornoColecao;
import com.github.integracao2017.cnes.cnesinterface.retorno.Telefone;

/**
 * @author João Henrique
 * @version 1.0.0
 * Classe de teste do parser do servico de consulta das informacoes 
 * de um profissional da saúde.
 */
public class ProfissionalSaudeServiceParseTest extends ServiceParserTest {

    @SuppressWarnings("unchecked")
    @Test
    public void accept() throws Exception {
        StringBuilder strBuild = new StringBuilder();
        Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("profissional_saude_service.xml").toURI())
        ).stream().forEach(strBuild::append);
        Callback callback = (Map<String, Retorno> m) -> {
        	testNulo(m, ProfissionalSaudeService.PROF_DATA_ATUALIZACAO);
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_NOME,"VARCIA MARIA CAMPELO SAMPAIO");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_CNS_NUM,"980016280595043");
        	
        	testNulo(m, ProfissionalSaudeService.PROF_CNS_DATA_ATRIB);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_CNS_TIPO_CARTAO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_CNS_MANUAL);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_CNS_JUST_MANUAL);
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_CPF,"02034935322");
        	
        	testNulo(m, ProfissionalSaudeService.PROF_COD_CBO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_DESC_CBO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_CNES_COD);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_NOME_FANTASIA);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_COD_IDENTIFICADOR_EMAIL);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_DESC_EMAIL);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_TIPO_EMAIL);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_EMAIL_VALIDADO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_IDENTIF_ENDERECO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_TIPO_ENDERECO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_COD_TIPO_LOGRADOURO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_DESC_TIPO_LOGRADOURO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_NOME_LOGRADOURO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_NUM_LOGRADOURO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_COMPLEMENTO_LOGRADOURO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_CODIGO_BAIRRO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_DESC_BAIRRO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_COD_CEP);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_COD_MUNICIPIO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_NOME_MUNICIPIO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_COD_UF);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_SIGLA_UF);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_COD_REGIAO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_NOME_UF);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_COD_PAIS);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_COD_PAIS_ANTIGO);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_NOME_PAIS);
        	
        	testNulo(m, ProfissionalSaudeService.PROF_MUNICIPIO_INTERNACIONAL);
        };
        Consumer<String> c = new EstabelecimentoSaudeServiceParser(callback);
        c.accept(strBuild.toString());
        assert(true);
    }
}