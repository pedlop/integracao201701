package com.github.integracao2017.cnes.implementacao.servicos;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.EquipamentoService;
import com.github.integracao2017.cnes.cnesinterface.EstabelecimentoSaudeService;
import com.github.integracao2017.cnes.cnesinterface.retorno.Retorno;

/**
 * @author gabriel
 * @version 1.0.0
 * Classe de teste do parser do servico de consulta
 * de estabelecimento.
 */
public class EquipamentoServiceParserTest extends ServiceParserTest {

    @Test
    public void accept() throws Exception {
        StringBuilder strBuild = new StringBuilder();
        Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("equipamento_service.xml").toURI())
        ).stream().forEach(strBuild::append);
        Callback callback = (Map<String, Retorno> m) -> {
            testRetStrgn(m, EquipamentoService.CODIGO_EQUIPAMENTO, "2522");
            testRetStrgn(m, EquipamentoService.DESCRICAO_EQUIPAMENTO, "TESTE 1");
            testRetStrgn(m, EquipamentoService.CODIGO_TIPOEQUIPAMENTO, "52");
            testRetStrgn(m, EquipamentoService.DESCRICAO_TIPOEQUIPAMENTO, "TESTE");
            testRetStrgn(m, EquipamentoService.DESTINACAO_EQUIPAMENTO, "AMBOS");
            testRetStrgn(m, EquipamentoService.QUANTIDADE_EQUIPAMENTO, "10");
            testRetStrgn(m, EquipamentoService.QUANTIDADEUSO_EQUIPAMENTO, "25");
            testRetStrgn(m, EquipamentoService.DISPONIBILIDADESUS_EQUIPAMENTO, "100");
        };
        Consumer<String> c = new EquipamentoServiceParser(callback);
        c.accept(strBuild.toString());
        assert(true);
    }

}