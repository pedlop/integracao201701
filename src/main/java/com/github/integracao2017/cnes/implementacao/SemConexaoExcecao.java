package com.github.integracao2017.cnes.implementacao;

/**
 * @author gabriel
 * @version 1.0.0
 *
 * Excecao padrao para ser lancada em caso
 * de alguma falha ao realizar algum request.
 */
public class SemConexaoExcecao extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**Messagem para usuario do component.*/
    public SemConexaoExcecao(String msg) {
        super(msg);
    }
}
