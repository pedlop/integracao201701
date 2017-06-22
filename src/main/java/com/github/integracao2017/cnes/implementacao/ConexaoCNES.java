package com.github.integracao2017.cnes.implementacao;


import com.github.integracao2017.cnes.cnesinterface.Conexao;
import com.github.integracao2017.cnes.implementacao.SemConexaoExcecao;
import okhttp3.*;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * @author  gabriel
 * @version 1.0.0
 *
 * Classe com o objetivo de prover os metodos
 * para realizarem as requisicoes ao web service.
 */
public class ConexaoCNES implements Conexao {

    private final OkHttpClient cliente = new OkHttpClient();

   /**@param content - Corpo da interface.*/
    public void requisicao(String url, String  content, final Consumer<String> consumer) {
       MediaType XML = MediaType.parse("text/xml;charset=UTF-8");
       RequestBody requestBody = RequestBody.create(XML, content);
       Request request = new Request.Builder()
                                 .url(url)
                                 .post(requestBody)
                                 .build();


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
