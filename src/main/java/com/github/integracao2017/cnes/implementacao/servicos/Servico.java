package com.github.integracao2017.cnes.implementacao.servicos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.github.integracao2017.cnes.cnesinterface.EstabelecimentoSaudeService;
import com.github.integracao2017.cnes.cnesinterface.retorno.RetornoString;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.retorno.Retorno;

/**
 * @author  gabriel
 * @version 1.0.0
 *
 * Implementacao gerenerica de servico com todos os metodos
 * e implementacoes necessarias para tratar um xml qualquer,
 * cada servico deverar ter uma classe com o algoritmo
 * de parse implmentado em uma sub-classe.
 */
public abstract  class Servico implements Consumer<String> {

    protected Map<String, Retorno> mapa;

    /**
     * Callback do cliente que devera ser chamado assim que
     * a conversao for feita.
     * */
    protected Callback callback;

    public Servico(Callback callbackCliente) {
        mapa = new HashMap<String, Retorno>();
        callback = callbackCliente;
    }

    /**@return - Resultado do parse do xml.*/
    public Map<String, Retorno> getResultXML() {
        return mapa;
    }



    /**@param xml - XML vindo do servidor.*/
    @Override
    public void accept(String xml) {

    }

    public void parser(EstabelecimentoSaudeService chave, Element element, String nameSpace, String localName) {
        mapa.put(chave.getChave(), new RetornoString(getNameSpace(element, nameSpace, localName).item(0).getTextContent()));
    }

    public void parser(EstabelecimentoSaudeService chave, Element element, String...nameSpaceLocalNameVetor) {
        Map<String, String> nameSpaceLocalName = new HashMap<>();
        for(int i = 0; i < nameSpaceLocalNameVetor.length; i += 2) {
            nameSpaceLocalName.put(nameSpaceLocalNameVetor[i], nameSpaceLocalNameVetor[i + 1]);
        }
        mapa.put(chave.getChave(), new RetornoString(getNameSpace(element, nameSpaceLocalName).item(0).getTextContent()));
    }

    public String parser(Element element, String nameSpace, String localName) {
        return  getNameSpace(element, nameSpace, localName).item(0).getTextContent();
    }

    public String parser(Element element, String...nameSpaceLocalNameVetor) {
        Map<String, String> nameSpaceLocalName = new HashMap<>();
        for(int i = 0; i < nameSpaceLocalNameVetor.length; i += 2) {
            nameSpaceLocalName.put(nameSpaceLocalNameVetor[i], nameSpaceLocalNameVetor[i + 1]);
        }
        return getNameSpace(element, nameSpaceLocalName).item(0).getTextContent();
    }

    public NodeList getNameSpace(Element eElement, String nameSpace, String localName) {
        return eElement.getElementsByTagNameNS(nameSpace, localName);
    }

    public NodeList getNameSpace(Element element, Map<String, String> nameSpaceLocalName) {
        NodeList n = null;
        for(Map.Entry<String, String> entry: nameSpaceLocalName.entrySet()) {
            n  = getNameSpace(element, entry.getKey(), entry.getValue());
        }
        return n;
    }
    
    /**@param xml - XML de onde sera tirado a lista
     * a partir do no raiz da tag.
     * @param nameSpace - No raiz.*/
    protected NodeList getNode(String xml, String nameSpace) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setNamespaceAware(true);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagNameNS(nameSpace, "Body");
    }

}
