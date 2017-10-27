/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author joliveira
 */
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Integer codigoCliente;

    @Size(min = 1, max = 100, message = "{produto.email.erro}")
    @Column(name = "EM_CLIENTE", length = 100, nullable = false)
    private String emailCliente;

    @Size(min = 1, max = 100, message = "{produto.senha.erro}")
    @Column(name = "TL_PRODUTO", length = 100, nullable = false)
    private String senhaCliente;

    @Size(min = 1, max = 11, message = "{produto.cpf.erro}")
    @Column(name = "TL_PRODUTO", length = 11, nullable = false)
    private String cpfCliente;

    @Column(name = "NS_CLIENTE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date nascCliente;

    private String nomeCompletoCliente;

    private char sexoCliente;

    private String apelidoCliente;

    @ManyToMany
    @JoinTable(name = "TB_CLIENTE_TELEFONE",
            joinColumns = {
                @JoinColumn(name = "ID_CLIENTE")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "ID_TELEFONE")
            })
    private List<Telefone> telefones;

    @ManyToMany
    @JoinTable(name = "TB_CLIENTE_ENDERECO",
            joinColumns = {
                @JoinColumn(name = "ID_CLIENTE")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "ID_ENDERECO")
            })
    private Set<Endereco> endereco;

    public Cliente() {
    }

    public Cliente(Integer codigoCliente, String emailCliente, String senhaCliente, String cpfCliente, Date nascCliente, String nomeCompletoCliente, char sexoCliente, String apelidoCliente, List<Telefone> telefones, Set<Endereco> endereco) {
        this.codigoCliente = codigoCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.cpfCliente = cpfCliente;
        this.nascCliente = nascCliente;
        this.nomeCompletoCliente = nomeCompletoCliente;
        this.sexoCliente = sexoCliente;
        this.apelidoCliente = apelidoCliente;
        this.telefones = telefones;
        this.endereco = endereco;
    }
    
    public String getNomeCompletoCliente() {
        return nomeCompletoCliente;
    }

    public void setNomeCompletoCliente(String nomeCompletoCliente) {
        this.nomeCompletoCliente = nomeCompletoCliente;
    }

    public char getSexoCliente() {
        return sexoCliente;
    }

    public void setSexoCliente(char sexoCliente) {
        this.sexoCliente = sexoCliente;
    }
    
    public String getApelidoCliente() {
        return apelidoCliente;
    }

    public void setApelidoCliente(String apelidoCliente) {
        this.apelidoCliente = apelidoCliente;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
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
