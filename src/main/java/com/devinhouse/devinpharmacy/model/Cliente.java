package com.devinhouse.devinpharmacy.model;

import java.util.Date;

public class Cliente {

    private String contatoEmergencia;
    private String listaAlergias;
    private String convenio;
    private String numeroCarteiraConvenio;
    private Date validadeCarteiraConvenio;


    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getListaAlergias() {
        return listaAlergias;
    }

    public void setListaAlergias(String listaAlergias) {
        this.listaAlergias = listaAlergias;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getNumeroCarteiraConvenio() {
        return numeroCarteiraConvenio;
    }

    public void setNumeroCarteiraConvenio(String numeroCarteiraConvenio) {
        this.numeroCarteiraConvenio = numeroCarteiraConvenio;
    }

    public Date getValidadeCarteiraConvenio() {
        return validadeCarteiraConvenio;
    }

    public void setValidadeCarteiraConvenio(Date validadeCarteiraConvenio) {
        this.validadeCarteiraConvenio = validadeCarteiraConvenio;
    }


}
