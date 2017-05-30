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

					parser(EstabelecimentoSaudeService.CODIGO_CNES, eElement,
								"http://servicos.saude.gov.br/schema/cnes/v1r0/codigocnes", "codigo");

					parser(EstabelecimentoSaudeService.CODIGO_UNIDADE, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/codigounidade", "codigo");

					parser(EstabelecimentoSaudeService.NOME_FANTASIA, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "nomeFantasia",
							"http://servicos.saude.gov.br/schema/corporativo/pessoajuridica/v1r0/nomejuridico", "Nome");

					parser(EstabelecimentoSaudeService.NOME_EMPRESARIAL, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "nomeEmpresarial",
							"http://servicos.saude.gov.br/schema/corporativo/pessoajuridica/v1r0/nomejuridico", "Nome");

					parser(EstabelecimentoSaudeService.CNPJ, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/pessoajuridica/v1r0/cnpj", "numeroCNPJ");

					parser(EstabelecimentoSaudeService.INDENTIFICADOR, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "identificador");

					parser(EstabelecimentoSaudeService.TIPO_ENDERECO, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "TipoEndereco");

					parser(EstabelecimentoSaudeService.TIPO_ENDERECO, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "TipoEndereco");


					parser(EstabelecimentoSaudeService.COD_TIPO_LORGADOURO, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "TipoLogradouro",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r1/tipologradouro", "codigoTipoLogradouro");


					parser(EstabelecimentoSaudeService.DESC_TIPO_LORGADOURO, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "TipoLogradouro",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r1/tipologradouro", "descricaoTipoLogradouro");

					parser(EstabelecimentoSaudeService.NOME_LORGADOURO, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "nomeLogradouro");

					parser(EstabelecimentoSaudeService.NUM_ENDERECO, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "numero");

					parser(EstabelecimentoSaudeService.CMPLMT_ENDERECO, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "complemento");

					parser(EstabelecimentoSaudeService.COD_BAIRRO, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Bairro",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r1/bairro", "codigoBairro");

					parser(EstabelecimentoSaudeService.COD_BAIRRO, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Bairro",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r1/bairro", "descricaoBairro");

					parser(EstabelecimentoSaudeService.NUM_CEP	, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "CEP",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r1/cep", "numeroCEP");

					parser(EstabelecimentoSaudeService.COD_MUNICIPIO, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "codigoMunicipio");

					parser(EstabelecimentoSaudeService.NOME_MUNICIPIO, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "nomeMunicipio");

					parser(EstabelecimentoSaudeService.COD_UF, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "UF",
							"http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "codigoUF");


					parser(EstabelecimentoSaudeService.SIGLA_UF, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "UF",
							"http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "siglaUF");

					parser(EstabelecimentoSaudeService.COD_REGIAO, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "UF",
							"http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "codigoRegiao");

					parser(EstabelecimentoSaudeService.NOME_UF, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "UF",
							"http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "nomeUF");

					parser(EstabelecimentoSaudeService.COD_PAIS, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Pais",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/pais", "codigoPais");

					parser(EstabelecimentoSaudeService.COD_PAIS_ANT, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Pais",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/pais", "codigoPaisAntigo");

					parser(EstabelecimentoSaudeService.NOME_PAIS, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Pais",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/pais", "nomePais");


					parser(EstabelecimentoSaudeService.MUNICIPIO_INTERN, eElement,
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "municipioInternacional");

					parser(EstabelecimentoSaudeService.DATA_ATUALIZACAO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "dataAtualizacao");

					parser(EstabelecimentoSaudeService.DIRT_CPF, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/diretor", "CPF",
						"http://servicos.saude.gov.br/schema/corporativo/documento/v1r2/cpf","numeroCPF");

					parser(EstabelecimentoSaudeService.DIRT_NOME, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/diretor", "nome",
							"http://servicos.saude.gov.br/schema/corporativo/pessoafisica/v1r2/nomecompleto","Nome");

					parser(EstabelecimentoSaudeService.TIP_UN_COD, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/tipounidade", "tipoUnidade",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/tipounidade", "codigo");

					parser(EstabelecimentoSaudeService.TIP_UN_DESC, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/tipounidade", "tipoUnidade",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/tipounidade", "descricao");

					parser(EstabelecimentoSaudeService.ESF_ADM_COD, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/esferaadministrativa", "esferaAdministrativa",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/esferaadministrativa", "codigo");

					parser(EstabelecimentoSaudeService.ESF_ADM_DESC, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/esferaadministrativa", "esferaAdministrativa",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/esferaadministrativa", "descricao");

					parser(EstabelecimentoSaudeService.MN_GEST_COD_MUNI, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "MunicipioGestor",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "codigoMunicipio");

					parser(EstabelecimentoSaudeService.MN_GEST_NOME_MUNI, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "MunicipioGestor",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "nomeMunicipio");

					parser(EstabelecimentoSaudeService.MN_GEST_COD_UF, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "MunicipioGestor",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "UF",
							"http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "codigoUF");

					parser(EstabelecimentoSaudeService.MN_GEST_COD_UF, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "MunicipioGestor",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "UF",
							"http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "siglaUF");

					parser(EstabelecimentoSaudeService.MN_GEST_COD_REG, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "MunicipioGestor",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "UF",
							"http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "codigoRegiao");

					parser(EstabelecimentoSaudeService.MN_GEST_NOME_UF, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "MunicipioGestor",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "UF",
							"http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "nomeUF");

					Collection<Telefone> telefones = new ArrayList<Telefone>();

					NodeList nodeListTel  = getNameSpace(eElement, "http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "Telefone");

					for (int j = 0; j < nodeListTel.getLength(); j++) {
						Element n = (Element) nodeListTel.item(j);
						Telefone telefone = new Telefone();
						telefone.setCodTipoTelefone(
								parser(n, "http://servicos.saude.gov.br/schema/corporativo/telefone/v1r2/telefone", "TipoTelefone",
										"http://servicos.saude.gov.br/schema/corporativo/telefone/v1r1/tipotelefone", "codigoTipoTelefone"));
						telefone.setDescTipoTelefone(
								parser(n, "http://servicos.saude.gov.br/schema/corporativo/telefone/v1r2/telefone", "TipoTelefone",
										"http://servicos.saude.gov.br/schema/corporativo/telefone/v1r1/tipotelefone", "descricaoTipoTelefone"));

						telefone.setDdiTelefone(
								parser(n, "http://servicos.saude.gov.br/schema/corporativo/telefone/v1r2/telefone", "DDI")
						);

						telefone.setDdTelefone(
								parser(n, "http://servicos.saude.gov.br/schema/corporativo/telefone/v1r2/telefone", "DDD"));

						telefone.setNumTelefone(
								parser(n, "http://servicos.saude.gov.br/schema/corporativo/telefone/v1r2/telefone", "numeroTelefone"));
						telefones.add(telefone);
					}
					mapa.put(EstabelecimentoSaudeService.TELEFONES.getChave(),
							new RetornoColecao(telefones));

					parser(EstabelecimentoSaudeService.EMAIL_INDENTF, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "Email",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/email", "identificador");

					parser(EstabelecimentoSaudeService.EMAIL_DESC, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "Email",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/email", "descricaoEmail");

					parser(EstabelecimentoSaudeService.EMAIL_TIPO, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "Email",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/email", "tipoEmail");

					parser(EstabelecimentoSaudeService.EMAIL_VALID, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "Email",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/email", "validado");

					parser(EstabelecimentoSaudeService.LONGINTUDE, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "Localizacao",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/localizacao", "longitude");

					parser(EstabelecimentoSaudeService.LATITUDE, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "Localizacao",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/localizacao", "latitude");

					parser(EstabelecimentoSaudeService.GEO_JSON, eElement,
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "Localizacao",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/localizacao", "geoJson");

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
