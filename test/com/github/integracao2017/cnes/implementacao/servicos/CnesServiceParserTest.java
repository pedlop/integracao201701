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
import com.github.integracao2017.cnes.cnesinterface.retorno.Telefone;



/**
 * @author Rony Nogueira
 * @version 1.0.0
 * Classe de teste do parser CnesService
 */
public class CnesServiceParserTest extends ServiceParserTest {

    @SuppressWarnings("unchecked")
    @Test
    public void accept() throws Exception {
        StringBuilder strBuild = new StringBuilder();
        Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("consultar_estabelecimento_saude.xml").toURI())
        ).stream().forEach(strBuild::append);
        Callback callback = (Map<String, Retorno> m) -> {

            testRetStrgn(m, CnesService.CODIGO_CNES, "2530031");
            testRetStrgn(m, CnesService.CODIGO_UNIDADE, "2102002530031");

            testRetStrgn(m, CnesService.NOME_FANTASIA, "HOSPITAL ADROALDO ALVES MATOS");
            testRetStrgn(m, CnesService.ENDERECO_LOGRADOURO, "AV JOSE PEDRO VASCONCELOS");
            testRetStrgn(m, CnesService.ENDERECO_NUMERO, "S/N");
            testRetStrgn(m, CnesService.ENDERECO_COMPLEMENTO, "BR 316");
            testRetStrgn(m, CnesService.ENDERECO_BAIRRO, "CENTRO");
            testRetStrgn(m, CnesService.ENDERECO_CEP, "65380000");
            testRetStrgn(m, CnesService.ENDERECO_CODIGO_MUNICIPIO, "210200");
            testRetStrgn(m, CnesService.ENDERECO_NOME_MUNICIPIO, "BOM JARDIM");
            testRetStrgn(m, CnesService.ENDERECO_CODIGO_UF, "21");
            testRetStrgn(m, CnesService.ENDERECO_SIGLA_UF, "MA");
            testRetStrgn(m, CnesService.ENDERECO_DATA_ATUALIZACAO, "2017-06-01");

            testRetStrgn(m, CnesService.DIRETOR_CPF, "33525820330");
            testRetStrgn(m, CnesService.DIRETOR_NOME, "JOSE CARIOLANDO MOTA DE MATOS");

            testRetStrgn(m, CnesService.UNIDADE_CODIGO, "05");
            testRetStrgn(m, CnesService.UNIDADE_DESCRICAO, "HOSPITAL GERAL");

            testRetStrgn(m, CnesService.SUMARIO_QTD_PROFISSIONAIS_SAUDE, "66");
            testRetStrgn(m, CnesService.SUMARIO_QTD_CBOS, "68");
            testRetStrgn(m, CnesService.SUMARIO_QTD_LEITOS, "5");
            testRetStrgn(m, CnesService.SUMARIO_QTD_HABILITACOES, "0");
            testRetStrgn(m, CnesService.SUMARIO_QTD_EQUIPAMENTOS, "5");
            testRetStrgn(m, CnesService.SUMARIO_QTD_SAMU, "0");

        };
        Consumer<String> c = new CnesServiceParser(callback);
        c.accept(strBuild.toString());
        assert(true);
    }
}