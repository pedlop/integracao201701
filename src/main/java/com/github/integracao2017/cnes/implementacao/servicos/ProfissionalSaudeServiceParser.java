package com.github.integracao2017.cnes.implementacao.servicos;
 
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.ProfissionalSaudeService;
 
/**
 * @author João Henrique
 * @version 1.0.0
 *          <p>
 *          Esta classe tem como objetivo realizar o parse das respotas vindas
 *          do servico de consulta das informações de um profissional/profissionais.
 */
public class ProfissionalSaudeServiceParser extends Servico {
 
	/**
	 * @param c
	 *            - Callback cliente.
	 */
	public ProfissionalSaudeServiceParser(Callback c) {
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
 
					parser(ProfissionalSaudeService.PROF_DATA_ATUALIZACAO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "dataAtualizacao");
							
					parser(ProfissionalSaudeService.PROF_NOME, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Nome",					
							"http://servicos.saude.gov.br/schema/corporativo/pessoafisica/v1r2/nomecompleto", "Nome");		
					
					parser(ProfissionalSaudeService.PROF_CNS_NUM, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "CNS",	
							"http://servicos.saude.gov.br/schema/cadsus/v5r0/cns", "numeroCNS");
					
					parser(ProfissionalSaudeService.PROF_CNS_DATA_ATRIB, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "CNS",
							"http://servicos.saude.gov.br/schema/cadsus/v5r0/cns", "dataAtribuicao");
					
					parser(ProfissionalSaudeService.PROF_CNS_TIPO_CARTAO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "CNS",
							"http://servicos.saude.gov.br/schema/cadsus/v5r0/cns", "tipoCartao");
					
					parser(ProfissionalSaudeService.PROF_CNS_MANUAL, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "CNS",
							"http://servicos.saude.gov.br/schema/cadsus/v5r0/cns", "manual");
					
					parser(ProfissionalSaudeService.PROF_CNS_JUST_MANUAL, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "CNS",
							"http://servicos.saude.gov.br/schema/cadsus/v5r0/cns", "justificativaManual");
					
					parser(ProfissionalSaudeService.PROF_CPF, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "CPF",
							"http://servicos.saude.gov.br/schema/corporativo/documento/v1r2/cpf", "numeroCPF");
					
					parser(ProfissionalSaudeService.PROF_COD_CBO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "CBO",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v1r0/cbo", "codigoCBO");
					
					parser(ProfissionalSaudeService.PROF_DESC_CBO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "CBO",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v1r0/cbo", "descricaoCBO");
					
					parser(ProfissionalSaudeService.PROF_CNES_COD, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "CNES",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/codigocnes", "CodigoCNES",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/codigocnes", "codigo");
					
					parser(ProfissionalSaudeService.PROF_NOME_FANTASIA, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "CNES",
							"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosbasicosestabelecimento", "NomeFantasia",
							"http://servicos.saude.gov.br/schema/corporativo/pessoajuridica/v1r0/nomejuridico", "Nome");
					
					parser(ProfissionalSaudeService.PROF_COD_IDENTIFICADOR_EMAIL, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Email",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/email", "identificador");
					
					parser(ProfissionalSaudeService.PROF_DESC_EMAIL, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Email",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/email", "descricaoEmail");
					
					parser(ProfissionalSaudeService.PROF_TIPO_EMAIL, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Email",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/email", "tipoEmail");
					
					parser(ProfissionalSaudeService.PROF_EMAIL_VALIDADO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Email",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/email", "validado");
					
					parser(ProfissionalSaudeService.PROF_IDENTIF_ENDERECO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "identificador");
					
					parser(ProfissionalSaudeService.PROF_TIPO_ENDERECO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "TipoEndereco");
					
					parser(ProfissionalSaudeService.PROF_COD_TIPO_LOGRADOURO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "TipoLogradouro",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r1/tipologradouro", "codigoTipoLogradouro");
					
					parser(ProfissionalSaudeService.PROF_DESC_TIPO_LOGRADOURO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "TipoLogradouro",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r1/tipologradouro", "descricaoTipoLogradouro");
					
					parser(ProfissionalSaudeService.PROF_NOME_LOGRADOURO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "nomeLogradouro");
					
					parser(ProfissionalSaudeService.PROF_NUM_LOGRADOURO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "numero");
					
					parser(ProfissionalSaudeService.PROF_COMPLEMENTO_LOGRADOURO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "complemento");
					
					parser(ProfissionalSaudeService.PROF_CODIGO_BAIRRO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Bairro",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r1/bairro", "codigoBairro");
					
					parser(ProfissionalSaudeService.PROF_DESC_BAIRRO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Bairro",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r1/bairro", "descricaoBairro");
					
					parser(ProfissionalSaudeService.PROF_COD_CEP, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "CEP",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r1/cep", "numeroCEP");
					
					parser(ProfissionalSaudeService.PROF_COD_MUNICIPIO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "codigoMunicipio");
					
					parser(ProfissionalSaudeService.PROF_NOME_MUNICIPIO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "nomeMunicipio");
					
					parser(ProfissionalSaudeService.PROF_COD_UF, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "UF",
							"http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "codigoUF");
					
					parser(ProfissionalSaudeService.PROF_SIGLA_UF, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "UF",
							"http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "siglaUF");
					
					parser(ProfissionalSaudeService.PROF_COD_REGIAO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "UF",
							"http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "codigoRegiao");
					
					parser(ProfissionalSaudeService.PROF_NOME_UF, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "UF",
							"http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "nomeUF");
					
					parser(ProfissionalSaudeService.PROF_COD_PAIS, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Pais",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/pais", "codigoPais");
					
					parser(ProfissionalSaudeService.PROF_COD_PAIS_ANTIGO, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Pais",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/pais", "codigoPaisAntigo");
					
					parser(ProfissionalSaudeService.PROF_NOME_PAIS, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Pais",
							"http://servicos.saude.gov.br/schema/corporativo/v1r2/pais", "nomePais");
					
					parser(ProfissionalSaudeService.PROF_MUNICIPIO_INTERNACIONAL, eElement,
							"http://servicos.saude.gov.br/cnes/v1r0/profissionalsaudeservice","responseConsultarProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude","ProfissionalSaude",
							"http://servicos.saude.gov.br/schema/profissionalsaude/v2r0/profissionalsaude", "Endereco",
							"http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "municipioInternacional");					
					
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
