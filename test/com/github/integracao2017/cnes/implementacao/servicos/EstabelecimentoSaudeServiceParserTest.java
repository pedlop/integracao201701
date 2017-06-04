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
import com.github.integracao2017.cnes.cnesinterface.retorno.Retorno;
import com.github.integracao2017.cnes.cnesinterface.retorno.RetornoColecao;
import com.github.integracao2017.cnes.cnesinterface.retorno.RetornoString;
import com.github.integracao2017.cnes.cnesinterface.retorno.Telefone;
import com.sun.org.apache.bcel.internal.util.ClassLoader;


/**
 * @author gabriel
 * @version 1.0.0
 * Classe de teste do parser do servico de consulta
 * de estabelecimento.
 */
public class EstabelecimentoSaudeServiceParserTest {

    @Test
    public void accept() throws Exception {
        StringBuilder strBuild = new StringBuilder();
        Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("estabelecimento_saude_service.xml").toURI())
        ).stream().forEach(strBuild::append);
        Callback callback = (Map<String, Retorno> m) -> {
        	testRetStrgn(m, EstabelecimentoSaudeService.CODIGO_CNES, "2530031");
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.CODIGO_UNIDADE, "2102002530031");
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.NOME_FANTASIA, "HOSPITAL ADROALDO ALVES MATOS");
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.NOME_EMPRESARIAL, "PREFEITURA MUNICIPAL DE BOM JARDIM");
        	
        	testNulo(m, EstabelecimentoSaudeService.CNPJ);
        	
        	testNulo(m, EstabelecimentoSaudeService.INDENTIFICADOR);
        	
        	testNulo(m, EstabelecimentoSaudeService.TIPO_ENDERECO);
        	
        	testNulo(m, EstabelecimentoSaudeService.COD_TIPO_LORGADOURO);
        	
        	testNulo(m, EstabelecimentoSaudeService.DESC_TIPO_LORGADOURO);
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.NOME_LORGADOURO, "AV JOSE PEDRO VASCONCELOS");
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.NUM_ENDERECO, "S/N");
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.CMPLMT_ENDERECO, "BR 316");
        	
        	testNulo(m, EstabelecimentoSaudeService.COD_BAIRRO);
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.DESC_BAIRRO, "CENTRO");
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.NUM_CEP, "65380000");
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.COD_MUNICIPIO, "210200");
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.NOME_MUNICIPIO, "BOM JARDIM");
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.COD_UF, "21");
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.SIGLA_UF, "MA");
        	
        	testNulo(m, EstabelecimentoSaudeService.COD_REGIAO);
        	
        	testNulo(m, EstabelecimentoSaudeService.NOME_UF);
        	
        	testNulo(m, EstabelecimentoSaudeService.COD_PAIS);
        	
        	testNulo(m, EstabelecimentoSaudeService.COD_PAIS_ANT);
        	
        	testNulo(m, EstabelecimentoSaudeService.NOME_PAIS);
        	
        	testNulo(m, EstabelecimentoSaudeService.MUNICIPIO_INTERN);
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.DATA_ATUALIZACAO, "2015-12-16");
        	
        	testNulo(m, EstabelecimentoSaudeService.DIRT_CPF);
        	
        	testNulo(m, EstabelecimentoSaudeService.DIRT_NOME);
        	
        	testNulo(m, EstabelecimentoSaudeService.TIP_UN_COD);
        	
        	testNulo(m, EstabelecimentoSaudeService.TIP_UN_DESC);
        	
        	testNulo(m, EstabelecimentoSaudeService.ESF_ADM_COD);
        	
        	testNulo(m, EstabelecimentoSaudeService.ESF_ADM_DESC);
        	
        	testNulo(m, EstabelecimentoSaudeService.MN_GEST_COD_MUNI);
        	
        	testNulo(m, EstabelecimentoSaudeService.MN_GEST_NOME_MUNI);
        	
        	testNulo(m, EstabelecimentoSaudeService.MN_GEST_COD_UF);
        	
        	testNulo(m, EstabelecimentoSaudeService.MN_GEST_SIGLA_UF);
        	
        	testNulo(m, EstabelecimentoSaudeService.MN_GEST_COD_REG);
        	
        	testNulo(m, EstabelecimentoSaudeService.MN_GEST_NOME_UF);
        	
        	RetornoColecao telefones =  (RetornoColecao) m.get(EstabelecimentoSaudeService.TELEFONES.getChave());
        	List<Telefone> listaTel = (List<Telefone>) telefones.getColecao();
        	
        	if (!(listaTel.size() == 2))
        		fail();
        	
        	Telefone tel1 = listaTel.get(0);
        	
        	if (!(tel1.getCodTipoTelefone().equals("2")))
        		fail();
        	
        	if (!(tel1.getDescTipoTelefone().equals("COMERCIAL")))
        		fail();
        	
        	if (!(tel1.getDdiTelefone() == null))
        		fail();
        	
        	if (!(tel1.getDdTelefone().equals("98")))
        		fail();
        	
        	if (!(tel1.getNumTelefone().equals("36642130")))
        		fail();
        	
            Telefone tel2 = listaTel.get(1);
        	
        	if (!(tel2.getCodTipoTelefone().equals("4")))
        		fail();
        	
        	if (!(tel2.getDescTipoTelefone().equals("FAX")))
        		fail();
        	
        	if (!(tel2.getDdiTelefone() == null))
        		fail();
        	
        	if (!(tel2.getDdTelefone().equals("98")))
        		fail();
        	
        	if (!(tel2.getNumTelefone().equals("36642130")))
        		fail();
        	
        	testNulo(m, EstabelecimentoSaudeService.EMAIL_INDENTF);
        	
        	testNulo(m, EstabelecimentoSaudeService.EMAIL_DESC);
        	
        	testNulo(m, EstabelecimentoSaudeService.EMAIL_TIPO);
        	
        	testNulo(m, EstabelecimentoSaudeService.EMAIL_VALID);
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.LONGINTUDE, "-45.99400");
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.LATITUDE, "-3.56500");
        	
        	testRetStrgn(m, EstabelecimentoSaudeService.GEO_JSON, "{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\",\"coordinates\":[\"-45.99400\",\"-3.56500\"]}}");
        	
        	
        };
        Consumer<String> c = new EstabelecimentoSaudeServiceParser(callback);
        c.accept(strBuild.toString());
        assert(true);
    }
    
    private void testNulo(Map<String, Retorno> m, EstabelecimentoSaudeService eNum) {
    	if (!(m.get(eNum) == null)) {
    		fail();
    	}
    }
    
    private void testRetStrgn(Map<String, Retorno> m, EstabelecimentoSaudeService eNum, String conteudo) {
    	if (!this.getRetorno(m, eNum).getRetorno().replaceAll(" ", "").equals(conteudo.replaceAll(" ", ""))) {
    		fail();
    	}
    }
    
    private RetornoString getRetorno(Map<String, Retorno> m, EstabelecimentoSaudeService eNum) {
    	return ((RetornoString) m.get(eNum.getChave()));
    }
}