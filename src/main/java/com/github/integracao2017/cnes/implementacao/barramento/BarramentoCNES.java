package com.github.integracao2017.cnes.implementacao.barramento;


import com.github.integracao2017.cnes.implementacao.SemConexaoExcecao;
import okhttp3.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Consumer;

/**
 * @author  gabriel
 * @version 1.0.0
 *
 * Classe com o objetivo de prover os metodos
 * para realizarem as requisicoes ao web service.
 */
public class BarramentoCNES {

    /**<true>Ambiente de producao.</>
     * <false>Ambiente de homogacao.</>*/
    private boolean producao;

    /**Instancia do barramento com as URL(s).*/
    private UrlCNES urls;

    private final OkHttpClient cliente = new OkHttpClient();

    private Request request;

    /**@param producaoP - Indica se producao ou homologacao.
     * @param urlsP - Instancia com as url(s)
     * */
    public BarramentoCNES(boolean producaoP, UrlCNES urlsP) {
        producao   = producaoP;
        urls = urlsP;
    }

    /**@return Url do servico conforme passada no construtor.*/
    private URL getUrl() throws MalformedURLException {
        return new URL(producao == true ? urls.urlProducao() : urls.urlHomologacao());
    }

    /**@param content - Corpo da interface.*/
    public void requisicao(String  content, final Consumer<String> consumer) {
        try {

            MediaType XML = MediaType.parse("text/xml;charset=UTF-8");
            RequestBody requestBody = RequestBody.create(XML, content);
            request = new Request.Builder()
                                 .url(getUrl())
                                 .post(requestBody)
                                 .build();
        } catch( MalformedURLException e) {
            e.printStackTrace();
            throw new SemConexaoExcecao("Erro na url do request." + request.url());
        }

        cliente.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                throw new SemConexaoExcecao("Erro ao realizar a request." + request.url());
            }

            public void onResponse(Call call, Response response) throws IOException {
               consumer.accept(response.body().string());
            }
        });
    }
}
