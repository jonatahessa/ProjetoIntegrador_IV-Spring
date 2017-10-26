/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Classes;

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
    
    @Size(min = 1, max = 50, message = "{cliente.primeiroNome.erro}")
    @Column(name = "PN_CLIENTE", length = 50, nullable = false)
    private String primeiroNomeCliente;
    
    @Size(min = 1, max = 200, message = "{cliente.sobrenome.erro}")
    @Column(name = "SN_CLIENTE", length = 200, nullable = false)
    private String sobrenomeCliente;
    
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
