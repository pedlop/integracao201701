package com.github.integracao2017.cnes.implementacao.servicos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
    
    protected String getElement(Node node, String...tags) {
    	int tamArv = tags.length -1;
    	String[] tagArv = new String[tamArv];
    	for (int i = 0; i < (tags.length -1); i++) {
    		tagArv[i] = tags[i];
    	}
    	try {
        	return castElement(node, tagArv).getElementsByTagName(tags[tags.length-1])
        		   .item(0).getTextContent();
    	} catch(NullPointerException e) {
    		return "";
    	}
    }

    /**@param node - Tag raiz.
     * @param tags - Array de tags sendo que a ultima
     * tag e a alvo.
     * @return Element - Tag alvo localizada.*/
    private Element castElement(Node node, String...tags) {
        return castElement(node, tags.length, tags);
    }

    /**@param xml - XML de onde sera tirado a lista
     * a partir do no raiz da tag.
     * @param noRaiz - No raiz.*/
    protected NodeList getNode(String xml, String noRaiz) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(noRaiz);
    }

    /**@param node - No de raiz do xml que deseja-se
     * pegar uma subtag.
     * @param tamTags - Tamanho do caminho de tags ate
     * se chegar a tag alvo.
     * @param tags - Sequencia de tags ate se chegar a tag alvo.
     * @return Element - Element da tag alvo.*/
    private Element castElement(Node node, int tamTags, String...tags) {
        if (tamTags == 0 ) {
            return ((Element)  node);
        }
        else {
            tamTags -= tamTags;
            return castElement(((Element) node).getElementsByTagName(tags[tamTags]).item(0), tamTags, tags);
        }
    }
}
