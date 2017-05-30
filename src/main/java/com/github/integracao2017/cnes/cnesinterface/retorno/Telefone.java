package com.github.integracao2017.cnes.cnesinterface.retorno;

/**
 * @author gabriel
 * @version 1.0.0
 *
 * Classe para representar telefone visto que
 * o retorno pode conter um ou mais telefones
 * esta se faz necessaria para conter os atributos de
 * telefone.
 */
public class Telefone extends Retorno {

    private String codTipoTelefone;

    private String descTipoTelefone;

    private String ddiTelefone;

    private String ddTelefone;

    private String numTelefone;

    public String getCodTipoTelefone() {
        return codTipoTelefone;
    }

    public void setCodTipoTelefone(String codTipoTelefone) {
        this.codTipoTelefone = codTipoTelefone;
    }

    public String getDescTipoTelefone() {
        return descTipoTelefone;
    }

    public void setDescTipoTelefone(String descTipoTelefone) {
        this.descTipoTelefone = descTipoTelefone;
    }

    public String getDdiTelefone() {
        return ddiTelefone;
    }

    public void setDdiTelefone(String ddiTelefone) {
        this.ddiTelefone = ddiTelefone;
    }
    public String getDdTelefone() {
        return ddTelefone;
    }

    public void setDdTelefone(String ddTelefone) {
        this.ddTelefone = ddTelefone;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }
}
