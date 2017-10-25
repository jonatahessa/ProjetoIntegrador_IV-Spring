/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Classes;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author joliveira
 */
public class Cliente {
    
    private Integer codigoCliente;
    private String primeiroNomeCliente;
    private String sobrenomeCliente;
    private String emailCliente;
    private String senhaCliente;
    private String cpfCliente;
    private Date nascCliente;
    private List<Telefone> telefones;
    private Set<Endereco> endereco;

    public Cliente() {
    }

    public Cliente(Integer codigoCliente, String primeiroNomeCliente, String sobrenomeCliente, String emailCliente, String senhaCliente, String cpfCliente, Date nascCliente, List<Telefone> telefones, Set<Endereco> endereco) {
        this.codigoCliente = codigoCliente;
        this.primeiroNomeCliente = primeiroNomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.cpfCliente = cpfCliente;
        this.nascCliente = nascCliente;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getPrimeiroNomeCliente() {
        return primeiroNomeCliente;
    }

    public void setPrimeiroNomeCliente(String primeiroNomeCliente) {
        this.primeiroNomeCliente = primeiroNomeCliente;
    }

    public String getSobrenomeCliente() {
        return sobrenomeCliente;
    }

    public void setSobrenomeCliente(String sobrenomeCliente) {
        this.sobrenomeCliente = sobrenomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Date getNascCliente() {
        return nascCliente;
    }

    public void setNascCliente(Date nascCliente) {
        this.nascCliente = nascCliente;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Set<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(Set<Endereco> endereco) {
        this.endereco = endereco;
    }
}
