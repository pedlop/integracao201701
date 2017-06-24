package com.github.integracao2017.cnes.implementacao.servicos;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.VinculacaoProfissionalService;
import com.github.integracao2017.cnes.cnesinterface.retorno.Retorno;


/**
 * @author pedro.lopes
 * @version 1.0.0
 * Classe de teste do parser do servico de consulta
 * de vinculacao profissional.
 */
public class VinculacaoProfissionalServiceParserTest extends ServiceParserTest {

    @Test
    public void accept() throws Exception {
        StringBuilder strBuild = new StringBuilder();
        Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("vinculacao_profissional_service.xml").toURI())
        ).stream().forEach(strBuild::append);
        Callback callback = (Map<String, Retorno> m) -> {
        	testRetStrgn(m, VinculacaoProfissionalService.PROF_NOME, "JOSE MARIA DA SILVA"); 	
        	testRetStrgn(m, VinculacaoProfissionalService.PROF_CPF, "65311064250");
        	testRetStrgn(m, VinculacaoProfissionalService.PROF_CNS_NUM, "007");
        	testRetStrgn(m, VinculacaoProfissionalService.PROF_CNS_DATA_ATRIB, "12-12-2012");	
        	testRetStrgn(m, VinculacaoProfissionalService.PROF_CNS_TIPO_CARTAO, "D");
        	testRetStrgn(m, VinculacaoProfissionalService.PROF_CNS_MANUAL, "TRUE");
        	testRetStrgn(m, VinculacaoProfissionalService.PROF_CNS_JUST_MANUAL, "O CARTAO FOI ADICIONADO DEVIDO A SOLICITACAO DO CHEFE");
        	testRetStrgn(m, VinculacaoProfissionalService.CODIGO_CNES, "2530031");        	
        	testRetStrgn(m, VinculacaoProfissionalService.NOME_FANTASIA, "HOSPITAL DE URGENCIAS DA VILA AMERICA");        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULACAO_IND, "010300");        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULO_COD_MOD, "1981");        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULO_COD_MOD_DESC, "PESSOAL RESPONSAVEL PELO ATENDIMENTO 1");        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULO_COD_MOD_TIPO, "2001");        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULO_COD_MOD_TIPO_DESC, "VINCULO A PARTIR DO SECULO ATUAL");        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULO_COD_MOD_SUB_TIPO, "2011");        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULO_COD_MOD_SUB_TIPO_DESC, "REALIZADA ATUALIZACAO DO PROFISSIONAL");        	
        	testRetStrgn(m, VinculacaoProfissionalService.CBO_COD, "7471");        	
        	testRetStrgn(m, VinculacaoProfissionalService.CBO_DESC, "UTIL PARA DETERMINADO CASO");        	
        	testRetStrgn(m, VinculacaoProfissionalService.QTD_CARGA_HR_AMBULATORIAL, "20");        	
        	testRetStrgn(m, VinculacaoProfissionalService.QTD_CARGA_HR_OUTROS, "10");        	
        	testRetStrgn(m, VinculacaoProfissionalService.QTD_CARGA_HR_HOSP_SUS, "15");        	
        	testRetStrgn(m, VinculacaoProfissionalService.COMPT_INICIO, "30-03-2012");        	
        	testRetStrgn(m, VinculacaoProfissionalService.COMPT_FIM, "07-04-2016");
        	testRetStrgn(m, VinculacaoProfissionalService.PAG_POS_INICIAL_REGISTRO, "1");
        	testRetStrgn(m, VinculacaoProfissionalService.PAG_QTD_REGISTROS, "100");
        	testRetStrgn(m, VinculacaoProfissionalService.PAG_TOTAL_REGISTROS, "100");
        };
        Consumer<String> c = new VinculacaoProfissionalServiceParser(callback);
        c.accept(strBuild.toString());
        assert(true);
    }
}