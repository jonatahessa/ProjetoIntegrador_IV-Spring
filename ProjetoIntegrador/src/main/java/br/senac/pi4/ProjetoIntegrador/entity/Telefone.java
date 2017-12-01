/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author thales.dsouza
 */
@Entity
@Table(name = "TB_TELEFONE")
public class Telefone implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TELEFONE")
    private Long codigoTelefone;
    
    @Size(min = 1, max = 3, message = "{telefone.ddd.erro}")
    @Column(name = "DD_TELEFONE", length = 3, nullable = false)
    private String ddd;
    
    @Size(min = 9, max = 10, message = "{telefone.numeroTelefone.erro}")
    @Column(name = "NM_TELEFONE", length = 3, nullable = false)
    private String numeroTelefone;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente clienteTelefone;

    public Telefone(Long codigoTelefone, String ddd, String numeroTelefone, Cliente clienteTelefone) {
        this.codigoTelefone = codigoTelefone;
        this.ddd = ddd;
        this.numeroTelefone = numeroTelefone;
        this.clienteTelefone = clienteTelefone;
    }

    public Long getCodigoTelefone() {
        return codigoTelefone;
    }

    public void setCodigoTelefone(Long codigoTelefone) {
        this.codigoTelefone = codigoTelefone;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Cliente getClienteTelefone() {
        return clienteTelefone;
    }

    public void setClienteTelefone(Cliente clienteTelefone) {
        this.clienteTelefone = clienteTelefone;
    }
    
    
}
