package com.github.integracao2017.cnes.implementacao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.github.integracao2017.cnes.cnesinterface.BarramentoCNES;
import com.github.integracao2017.cnes.cnesinterface.Callback;
import com.github.integracao2017.cnes.cnesinterface.Conexao;
import com.github.integracao2017.cnes.implementacao.servicos.EquipamentoServiceParser;
import com.github.integracao2017.cnes.implementacao.servicos.EstabelecimentoSaudeServiceParser;

/**
 * Created by gabriel on 08/05/17. Edited by lucas on 23/06/17
 */
public class CNES implements BarramentoCNES {

    private Map<String, String> urls;

    private Conexao conexao;

    public void setConexao(Conexao c) {
        if (c == null) {
            throw new IllegalArgumentException(
                    "Conexão passada nula inválida.");
        }
        conexao = c;
    }

    @Override
    public void configuraURL(Map<String, String> urls) {
        if (urls == null || urls.isEmpty())
            throw new IllegalArgumentException("Urls passada nula inálida");
        for (Entry<String, String> u : urls.entrySet()) {
            if (u.getValue() == null)
                throw new IllegalArgumentException("Chave " + u.getKey()
                        + " teve a URL passada como nula.");
        }
        this.urls = urls;
    }

    @Override
    public void consultarEquipamentoCod(String cnes, Callback c) {
        if (cnes == null || c == null || cnes.length() != 7
                || REGEX_SO_NUMEROS.matcher(cnes).matches()) {
            throw new IllegalArgumentException(
                    "C�digo CNES utilizado para consulta"
                            + "; TIPO: Texto; TAM: 7.");
        }

        /** Tratamento do xml para retornar o map. */
        this.conexao.requisicao(urls.get("ConsultarEquipamento"),
                montaConsultarEquipamento(cnes),
                new EquipamentoServiceParser(c));
    }

    @Override
    public void consultarEstabelecimentoCod(String cnes, Callback c) {
        if (cnes == null || c == null || cnes.length() != 7
                || REGEX_SO_NUMEROS.matcher(cnes).matches()) {
            throw new IllegalArgumentException(
                    "Código CNES utilizado para consulta"
                            + "; TIPO: Texto; TAM: 7.");
        }

        /** Tratamento do xml para retornar o map. */
        this.conexao.requisicao(urls.get("ConsultarEstabelecimentoSaude"),
                montaConsultarEstabelecimento(1, cnes),
                new EstabelecimentoSaudeServiceParser(c));
    }

    @Override
    public void consultarEstabelecimentoCnpj(String cnpj, Callback c) {
        if (cnpj == null || cnpj.length() != 14
                || REGEX_SO_NUMEROS.matcher(cnpj).matches()) {
            throw new IllegalArgumentException(
                    "Código CNES utilizado para consulta"
                            + "; TIPO: Texto; TAM: 14.");
        }

        /** Tratamento do xml para retornar o map. */
        this.conexao.requisicao(urls.get("ConsultarEstabelecimentoSaude"),
                montaConsultarEstabelecimento(2, cnpj),
                new EstabelecimentoSaudeServiceParser(c));
    }

    @Override
    public void consultarPreCadastroCNESCod(String cnes, Callback c) {
        if (cnes == null || c == null || cnes.length() != 7
                || REGEX_SO_NUMEROS.matcher(cnes).matches()) {
            throw new IllegalArgumentException(
                    "Código CNES utilizado para consulta. "
                            + "TIPO: Texto; TAM: 7.");
        }

        /** Tratamento do xml para retornar o map. */
        this.conexao.requisicao(urls.get("ConsultarEstabelecimentoSaude"),
                montaConsultarPrecadastroCNES(1, cnes),
                new EstabelecimentoSaudeServiceParser(c));
    }

    @Override
    public void consultarPreCadastroCNESSituacao(String situacao, Callback c) {
        if (situacao == null || c == null || situacao.length() != 1)
            throw new IllegalArgumentException("Situação do Pré Cadastro "
                    + "valores permitidos {A, D ou E}. "
                    + " [A=ATIVO,D=DESATIVADO, E=EXCLUIDO]"
                    + " TIPO: Texto; TAM: 1.");
        if (situacao != "A" && situacao != "D" && situacao != "E")
            throw new IllegalArgumentException("Situação do Pré Cadastro "
                    + "valores permitidos {A, D ou E}. "
                    + " [A=ATIVO,D=DESATIVADO, E=EXCLUIDO]"
                    + " TIPO: Texto; TAM: 1.");

        /** Tratamento do xml para retornar o map. */
        this.conexao.requisicao(urls.get("ConsultarEstabelecimentoSaude"),
                montaConsultarPrecadastroCNES(2, situacao),
                new EstabelecimentoSaudeServiceParser(c));
    }

    @Override
    public void localizarEstabelecimentoSaudeLocalizacao(String longitude,
            String latitude, String geoJson, String codigo, String descricao,
            Callback c) {
        if (longitude == null || latitude == null || longitude.length() > 9
                || latitude.length() > 9)
            throw new IllegalArgumentException("Logintude e Latitude passada"
                    + " nula valores inválidos.");

        /** Tratamento do xml para retornar o map. */
        this.conexao.requisicao(urls.get("ConsultarEstabelecimentoSaude"),
                montaConsultaEstabelecimentoLocalizacao(longitude, latitude,
                        geoJson, codigo, descricao, null, null, null),
                new EstabelecimentoSaudeServiceParser(c));
    }

    @Override
    public void localizarEstabelecimentoSaudePaginacao(String longitude,
            String latitude, String geoJson, String codigo, String descricao,
            String posRegistroInicio, String qtdRegistroPagina,
            String qtdRegistros, Callback c) {
        if (longitude == null || latitude == null || longitude.length() > 9
                || latitude.length() > 9)
            throw new IllegalArgumentException("Logintude e Latitude passada"
                    + " nula valores inválidos.");
        if (posRegistroInicio == null || qtdRegistroPagina == null
                || qtdRegistros == null || posRegistroInicio.length() > 7
                || qtdRegistroPagina.length() > 7 || qtdRegistros.length() > 7
                || REGEX_SO_NUMEROS.matcher(posRegistroInicio).matches()
                || REGEX_SO_NUMEROS.matcher(qtdRegistroPagina).matches()
                || REGEX_SO_NUMEROS.matcher(qtdRegistros).matches()) {
            throw new IllegalArgumentException("Posição de inicio registro "
                    + "ou quantidade de registros por página "
                    + "ou quantidade de registro "
                    + " nula valores inválidos."
                    + " Campos de tamanho máximo de 7 caracteres permitido"
                    + " somente números.");
        }

        /** Tratamento do xml para retornar o map. */
        this.conexao.requisicao(urls.get("ConsultarEstabelecimentoSaude"),
                montaConsultaEstabelecimentoLocalizacao(longitude, latitude,
                        geoJson, codigo, descricao, posRegistroInicio,
                        qtdRegistroPagina, qtdRegistros),
                new EstabelecimentoSaudeServiceParser(c));
    }

    @Override
    public void detalharVinculacaoProfissional(String cpf, Callback callback) {
        // TODO implementar metodo
    }

    @Override
    public void pesquisarVinculacaoProfissional(String cpf, Callback callback) {
        // TODO implementar metodo
    }

    @Override
    public void consultarEstabelecimentoSaude(String numeroCnes,
            Callback retorno) {
        // TODO implementar metodo
    }

    @Override
    public void consultarEstabelecimentoSaudePorMunicipio(String codigoIbge,
            Callback retorno) {
        // TODO implementar metodo
    }

    @Override
    public void consultarDadosComplementaresEstabelecimentoSaude(
            String codigoIbge, Callback retorno) {
        // TODO implementar metodo
    }

    @Override
    public void consultarProfissionalSaude(String numeroCns, Callback retorno) {
        // TODO implementar metodo
    }

    @Override
    public void consultarProfissionaisSaude(String numeroCnes,
            Callback retorno) {
        // TODO implementar metodo
    }

    /**
     * AREA PRIVADA DA CLASSE MÉTODOS AUXILIARES PARA EVITAR REPETIÇÃO DE
     * CÓDIGO.
     */
    private static final Pattern REGEX_SO_NUMEROS = Pattern.compile(".*\\D.*",
            Pattern.CASE_INSENSITIVE);

    private String EquipamentoService_codigo;

    private String EstabelecimentoSaudeService_cnpj;

    private String EstabelecimentoSaudeService_codigo;

    private String EstabelecimentoSaudeService_localizacao;

    private String ConsultarPrecadastroCNES_codigo;

    private String ConsultarPrecadastroCNES_situacao;

    /**
     * @param opcao
     *            - 1 código CNES. 2 CNPJ.
     * @param parametro
     *            a ser inserido no xml de request.
     * @return xml de request montado.
     */
    private String montaConsultarEstabelecimento(int opcao, String parametro) {
        if (opcao == 1) {
            if (EstabelecimentoSaudeService_codigo == null)
                EstabelecimentoSaudeService_codigo = buscaArquivoRequest(
                        "EstabelecimentoSaudeService_codigo.xml");

            return EstabelecimentoSaudeService_codigo.replace(
                    "<cod:codigo>?</cod:codigo>",
                    "<cod:codigo>" + parametro + "</cod:codigo>");
        } else {
            if (EstabelecimentoSaudeService_cnpj == null)
                EstabelecimentoSaudeService_cnpj = buscaArquivoRequest(
                        "EstabelecimentoSaudeService_cnpj.xml");

            return EstabelecimentoSaudeService_cnpj.replace(
                    "<cnpj:numeroCNPJ>?</cnpj:numeroCNPJ>",
                    "<cnpj:numeroCNPJ>" + parametro + "</cnpj:numeroCNPJ>");
        }
    }

    /**
     * @param longitude
     *            - Longitude.
     * @param latitude
     *            - Latitude.
     * @param geoJson
     *            - Geo json.
     * @param codigo
     *            - Codigo.
     * @param descricao
     *            - Descricao do estab.
     * @param posRegisInicio
     *            - Pos de inicio do registro.
     * @param qtdRegisPagina
     *            - Qtd de registros por pagina.
     * @param qtdRegist
     *            - Qtd total de registros.
     * @return Cabecalho da request por localizacao.
     */
    private String montaConsultaEstabelecimentoLocalizacao(String longitude,
            String latitude, String geoJson, String codigo, String descricao,
            String posRegisInicio, String qtdRegisPagina, String qtdRegist) {
        EstabelecimentoSaudeService_localizacao = buscaArquivoRequest(
                "EstabelecimentoSaudeService_localizacao.xml");
        EstabelecimentoSaudeService_localizacao.replace(
                "<loc:longitude>?</loc:longitude>",
                "<loc:longitude>" + longitude + "</loc:longitude>");
        EstabelecimentoSaudeService_localizacao.replace(
                "<loc:latitude>?</loc:latitude>",
                "<loc:latitude>" + latitude + "</loc:latitude>");
        if (geoJson != null)
            EstabelecimentoSaudeService_localizacao.replace(
                    "<loc:geoJson>?</loc:geoJson>",
                    "<loc:geoJson>" + geoJson + "</loc:geoJson>");
        if (codigo != null && descricao != null) {
            EstabelecimentoSaudeService_localizacao.replace(
                    "<tip:codigo>?</tip:codigo>",
                    "<tip:codigo>" + codigo + "</tip:codigo>");
            EstabelecimentoSaudeService_localizacao.replace(
                    "<tip:descricao>?</tip:descricao>",
                    "<tip:descricao>" + descricao + "</tip:descricao>");
        } else {
            EstabelecimentoSaudeService_localizacao
                    .replace("<tip:codigo>?</tip:codigo>", "");
            EstabelecimentoSaudeService_localizacao
                    .replace("<tip:descricao>?</tip:descricao>", "");
            EstabelecimentoSaudeService_localizacao.replace("<tip:tipoUnidade>",
                    "");
            EstabelecimentoSaudeService_localizacao
                    .replace("</tip:tipoUnidade>", "");
        }
        if (posRegisInicio != null && qtdRegisPagina != null) {
            EstabelecimentoSaudeService_localizacao.replace(
                    "<pag:posicaoRegistroInicio>?</pag:posicaoRegistroInicio>",
                    "<pag:posicaoRegistroInicio>" + posRegisInicio
                            + "</pag:posicaoRegistroInicio>");
            EstabelecimentoSaudeService_localizacao.replace(
                    "<pag:quantidadeRegistrosPorPagina>?</pag:quantidadeRegistrosPorPagina>",
                    "<pag:quantidadeRegistrosPorPagina>" + qtdRegisPagina
                            + "</pag:quantidadeRegistrosPorPagina>");

            if (qtdRegist != null)
                EstabelecimentoSaudeService_localizacao.replace(
                        "<pag:quantidadeRegistros>?</pag:quantidadeRegistros>",
                        "<pag:quantidadeRegistros>" + qtdRegist
                                + "</pag:quantidadeRegistros>");
        } else {
            EstabelecimentoSaudeService_localizacao.replace("<pag:Paginacao>",
                    "");
            EstabelecimentoSaudeService_localizacao.replace("</pag:Paginacao>",
                    "");
            EstabelecimentoSaudeService_localizacao.replace(
                    "<pag:posicaoRegistroInicio>?</pag:posicaoRegistroInicio>",
                    "");
            EstabelecimentoSaudeService_localizacao.replace(
                    "<pag:quantidadeRegistrosPorPagina>?</pag:quantidadeRegistrosPorPagina>",
                    "");
            EstabelecimentoSaudeService_localizacao.replace(
                    "<pag:quantidadeRegistros>?</pag:quantidadeRegistros>", "");
        }

        return EstabelecimentoSaudeService_localizacao;
    }

    /**
     * @param opcao
     *            - 1 código CNES. 2 situacao.
     * @param parametro
     *            a ser inserido no xml de request.
     * @return xml de request montado.
     */
    private String montaConsultarPrecadastroCNES(int opcao, String parametro) {
        if (opcao == 1) {
            if (ConsultarPrecadastroCNES_codigo == null)
                ConsultarPrecadastroCNES_codigo = buscaArquivoRequest(
                        "ConsultarPrecadastroCNES_codigo.xml");

            return ConsultarPrecadastroCNES_codigo.replace(
                    "<cod:codigo>?</cod:codigo>",
                    "<cod:codigo>" + parametro + "</cod:codigo>");
        } else {
            if (ConsultarPrecadastroCNES_situacao == null)
                ConsultarPrecadastroCNES_situacao = buscaArquivoRequest(
                        "ConsultarPrecadastroCNES_situacao.xml");

            return ConsultarPrecadastroCNES_situacao.replace(
                    "<fil:situacao>?</fil:situacao>",
                    "<fil:situacao>" + parametro + "</fil:situacao>");
        }
    }

    /**
     * @param opcao
     *            - 1 código CNES
     * @param parametro
     *            a ser inserido no xml de request.
     * @return xml de request montado.
     */
    private String montaConsultarEquipamento(String parametro) {
        if (EquipamentoService_codigo == null)
            EquipamentoService_codigo = buscaArquivoRequest(
                    "EquipamentoService_codigo.xml");

        return EquipamentoService_codigo.replace("<cod:codigo>?</cod:codigo>",
                "<cod:codigo>" + parametro + "</cod:codigo>");
    }

    /**
     * @param nomeArquivo
     *            - Nome do xml na pasta resources do projeto.
     * @return XML do arquivo.
     */
    private String buscaArquivoRequest(String nomeArquivo) {
        try {
            return Files
                    .readAllLines(Paths.get(
                            ClassLoader.getSystemResource(nomeArquivo).toURI()))
                    .stream().collect(Collectors.joining());
        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao ler arquivo " + nomeArquivo + ". BarramentoCNES");
        }
    }
}
