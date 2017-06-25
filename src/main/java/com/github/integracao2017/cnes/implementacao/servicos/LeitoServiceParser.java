package com.github.integracao2017.cnes.implementacao.servicos;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.LeitoService;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Raphael
 * @version 1.0.0
 *          <p>
 *          Objetivo classe com a logica para realizar parse das respotas vindas
 *          do servico de consulta de Leito.
 */
public class LeitoServiceParser extends Servico {

    /**
     * @param c
     *            - Callback cliente.
     */
    public LeitoServiceParser(Callback c) {
        super(c);
    }

    @Override
    public void accept(String xml) {

        try {
            NodeList nodeList = this.getNode(xml, "http://www.w3.org/2003/05/soap-envelope");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;

                    parser(LeitoService.CODIGO, eElement,
                            "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "leito",
                            "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "codigo");

                    parser(LeitoService.DESCRICAO, eElement,
                            "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "leito",
                            "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "descricao");

                    parser(LeitoService.DATA_ATUALIZACAO, eElement,
                            "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "leito",
                            "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "dataAtualizacao");

                    parser(LeitoService.QUANTIDADE_LEITO, eElement,
                            "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "leito",
                            "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "quantidadeLeito");

                    parser(LeitoService.QUANTIDADE_LEITO_SUS, eElement,
                            "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "leito",
                            "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "quantidadeLeitoSUS");
                }
            }
            /**
             * APOS O PARSER REALIZADO CHAMA CALLBACK DO CLIENTE.
             */
            callback.funcao(mapa);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
