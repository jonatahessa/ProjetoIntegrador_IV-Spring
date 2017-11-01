/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.entity;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "TB_TELEFONE")
public class Telefone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TELEFONE")
    private Integer codigoTelefone;
    
    @Size(min = 3, max = 3, message = "{telefone.dddTelefone.erro}")
    @Column(name = "CA_ENDERECO", length = 3, nullable = false)
    private String dddTelefone;
    
    @Size(min = 8, max = 9, message = "{telefone.telefone.erro}")
    @Column(name = "NM_TELEFONE", length = 9, nullable = false)
    private String numeroTelefone;
    
    
    @ManyToMany(mappedBy = "telefones")
    private List<Cliente> clientes;

    public Telefone() {
    }

    public Telefone(Integer codigoTelefone, String dddTelefone, String numeroTelefone, List<Cliente> clientes) {
        this.codigoTelefone = codigoTelefone;
        this.dddTelefone = dddTelefone;
        this.numeroTelefone = numeroTelefone;
        this.clientes = clientes;
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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
