package com.github.integracao2017.cnes.implementacao;

/**
 * @author gabriel
 * @version 1.0.0
 *
 * Classe para lancar excecoes de possiveis parametros passados de maneira
 * errada.
 */
public class ParametroError extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**Messagem para usuario do component
     * indicando paramertro com erro.*/
    public ParametroError(String exc) { super(exc);}

}
