package com.github.integracao2017.cnes.implementacao.servicos;

import com.github.integracao2017.cnes.cnesinterface.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Classe responsável por realizar o parser para o retorno do CnesService
 * @author Rony Nogueira <ronynogueiras@gmail.com>
 * @see CnesService
 * @version 1.0
 *
 */
public class CnesServiceParser extends Servico {
    /**
     * Construtor default do parser
     * @param callbackCliente
     */
    public CnesServiceParser(Callback callbackCliente) {
        super(callbackCliente);
    }

    /**
     * Realiza o parser do XML recebido como resposta
     * @param xml - XML vindo do servidor.
     */
    @Override
    public void accept(String xml) {
        try {
            NodeList nodeList = this.getNode(xml, "http://www.w3.org/2003/05/soap-envelope");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    parser(CnesService.CODIGO_CNES, element, "http://servicos.saude.gov.br/schema/cnes/v1r0/codigocnes","codigoCNES","http://servicos.saude.gov.br/schema/cnes/v1r0/codigocnes","codigo");
                    parser(CnesService.CODIGO_UNIDADE, element, "http://servicos.saude.gov.br/schema/cnes/v1r0/codigounidade","CodigoUnidade","http://servicos.saude.gov.br/schema/cnes/v1r0/codigounidade","codigo");

                    parser(CnesService.NOME_FANTASIA, element,"http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes","nomeFantasia", "http://servicos.saude.gov.br/schema/corporativo/pessoajuridica/v1r0/nomejuridico", "Nome");
                    parser(CnesService.ENDERECO_LOGRADOURO, element, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "nomeLogradouro");
                    parser(CnesService.ENDERECO_NUMERO, element, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "numero");
                    parser(CnesService.ENDERECO_COMPLEMENTO, element, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "complemento");
                    parser(CnesService.ENDERECO_BAIRRO, element, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Bairro", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r1/bairro", "descricaoBairro");
                    parser(CnesService.ENDERECO_CEP, element, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "CEP", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r1/cep", "numeroCEP");
                    parser(CnesService.ENDERECO_CODIGO_MUNICIPIO, element, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio", "http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "codigoMunicipio");
                    parser(CnesService.ENDERECO_NOME_MUNICIPIO, element, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio", "http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "nomeMunicipio");
                    parser(CnesService.ENDERECO_CODIGO_UF, element, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio", "http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "codigoUF");
                    parser(CnesService.ENDERECO_SIGLA_UF, element, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio", "http://servicos.saude.gov.br/schema/corporativo/v1r1/uf", "siglaUF");
                    parser(CnesService.ENDERECO_DATA_ATUALIZACAO, element, "http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "dataAtualizacao");

                    parser(CnesService.DIRETOR_CPF, element, "http://servicos.saude.gov.br/schema/cnes/v1r0/diretor", "Diretor", "http://servicos.saude.gov.br/schema/cnes/v1r0/diretor", "CPF", "http://servicos.saude.gov.br/schema/corporativo/documento/v1r2/cpf", "numeroCPF");
                    parser(CnesService.DIRETOR_NOME, element, "http://servicos.saude.gov.br/schema/cnes/v1r0/diretor", "Diretor", "http://servicos.saude.gov.br/schema/cnes/v1r0/diretor", "nome", "http://servicos.saude.gov.br/schema/corporativo/pessoafisica/v1r2/nomecompleto", "Nome");

                    parser(CnesService.UNIDADE_CODIGO, element, "http://servicos.saude.gov.br/schema/cnes/v1r0/tipounidade", "tipoUnidade", "http://servicos.saude.gov.br/schema/cnes/v1r0/tipounidade", "codigo");
                    parser(CnesService.UNIDADE_DESCRICAO, element, "http://servicos.saude.gov.br/schema/cnes/v1r0/tipounidade", "tipoUnidade", "http://servicos.saude.gov.br/schema/cnes/v1r0/tipounidade", "descricao");

                    parser(CnesService.TIPO_TELEFONE_CODIGO, element, "http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "Telefone", "http://servicos.saude.gov.br/schema/corporativo/telefone/v1r2/telefone", "TipoTelefone", "http://servicos.saude.gov.br/schema/corporativo/telefone/v1r2/telefone", "codigoTipoTelefone");
                    parser(CnesService.TIPO_TELEFONE_DESCRICAO, element, "http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "Telefone", "http://servicos.saude.gov.br/schema/corporativo/telefone/v1r2/telefone", "TipoTelefone", "http://servicos.saude.gov.br/schema/corporativo/telefone/v1r2/telefone", "descricaoTipoTelefone");
                    parser(CnesService.TIPO_TELEFONE_DDD, element, "http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "Telefone", "http://servicos.saude.gov.br/schema/corporativo/telefone/v1r2/telefone", "DDD");
                    parser(CnesService.NUMERO_TELEFONE, element, "http://servicos.saude.gov.br/schema/cnes/v1r0/dadosgeraiscnes", "Telefone", "http://servicos.saude.gov.br/schema/corporativo/telefone/v1r2/telefone", "numeroTelefone");

                    NodeList nodeListChild  = getNameSpace(element, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "profissional");

                    for (int j = 0; j < nodeListChild.getLength(); j++) {
                        Element childElement = (Element) nodeListChild.item(j);
                        parser(ProfissionalSaudeService.PROF_NOME, childElement,
                                "http://servicos.saude.gov.br/schema/corporativo/pessoafisica/v1r2/nomecompleto", "Nome");
                        parser(ProfissionalSaudeService.PROF_CNS_NUM, childElement,
                                "http://servicos.saude.gov.br/schema/cadsus/v5r0/cns", "CNS",
                                "http://servicos.saude.gov.br/schema/cadsus/v5r0/cns", "numeroCNS");
                        parser(ProfissionalSaudeService.PROF_CPF, childElement,
                                "http://servicos.saude.gov.br/schema/corporativo/documento/v1r2/cpf", "numeroCPF");
                        parser(ProfissionalSaudeService.PROF_COD_CBO, childElement,
                                "http://servicos.saude.gov.br/schema/profissionalsaude/v1r0/cbo", "CBO",
                                "http://servicos.saude.gov.br/schema/profissionalsaude/v1r0/cbo", "codigoCBO");

                        parser(ProfissionalSaudeService.PROF_DESC_CBO, childElement,
                                "http://servicos.saude.gov.br/schema/profissionalsaude/v1r0/cbo", "CBO",
                                "http://servicos.saude.gov.br/schema/profissionalsaude/v1r0/cbo", "descricaoCBO");
                    }

                    nodeListChild  = getNameSpace(element, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "leito");

                    for (int j = 0; j < nodeListChild.getLength(); j++) {

                        Element childElement = (Element) nodeListChild.item(j);

                        parser(LeitoService.CODIGO, childElement, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "leito", "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "codigo");
                        parser(LeitoService.DESCRICAO, childElement, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "leito", "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "descricao");
                        parser(LeitoService.DATA_ATUALIZACAO, childElement, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "leito", "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "dataAtualizacao");
                        parser(LeitoService.QUANTIDADE_LEITO, childElement, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "leito", "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "quantidadeLeito");
                        parser(LeitoService.QUANTIDADE_LEITO_SUS, childElement, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "leito", "http://servicos.saude.gov.br/schema/cnes/v1r0/leito", "quantidadeLeitoSUS");
                    }

                    nodeListChild  = getNameSpace(element, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "equipamento");

                    for (int j = 0; j < nodeListChild.getLength(); j++) {
                        Element childElement = (Element) nodeListChild.item(j);

                        parser(EquipamentoService.CODIGO_EQUIPAMENTO, childElement, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio", "http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "codigoMunicipio");
                        parser(EquipamentoService.DESCRICAO_EQUIPAMENTO, childElement, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio", "http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "codigoMunicipio");
                        parser(EquipamentoService.CODIGO_TIPOEQUIPAMENTO, childElement, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio", "http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "codigoMunicipio");
                        parser(EquipamentoService.DESCRICAO_TIPOEQUIPAMENTO, childElement, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio", "http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "codigoMunicipio");
                        parser(EquipamentoService.QUANTIDADE_EQUIPAMENTO, childElement, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio", "http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "codigoMunicipio");
                        parser(EquipamentoService.QUANTIDADEUSO_EQUIPAMENTO, childElement, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio", "http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "codigoMunicipio");
                        parser(EquipamentoService.DISPONIBILIDADESUS_EQUIPAMENTO, childElement, "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Endereco", "http://servicos.saude.gov.br/schema/corporativo/endereco/v1r2/endereco", "Municipio", "http://servicos.saude.gov.br/schema/corporativo/v1r2/municipio", "codigoMunicipio");

                    }


                    parser(CnesService.SUMARIO_QTD_PROFISSIONAIS_SAUDE, element, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "sumario", "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "quantidadeProfissionaisSaude");
                    parser(CnesService.SUMARIO_QTD_CBOS, element, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "sumario", "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "quantidadeCBOS");
                    parser(CnesService.SUMARIO_QTD_LEITOS, element, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "sumario", "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "quantidadeLeitos");
                    parser(CnesService.SUMARIO_QTD_HABILITACOES, element, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "sumario", "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "quantidadeHabilitacoes");
                    parser(CnesService.SUMARIO_QTD_EQUIPAMENTOS, element, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "sumario", "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "quantidadeEquipamentos");
                    parser(CnesService.SUMARIO_QTD_SAMU, element, "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "sumario", "http://servicos.saude.gov.br/wsdl/mensageria/v1r0/resultadopesquisaestabelecimentosaude", "quantidadeSamus");

                }
            }

            callback.funcao(mapa);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
