package com.github.integracao2017.cnes.implementacao.servicos;

import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Test;

import com.github.integracao2017.cnes.cnesinterface.EstabelecimentoSaudeService;
import com.github.integracao2017.cnes.cnesinterface.retorno.Retorno;
import com.github.integracao2017.cnes.cnesinterface.retorno.RetornoString;

/**
 * @author gabriel
 * @version 1.0.0
 * 
 *          Classe com implementações para auxilio na escrita de casos de teste
 *          para os algoritmos de teste.
 * 
 */
public abstract class ServiceParserTest {

    /**
     * Método que devera ser sobrescrito para efetivamente implementar as
     * verificações, callback que e chamado assim que o XML chega ao servidor.
     */
    @Test
    public abstract void accept() throws Exception;

    /**
     * @param m
     *            - Mapa que gerado pelo algoritmo de parse.
     * @param eNum
     *            - Enum com as chaves de cada TAG no Map.
     * 
     *            Teste para tags que não existam no XML de resposta ou XML de
     *            teste, e que por não estarem presentes no seu valor no Map
     *            devera ser null.
     */
    protected void testNulo(Map<String, Retorno> m,
            EstabelecimentoSaudeService eNum) {
        if (!(m.get(eNum) == null)) {
            fail();
        }
    }

    /**
     * @param m
     *            - Mapa que gerado pelo algoritmo de parse.
     * @param conteudo
     *            - Valor que a TAG deveria retornar. Teste para tags que
     *            retornam valor.
     */
    protected void testRetStrgn(Map<String, Retorno> m,
            EstabelecimentoSaudeService eNum, String conteudo) {
        if (!this.getRetorno(m, eNum).getRetorno().replaceAll(" ", "")
                .equals(conteudo.replaceAll(" ", ""))) {
            fail();
        }
    }

    /**
     * @param m
     *            - Mapa que gerado pelo algoritmo de parse.
     * @param eNum
     *            - Enum com as chaves de cada TAG no Map.
     * 
     * @return - {@link RetornoString} String encapsulada no padrão de retorno
     *         da API.
     */
    protected RetornoString getRetorno(Map<String, Retorno> m,
            EstabelecimentoSaudeService eNum) {
        return ((RetornoString) m.get(eNum.getChave()));
    }
}
