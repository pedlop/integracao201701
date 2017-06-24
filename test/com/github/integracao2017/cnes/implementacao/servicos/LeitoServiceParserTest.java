package com.github.integracao2017.cnes.implementacao.servicos;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.LeitoService;
import com.github.integracao2017.cnes.cnesinterface.retorno.Retorno;

/**
 * @author lucas
 * @version 1.0.0
 * Classe de teste do parser do servico de consulta
 * de equipamento.
 */
public class LeitoServiceParserTest extends ServiceParserTest {

    @Test
    public void accept() throws Exception {
        StringBuilder strBuild = new StringBuilder();
        Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("leito_service.xml").toURI())
        ).stream().forEach(strBuild::append);
        Callback callback = (Map<String, Retorno> m) -> {
            testRetStrgn(m, LeitoService.CODIGO, "123");
            testRetStrgn(m, LeitoService.DESCRICAO, "So mais um leito");
            testRetStrgn(m, LeitoService.DATA_ATUALIZACAO, "2015-12-16");
            testRetStrgn(m, LeitoService.QUANTIDADE_LEITO, "10");
            testRetStrgn(m, LeitoService.QUANTIDADE_LEITO_SUS, "15");
        };
        Consumer<String> c = new EquipamentoServiceParser(callback);
        c.accept(strBuild.toString());
        assert(true);
    }

}