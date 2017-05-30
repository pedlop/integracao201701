package com.github.integracao2017.cnes.implementacao.servicos;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.retorno.Retorno;
import com.github.integracao2017.cnes.implementacao.servicos.EstabelecimentoSaudeServiceParser;
import com.sun.org.apache.bcel.internal.util.ClassLoader;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Consumer;


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
        Callback callback = (Map<String, Retorno> m) -> {};
        Consumer<String> c = new EstabelecimentoSaudeServiceParser(callback);
        c.accept(strBuild.toString());
        assert(true);
    }
}