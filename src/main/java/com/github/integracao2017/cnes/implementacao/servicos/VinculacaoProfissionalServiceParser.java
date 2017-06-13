package com.github.integracao2017.cnes.implementacao.servicos;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.VinculacaoProfissionalService;

/**
 * @author Pedro Victor
 * @version 1.0.0
 *          <p>
 *          Objetivo classe com a logica para realizar parse das respotas vindas
 *          do servico de consulta da vinculacao do profissional de saude.
 */
public class VinculacaoProfissionalServiceParser extends Servico {

	/**
	 * @param c - Callback cliente.
	 */
	public VinculacaoProfissionalServiceParser(Callback c) {
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

					parser(VinculacaoProfissionalService.PROF_NOME, eElement,
							//"http://servicos.saude.gov.br/cnes/v1r0/vinculacaoprofissionalservice", "ResponseVinculacao",
							//"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "Vinculacaos",
							//"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "Vinculacao",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "Profissional",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosbasicosprofissional", "Nome",
							"http://servicos.saude.gov.br/schema/corporativo/pessoafisica/v1r2/nomecompleto", "Nome");

					parser(VinculacaoProfissionalService.PROF_CPF, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "Profissional",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosbasicosprofissional", "CPF",
							"http://servicos.saude.gov.br/schema/corporativo/documento/v1r2/cpf", "numeroCPF");

					parser(VinculacaoProfissionalService.PROF_CNS_NUM, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "Profissional",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosbasicosprofissional", "CNS",
							"http://servicos.saude.gov.br/schema/cadsus/v5r0/cns", "numeroCNS");

					parser(VinculacaoProfissionalService.PROF_CNS_DATA_ATRIB, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "Profissional",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosbasicosprofissional", "CNS",
							"http://servicos.saude.gov.br/schema/cadsus/v5r0/cns", "dataAtribuicao");

					parser(VinculacaoProfissionalService.PROF_CNS_TIPO_CARTAO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "Profissional",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosbasicosprofissional", "CNS",
							"http://servicos.saude.gov.br/schema/cadsus/v5r0/cns", "tipoCartao");

					parser(VinculacaoProfissionalService.PROF_CNS_MANUAL, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "Profissional",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosbasicosprofissional", "CNS",
							"http://servicos.saude.gov.br/schema/cadsus/v5r0/cns", "manual");

					parser(VinculacaoProfissionalService.PROF_CNS_JUST_MANUAL, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "Profissional",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosbasicosprofissional", "CNS",
							"http://servicos.saude.gov.br/schema/cadsus/v5r0/cns", "justificativaManual");

					parser(VinculacaoProfissionalService.CODIGO_CNES, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "Estabelecimento",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/codigocnes", "CodigoCNES",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/codigocnes", "codigo");


					parser(VinculacaoProfissionalService.NOME_FANTASIA, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "Estabelecimento",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosbasicosestabelecimento", "NomeFantasia",
							"http://servicos.saude.gov.br/schema/corporativo/pessoajuridica/v1r0/nomejuridico", "Nome");

					parser(VinculacaoProfissionalService.VINCULACAO_IND, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "indVinculacao");

					parser(VinculacaoProfissionalService.VINCULO_COD_MOD, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "codigoModVinculo");

					parser(VinculacaoProfissionalService.VINCULO_COD_MOD_DESC, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "desCodigoModVinculo");

					parser(VinculacaoProfissionalService.VINCULO_COD_MOD_TIPO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "codigoTipoModVinculo");

					parser(VinculacaoProfissionalService.VINCULO_COD_MOD_TIPO_DESC, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "desTipoCodigoModVinculo");

					parser(VinculacaoProfissionalService.VINCULO_COD_MOD_SUB_TIPO	, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "codigoSubTipoModVinculo");

					parser(VinculacaoProfissionalService.VINCULO_COD_MOD_SUB_TIPO_DESC, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "desSubTipoCodigoModVinculo");

					parser(VinculacaoProfissionalService.CBO_COD, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "CBOs",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "CBO",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "codigoCBO");

					parser(VinculacaoProfissionalService.CBO_DESC, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "CBOs",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "CBO",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "descricaoCBO");


					parser(VinculacaoProfissionalService.QTD_CARGA_HR_AMUBULATOTIAL, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "CBOs",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "CBO",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "qtCargaHorariaAmbulatotial");

					parser(VinculacaoProfissionalService.QTD_CARGA_HR_OUTROS, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "CBOs",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "CBO",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "qtCargaHorariaOutros");

					parser(VinculacaoProfissionalService.QTD_CARGA_HR_HOSP_SUS, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "CBOs",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "CBO",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "qtCargaHorariaHospSus");

					parser(VinculacaoProfissionalService.COMPT_INICIO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "CBOs",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "CBO",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "comptInicio");

					parser(VinculacaoProfissionalService.COMPT_FIM, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacao", "CBOs",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "CBO",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/vinculacaocbotype", "comptFin");

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
