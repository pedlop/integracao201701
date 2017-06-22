package com.github.integracao2017.cnes.cnesinterface;

import java.util.Map;

/**
 * @author gabriel
 *         <p>
 *         Fabrica de objetos CNES. Com esta classe você poderá instanciar o
 *         objeto definidos pela interface {@link BarramentoCNES}.
 *         </p>
 */
public class FabricaCNES {

    /**
     * @param barramentoPath - Caminho completo da impletação
     * concreta da interface {@link BarramentoCNES}.
     * 
     * @param 
     * 
     * 
     * @param urls - Configuração das URLs de serviços, sendo que fica definida uma chave
     * única para cada serviço afim de quem esteja usando da fábrica passe a
     * respectivas urls para cada serviço de acordo com a documentação de
     * serviços barramento CNES.
     * 
     * Acesse o cátalogo de serviços em: <a href=
     * "http://datasus.saude.gov.br/interoperabilidade/catalogo-de-servicos">
     * Catálogo de Serviços</a>
     * 
     * <ul>
     * <li>ConsultarEstabelecimentoSaude</li>
     * <li>VinculacaoProfissionalService</li>
     * <li>ProfissionalSaudeService</li>
     * <li>LeitoService</li>
     * <li>EquipamentoService</li>
     * <li>CnesService</li>
     * </ul>
     * @throws InstantiationException - {@link InstantiationException}
     * @throws IllegalAccessException - {@link IllegalAccessException}
     * @throws ClassNotFoundException - {@link ClassNotFoundException}.
     * @return Instancia de BarramentoCNES com todos os serviços.
     */
    public static BarramentoCNES cnes(String barramentoPath, String conexaoPath,
            Map<String, String> urls) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        BarramentoCNES barramento = (BarramentoCNES) Class.forName(barramentoPath)
                .newInstance();
        Conexao conexao = (Conexao) Class.forName(conexaoPath).newInstance();
        barramento.setConexao(conexao);
        barramento.configuraURL(urls);
        return barramento;
    }
}
