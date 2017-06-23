package com.github.integracao2017.cnes.implementacao.servicos;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.ProfissionalSaudeService;
import com.github.integracao2017.cnes.cnesinterface.retorno.Retorno;

/**
 * @author JoAo Henrique
 * @version 1.0.0
 * Classe de teste do parser do servico de consulta das informacoes 
 * de um profissional da saUde.
 */
public class ProfissionalSaudeServiceParseTest extends ServiceParserTest {

    
    @Test
    public void accept() throws Exception {
        StringBuilder strBuild = new StringBuilder();
        Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("profissional_saude_service.xml").toURI())
        ).stream().forEach(strBuild::append);
        Callback callback = (Map<String, Retorno> m) -> {
        	testRetStrgn(m, ProfissionalSaudeService.PROF_DATA_ATUALIZACAO,"2008-05-26");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_NOME,"VARCIA MARIA CAMPELO SAMPAIO");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_CNS_NUM,"980016280595043");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_CNS_DATA_ATRIB,"2017-01-01");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_CNS_TIPO_CARTAO,"D");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_CNS_MANUAL,"TRUE");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_CNS_JUST_MANUAL,"TESTE JUSTIFICATIVA");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_CPF,"02034935322");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_COD_CBO,"123456");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_DESC_CBO,"TESTE CBO");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_CNES_COD,"1234567");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_NOME_FANTASIA,"TESTE NOME FANTASIA");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_COD_IDENTIFICADOR_EMAIL,"1");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_DESC_EMAIL,"EMAIL EMAIL");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_TIPO_EMAIL,"A");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_EMAIL_VALIDADO,"FALSE");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_IDENTIF_ENDERECO,"1");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_TIPO_ENDERECO,"B");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_COD_TIPO_LOGRADOURO,"12");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_DESC_TIPO_LOGRADOURO,"DESCRICAO LOGRADOURO");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_NOME_LOGRADOURO,"NOME LOGRADOURO");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_NUM_LOGRADOURO,"TESTE NUM");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_COMPLEMENTO_LOGRADOURO,"TESTE COMPLEMENTO");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_CODIGO_BAIRRO,"4545");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_DESC_BAIRRO,"DESCRICAO BAIRRO");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_COD_CEP,"74343221");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_COD_MUNICIPIO,"1234");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_NOME_MUNICIPIO,"TESTE NOME");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_COD_UF,"GO");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_SIGLA_UF,"GO");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_COD_REGIAO,"GOGO");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_NOME_UF,"GOIAS");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_COD_PAIS,"123");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_COD_PAIS_ANTIGO,"321");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_NOME_PAIS,"BRASIL");
        	
        	testRetStrgn(m, ProfissionalSaudeService.PROF_MUNICIPIO_INTERNACIONAL,"BRASIL");
        };
        Consumer<String> c = new ProfissionalSaudeServiceParser(callback);
        c.accept(strBuild.toString());
        assert(true);
    }
}