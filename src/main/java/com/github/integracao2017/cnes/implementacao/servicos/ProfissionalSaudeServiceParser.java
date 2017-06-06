package com.github.integracao2017.cnes.implementacao.servicos;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.EstabelecimentoSaudeService;
import com.github.integracao2017.cnes.cnesinterface.ProfissionalSaudeService;
import com.github.integracao2017.cnes.cnesinterface.retorno.RetornoColecao;
import com.github.integracao2017.cnes.cnesinterface.retorno.Telefone;

/**
 * @author Jo�o Henrique
 * @version 1.0.0
 *          <p>
 *          Esta classe tem como objetivo realizar o parse das respotas vindas
 *          do servico de consulta das informa��es de um profissional/profissionais.
 */
public class ProfissionalSaudeServiceParser extends Servico {

	/**
	 * @param c
	 *            - Callback cliente.
	 */
	public ProfissionalSaudeServiceParser(Callback c) {
		super(c);
	}

}
