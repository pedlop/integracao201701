package com.github.integracao2017.cnes.implementacao;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.Conexao;
import com.github.integracao2017.cnes.cnesinterface.retorno.Retorno;

public class CNESTest {
    
    private CNES cnes;
    
    private Callback callback;
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetConexao() {
        cnes = new CNES();
        cnes.setConexao(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConfiguraURLNull() {
        cnes = new CNES();
        cnes.configuraURL(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConfiguraURLVazia() {
        cnes = new CNES();
        Map<String, String> map = new HashMap<>();
        cnes.configuraURL(map);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConfiguraURL1Nulo() {
        cnes = new CNES();
        Map<String, String> map = new HashMap<>();
        map.put("ok", "ok");
        map.put("ok2", null);
        cnes.configuraURL(map);
    }
    
    @Test
    public void testConfiguraURL() {
        cnes = new CNES();
        Map<String, String> map = new HashMap<>();
        map.put("ok", "ok");
        cnes.configuraURL(map);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConsultarEstabelecimentoCod() {
        cnes = new CNES();
        cnes.consultarEstabelecimentoCod(null, null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConsultarEstabelecimentoCod1() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarEstabelecimentoCod(null, callback);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConsultarEstabelecimentoCod2() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarEstabelecimentoCod("a", callback);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConsultarEstabelecimentoCod3() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarEstabelecimentoCod("1", callback);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConsultarEstabelecimentoCod4() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarEstabelecimentoCod("12345678", callback);
    }
    
    @Test(expected=NullPointerException.class)
    public void testConsultarEstabelecimentoCod5() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarEstabelecimentoCod("1234567", callback);
    }
    
    @Test()
    public void testConsultarEstabelecimentoCod6() {
        cnes = carregaCNES(new CNES());
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarEstabelecimentoCod("1234567", callback);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConsultarEstabelecimentoCnpj() {
        cnes = new CNES();
        cnes.consultarEstabelecimentoCnpj(null, null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConsultarEstabelecimentoCnpj1() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarEstabelecimentoCnpj(null, callback);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConsultarEstabelecimentoCnpj2() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarEstabelecimentoCnpj("a", callback);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConsultarEstabelecimentoCnpj3() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarEstabelecimentoCnpj("6", callback);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConsultarEstabelecimentoCnpj4() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarEstabelecimentoCnpj("676521630001201", callback);
    }

    
    @Test(expected=NullPointerException.class)
    public void testConsultarEstabelecimentoCnpj5() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarEstabelecimentoCnpj("67652163000120", callback);
    }
    
    @Test()
    public void testConsultarEstabelecimentoCnpj6() {
        cnes = carregaCNES(new CNES());
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarEstabelecimentoCnpj("67652163000120", callback);
    }

    @Test(expected=IllegalArgumentException.class)
    public void consultarPreCadastroCNESCod() {
        cnes = new CNES();
        cnes.consultarPreCadastroCNESCod(null, null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void consultarPreCadastroCNESCod1() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESCod(null, callback);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void consultarPreCadastroCNESCod2() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESCod("a", callback);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void consultarPreCadastroCNESCod3() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESCod("1", callback);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void consultarPreCadastroCNESCod4() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESCod("12345678", callback);
    }
    
    @Test(expected=NullPointerException.class)
    public void consultarPreCadastroCNESCod5() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESCod("1234567", callback);
    }
    
    @Test()
    public void consultarPreCadastroCNESCod6() {
        cnes = carregaCNES(new CNES());
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESCod("1234567", callback);
    }

    @Test(expected=IllegalArgumentException.class)
    public void consultarPreCadastroCNESSituacao() {
        cnes = new CNES();
        cnes.consultarPreCadastroCNESCod(null, null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void consultarPreCadastroCNESSituacao1() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESCod(null, callback);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void consultarPreCadastroCNESSituacao2() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESCod("a", callback);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void consultarPreCadastroCNESSituacao3() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESSituacao("1", callback);
    }
    
    @Test(expected=NullPointerException.class)
    public void consultarPreCadastroCNESSituacao4() {
        cnes = new CNES();
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESSituacao("A", callback);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void consultarPreCadastroCNESSituacao5() {
        cnes = carregaCNES(new CNES());
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESSituacao("AA", callback);
    }
    
    @Test()
    public void consultarPreCadastroCNESSituacao6() {
        cnes = carregaCNES(new CNES());
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESSituacao("A", callback);
    }
    
    @Test()
    public void consultarPreCadastroCNESSituacao7() {
        cnes = carregaCNES(new CNES());
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESSituacao("D", callback);
    }
    
    @Test()
    public void consultarPreCadastroCNESSituacao8() {
        cnes = carregaCNES(new CNES());
        callback = (Map<String, Retorno> m) -> { };
        cnes.consultarPreCadastroCNESSituacao("E", callback);
    }
    


    /**



    @Test
    public void testDetalharVinculacaoProfissional() {
        fail("Not yet implemented");
    }

    @Test
    public void testPesquisarVinculacaoProfissional() {
        fail("Not yet implemented");
    }

    @Test
    public void testConsultarEstabelecimentoSaude() {
        fail("Not yet implemented");
    }

    @Test
    public void testConsultarEstabelecimentoSaudePorMunicipio() {
        fail("Not yet implemented");
    }

    @Test
    public void testConsultarDadosComplementaresEstabelecimentoSaude() {
        fail("Not yet implemented");
    }

    @Test
    public void testConsultarProfissionalSaude() {
        fail("Not yet implemented");
    }

    @Test
    public void testConsultarProfissionaisSaude() {
        fail("Not yet implemented");
    }
    */
    
    private CNES carregaCNES(CNES cnes) {
        Conexao c = (String url, String content, Consumer<String> consumer) -> { };
        Map<String, String> map = new HashMap<>();
        map.put("ok", "ok");
        cnes.configuraURL(map);
        cnes.setConexao(c);
        
        return cnes;
    }
}
