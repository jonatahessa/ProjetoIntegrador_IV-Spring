/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Classes;

/**
 *
 * @author joliveira
 */
public class Endereco {
    
    private Integer codigoEndereco;
    private String tipoLogradouroEndereco;
    private String logradouroEndereco;
    private String numeroEndereco;
    private String complementoEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;
    private String estadoEndereco;
    private String paisEndereco;
    private Cliente clienteEndereco;

    public Endereco() {
    }

    public Endereco(Integer codigoEndereco, String tipoLogradouroEndereco, String logradouroEndereco, String numeroEndereco, String complementoEndereco, String bairroEndereco, String cidadeEndereco, String estadoEndereco, String paisEndereco, Cliente clienteEndereco) {
        this.codigoEndereco = codigoEndereco;
        this.tipoLogradouroEndereco = tipoLogradouroEndereco;
        this.logradouroEndereco = logradouroEndereco;
        this.numeroEndereco = numeroEndereco;
        this.complementoEndereco = complementoEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.estadoEndereco = estadoEndereco;
        this.paisEndereco = paisEndereco;
        this.clienteEndereco = clienteEndereco;
    }

    public Integer getCodigoEndereco() {
        return codigoEndereco;
    }

    public void setCodigoEndereco(Integer codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }

    public String getTipoLogradouroEndereco() {
        return tipoLogradouroEndereco;
    }

    public void setTipoLogradouroEndereco(String tipoLogradouroEndereco) {
        this.tipoLogradouroEndereco = tipoLogradouroEndereco;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getEstadoEndereco() {
        return estadoEndereco;
    }

    public void setEstadoEndereco(String estadoEndereco) {
        this.estadoEndereco = estadoEndereco;
    }

    public String getPaisEndereco() {
        return paisEndereco;
    }

    public void setPaisEndereco(String paisEndereco) {
        this.paisEndereco = paisEndereco;
    }

    public Cliente getClienteEndereco() {
        return clienteEndereco;
    }

    public void setClienteEndereco(Cliente clienteEndereco) {
        this.clienteEndereco = clienteEndereco;
    }
    
}
