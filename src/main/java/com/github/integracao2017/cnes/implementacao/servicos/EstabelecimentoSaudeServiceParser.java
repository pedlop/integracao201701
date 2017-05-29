package com.github.integracao2017.cnes.implementacao.servicos;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.EstabelecimentoSaudeService;
import com.github.integracao2017.cnes.cnesinterface.retorno.RetornoColecao;
import com.github.integracao2017.cnes.cnesinterface.retorno.RetornoString;
import com.github.integracao2017.cnes.cnesinterface.retorno.Telefone;

/**
 * @author gabriel
 * @version 1.0.0
 *          <p>
 *          Objetivo classe com a logica para realizar parse das respotas vindas
 *          do servico de consulta de estabelecimento de saude.
 */
public class EstabelecimentoSaudeServiceParser extends Servico {

	/**
	 * @param c
	 *            - Callback cliente.
	 */
	public EstabelecimentoSaudeServiceParser(Callback c) {
		super(c);
	}

	@Override
	public void accept(String xml) {

		try {
			NodeList nodeList = this.getNode(xml, "S:Body");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					mapa.put(EstabelecimentoSaudeService.CODIGO_CNES.getChave(),
							new RetornoString(
									getElement(eElement, "ns2:codigo")));
					mapa.put(
							EstabelecimentoSaudeService.CODIGO_UNIDADE
									.getChave(),
							new RetornoString(
									getElement(eElement, "ns24:codigo")));
					mapa.put(
							EstabelecimentoSaudeService.NOME_FANTASIA
									.getChave(),
							new RetornoString(
									getElement(eElement, "ns25:nomeFantasia")));
					mapa.put(
							EstabelecimentoSaudeService.NOME_EMPRESARIAL
									.getChave(),
							new RetornoString(
									getElement(eElement, "ns25:nomeEmpresarial")));
					mapa.put(EstabelecimentoSaudeService.CNPJ.getChave(),
							new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.INDENTIFICADOR
							.getChave(), new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.TIPO_ENDERECO
							.getChave(), new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.COD_TIPO_LORGADOURO
							.getChave(), new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.DESC_TIPO_LORGADOURO
							.getChave(), new RetornoString(""));
					mapa.put(
							EstabelecimentoSaudeService.NOME_LORGADOURO
									.getChave(),
							new RetornoString(
									getElement(eElement, "ns25:nomeEmpresarial", "ns11:nomeLogradouro")));
					mapa.put(
							EstabelecimentoSaudeService.NUM_ENDERECO.getChave(),
							new RetornoString(
									getElement(eElement, "ns25:nomeEmpresarial", "ns11:numero")));
					mapa.put(
							EstabelecimentoSaudeService.CMPLMT_ENDERECO
									.getChave(),
							new RetornoString(((Element) eElement
									.getElementsByTagName("ns11:Endereco")
									.item(0))
											.getElementsByTagName(
													"ns11:complemento")
											.item(0).getTextContent()));
					mapa.put(EstabelecimentoSaudeService.COD_BAIRRO.getChave(),
							new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.DESC_BAIRRO.getChave(),
							new RetornoString(getElement(eElement,
									"ns11:Endereco", "ns11:Bairro",
									"ns13:descricaoBairro")));
					mapa.put(EstabelecimentoSaudeService.NUM_CEP.getChave(),
							new RetornoString(
									getElement(eElement, "ns11:Endereco",
											"ns11:CEP", "ns14:numeroCEP")));

					mapa.put(
							EstabelecimentoSaudeService.COD_MUNICIPIO
									.getChave(),
							new RetornoString(
									getElement(eElement, "ns11:Endereco",
											"ns11:CEP", "ns15:codigoMunicipio")));
					mapa.put(
							EstabelecimentoSaudeService.NOME_MUNICIPIO
									.getChave(),
							new RetornoString(
									getElement(eElement, "ns11:Endereco", "ns11:Municipio", "ns15:nomeMunicipio")));
					mapa.put(EstabelecimentoSaudeService.COD_UF.getChave(),
							new RetornoString(
									getElement(eElement, "ns11:Endereco",
											"ns11:Municipio", "ns15:UF", "ns16:codigoUF")));
					mapa.put(EstabelecimentoSaudeService.SIGLA_UF.getChave(),
							new RetornoString(getElement(eElement, "ns11:Endereco",
											"ns11:Municipio", "ns15:UF", "ns16:siglaUF")));
					mapa.put(EstabelecimentoSaudeService.COD_REGIAO.getChave(),
							new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.COD_PAIS.getChave(),
							new RetornoString(""));
					mapa.put(
							EstabelecimentoSaudeService.COD_PAIS_ANT.getChave(),
							new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.NOME_PAIS.getChave(),
							new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.MUNICIPIO_INTERN
							.getChave(), new RetornoString(""));
					mapa.put(
							EstabelecimentoSaudeService.DATA_ATUALIZACAO
									.getChave(),
							new RetornoString(
									getElement(eElement, "ns25:dataAtualizacao")));
					mapa.put(EstabelecimentoSaudeService.DIRT_CPF.getChave(),
							new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.DIRT_NOME.getChave(),
							new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.DIRT_NOME.getChave(),
							new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.TIP_UN_COD.getChave(),
							new RetornoString(
									getElement(eElement, "ns28:tipoUnidade", "ns28:codigo")));
					mapa.put(EstabelecimentoSaudeService.TIP_UN_DESC.getChave(),
							new RetornoString(
									getElement(eElement, "ns28:tipoUnidade", "ns28:descricao")));
					mapa.put(EstabelecimentoSaudeService.ESF_ADM_COD.getChave(),
							new RetornoString(""));
					mapa.put(
							EstabelecimentoSaudeService.ESF_ADM_DESC.getChave(),
							new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.MN_GEST_COD_MUNI
							.getChave(), new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.MN_GEST_NOME_MUNI
							.getChave(), new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.MN_GEST_COD_UF
							.getChave(), new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.MN_GEST_SIGLA_UF
							.getChave(), new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.MN_GEST_COD_REG
							.getChave(), new RetornoString(""));
					mapa.put(EstabelecimentoSaudeService.MN_GEST_NOME_UF
							.getChave(), new RetornoString(""));
					Collection<Telefone> telefones = new ArrayList<>();
					for (int j = 0; j < eElement
							.getElementsByTagName("ns25:Telefone")
							.getLength(); j++) {
						Telefone telefone = new Telefone();
						telefone.setCodTipoTelefone(getElement(eElement.getElementsByTagName(
										"ns25:Telefone").item(j), "ns18:TipoTelefone", "ns19:codigoTipoTelefone"));
						telefone.setDescTipoTelefone(
								getElement(eElement.getElementsByTagName(
										"ns25:Telefone").item(j), "ns18:TipoTelefone", "ns19:descricaoTipoTelefone"));
						telefone.setDdTelefone(getElement(eElement,"ns18:DDD"));
						telefone.setNumTelefone(getElement(eElement,"ns18:numeroTelefone"));
						telefones.add(telefone);
					}
					mapa.put(EstabelecimentoSaudeService.TELEFONES.getChave(),
							new RetornoColecao(telefones));

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
