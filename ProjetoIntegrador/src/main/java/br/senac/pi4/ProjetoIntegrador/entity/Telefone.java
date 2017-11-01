/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.entity;

/**
 *
 * @author joliveira
 */
public class Telefone {
    
    private Integer codigoTelefone;
    private String dddTelefone;
    private String numeroTelefone;
    private Cliente cliente;

    public Telefone() {
    }

    public Telefone(Integer codigoTelefone, String dddTelefone, String numeroTelefone, Cliente cliente) {
        this.codigoTelefone = codigoTelefone;
        this.dddTelefone = dddTelefone;
        this.numeroTelefone = numeroTelefone;
        this.cliente = cliente;
    }

    public Integer getCodigoTelefone() {
        return codigoTelefone;
    }

    public void setCodigoTelefone(Integer codigoTelefone) {
        this.codigoTelefone = codigoTelefone;
    }

    public String getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(String dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
