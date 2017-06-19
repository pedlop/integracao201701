package com.github.integracao2017.cnes.implementacao.servicos;

import static org.junit.Assert.fail;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.VinculacaoProfissionalService;
import com.github.integracao2017.cnes.cnesinterface.retorno.Retorno;
import com.github.integracao2017.cnes.cnesinterface.retorno.RetornoColecao;
import com.github.integracao2017.cnes.cnesinterface.retorno.RetornoString;
import com.github.integracao2017.cnes.cnesinterface.retorno.Telefone;
import com.sun.org.apache.bcel.internal.util.ClassLoader;


/**
 * @author pedro.lopes
 * @version 1.0.0
 * Classe de teste do parser do servico de consulta
 * de estabelecimento.
 */
public class VinculacaoProfissionalServiceParserTest {

    @Test
    public void accept() throws Exception {
        StringBuilder strBuild = new StringBuilder();
        Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("vinculacao_profissional_service.xml").toURI())
        ).stream().forEach(strBuild::append);
        Callback callback = (Map<String, Retorno> m) -> {
        	testRetStrgn(m, VinculacaoProfissionalService.PROF_NOME, "");
        	
        	testRetStrgn(m, VinculacaoProfissionalService.PROF_CPF, "");
        	
        	testRetStrgn(m, VinculacaoProfissionalService.PROF_CNS_NUM, "");
        	
        	testRetStrgn(m, VinculacaoProfissionalService.PROF_CNS_DATA_ATRIB, "");
        	
        	testNulo(m, VinculacaoProfissionalService.PROF_CNS_TIPO_CARTAO);
        	
        	testNulo(m, VinculacaoProfissionalService.PROF_CNS_MANUAL);
        	
        	testNulo(m, VinculacaoProfissionalService.PROF_CNS_JUST_MANUAL);
        	
        	testNulo(m, VinculacaoProfissionalService.CODIGO_CNES);
        	
        	testNulo(m, VinculacaoProfissionalService.NOME_FANTASIA);
        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULACAO_IND, "");
        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULO_COD_MOD, "");
        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULO_COD_MOD_DESC, "");
        	
        	testNulo(m, VinculacaoProfissionalService.VINCULO_COD_MOD_TIPO);
        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULO_COD_MOD_TIPO_DESC, "");
        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULO_COD_MOD_SUB_TIPO, "");
        	
        	testRetStrgn(m, VinculacaoProfissionalService.VINCULO_COD_MOD_SUB_TIPO_DESC, "");
        	
        	testRetStrgn(m, VinculacaoProfissionalService.CBO_COD, "");
        	
        	testRetStrgn(m, VinculacaoProfissionalService.CBO_DESC, "");
        	
        	testRetStrgn(m, VinculacaoProfissionalService.QTD_CARGA_HR_AMUBULATOTIAL, "");
        	
        	testNulo(m, VinculacaoProfissionalService.QTD_CARGA_HR_OUTROS);
        	
        	testNulo(m, VinculacaoProfissionalService.QTD_CARGA_HR_HOSP_SUS);
        	
        	testNulo(m, VinculacaoProfissionalService.COMPT_INICIO);
        	
        	testNulo(m, VinculacaoProfissionalService.COMPT_FIM);
        	
        };
        Consumer<String> c = new VinculacaoProfissionalServiceParser(callback);
        c.accept(strBuild.toString());
        assert(true);
    }
    
    private void testNulo(Map<String, Retorno> m, VinculacaoProfissionalService eNum) {
    	if (!(m.get(eNum) == null)) {
    		fail();
    	}
    }
    
    private void testRetStrgn(Map<String, Retorno> m, VinculacaoProfissionalService eNum, String conteudo) {
    	if (!this.getRetorno(m, eNum).getRetorno().replaceAll(" ", "").equals(conteudo.replaceAll(" ", ""))) {
    		fail();
    	}
    }
    
    private RetornoString getRetorno(Map<String, Retorno> m, VinculacaoProfissionalService eNum) {
    	return ((RetornoString) m.get(eNum.getChave()));
    }
}