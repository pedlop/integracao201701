package com.github.integracao2017.cnes.implementacao.servicos;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.EquipamentoService;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Lucas Vinicios
 * @version 1.0.0
 *          <p>
 *          Objetivo classe com a logica para realizar parse das respotas vindas
 *          do servico de consulta de estabelecimento de saude.
 */
public class EquipamentoServiceParser extends Servico {

	/**
	 * @param c
	 *            - Callback cliente.
	 */
	public EquipamentoServiceParser(Callback c) {
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

					parser(EquipamentoService.CODIGO_EQUIPAMENTO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "Equipamento",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "codigo");

					parser(EquipamentoService.DESCRICAO_EQUIPAMENTO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "Equipamento",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "descricao");

					parser(EquipamentoService.CODIGO_TIPOEQUIPAMENTO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "Equipamento",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/tipoequipamento", "tipoEquipamento",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/tipoequipamento", "codigo");

					parser(EquipamentoService.DESCRICAO_TIPOEQUIPAMENTO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "Equipamento",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/tipoequipamento", "tipoEquipamento",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/tipoequipamento", "descricao");

					parser(EquipamentoService.DESTINACAO_EQUIPAMENTO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "Equipamento",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "destinacao");

					parser(EquipamentoService.QUANTIDADE_EQUIPAMENTO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "Equipamento",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "quantidadeEquipamento");

					parser(EquipamentoService.QUANTIDADEUSO_EQUIPAMENTO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "Equipamento",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "quantidadeUso");

					parser(EquipamentoService.DISPONIBILIDADESUS_EQUIPAMENTO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "Equipamento",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "TpSUS",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/equipamento", "codigo");
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
