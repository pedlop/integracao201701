package com.github.integracao2017.cnes.implementacao.servicos;


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
            testRetStrgn(m, EstabelecimentoSaudeService.CODIGO_EQUIPAMENTO, "2522");
            testRetStrgn(m, EstabelecimentoSaudeService.DESCRICAO_EQUIPAMENTO, "TESTE 1");
            testRetStrgn(m, EstabelecimentoSaudeService.CODIGO_TIPOEQUIPAMENTO, "52");
            testRetStrgn(m, EstabelecimentoSaudeService.DESCRICAO_TIPOEQUIPAMENTO, "TESTE");
            testRetStrgn(m, EstabelecimentoSaudeService.DESTINACAO_EQUIPAMENTO, "AMBOS");
            testRetStrgn(m, EstabelecimentoSaudeService.QUANTIDADE_EQUIPAMENTO, "10");
            testRetStrgn(m, EstabelecimentoSaudeService.QUANTIDADEUSO_EQUIPAMENTO, "25");
            testRetStrgn(m, EstabelecimentoSaudeService.DISPONIBILIDADESUS_EQUIPAMENTO, "100");
        };
        Consumer<String> c = new EquipamentoService(callback);
        c.accept(strBuild.toString());
        assert(true);
    }

}