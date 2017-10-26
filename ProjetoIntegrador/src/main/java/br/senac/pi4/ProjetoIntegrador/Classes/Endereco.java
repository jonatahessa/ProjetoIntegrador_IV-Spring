/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Classes;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author joliveira
 */
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENDERECO")
    private Integer codigoEndereco;
    
    @Size(min = 1, max = 50, message = "{endereco.tipoLogradouro.erro}")
    @Column(name = "TL_ENDERECO", length = 50, nullable = false)
    private String tipoLogradouroEndereco;
    
    @Size(min = 1, max = 500, message = "{endereco.logradouro.erro}")
    @Column(name = "LO_ENDERECO", length = 100, nullable = false)
    private String logradouroEndereco;
    
    @Size(min = 1, max = 11, message = "{endereco.numero.erro}")
    @Column(name = "NU_ENDERECO", length = 100, nullable = false)
    private String numeroEndereco;
    
    @Size(min = 1, max = 100, message = "{endereco.complemento.erro}")
    @Column(name = "CP_ENDERECO", length = 100, nullable = true)
    private String complementoEndereco;
    
    @Size(min = 1, max = 100, message = "{endereco.beirro.erro}")
    @Column(name = "BR_ENDERECO", length = 100, nullable = false)
    private String bairroEndereco;
    
    @Size(min = 1, max = 100, message = "{endereco.cidade.erro}")
    @Column(name = "CD_ENDERECO", length = 100, nullable = false)
    private String cidadeEndereco;
    
    @Size(min = 1, max = 2, message = "{endereco.estado.erro}")
    @Column(name = "ES_ENDERECO", length = 2, nullable = false)
    private String estadoEndereco;
    
    @Size(min = 1, max = 100, message = "{endereco.pais.erro}")
    @Column(name = "PA_ENDERECO", length = 100, nullable = false)
    private String paisEndereco;
    
    @ManyToMany(mappedBy = "enderecos")
    private Set<Cliente> clientes;

    public Endereco() {
    }

    public Endereco(Integer codigoEndereco, String tipoLogradouroEndereco, String logradouroEndereco, String numeroEndereco, String complementoEndereco, String bairroEndereco, String cidadeEndereco, String estadoEndereco, String paisEndereco, Set<Cliente> clientes) {
        this.codigoEndereco = codigoEndereco;
        this.tipoLogradouroEndereco = tipoLogradouroEndereco;
        this.logradouroEndereco = logradouroEndereco;
        this.numeroEndereco = numeroEndereco;
        this.complementoEndereco = complementoEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.estadoEndereco = estadoEndereco;
        this.paisEndereco = paisEndereco;
        this.clientes = clientes;
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

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}
