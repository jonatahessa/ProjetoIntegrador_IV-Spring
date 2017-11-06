/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.entity;

import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 *
 * @author jonat
 */
@Entity
@Table(name = "TB_PEDIDO")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Integer codigoPedido;

    @ManyToMany
    @JoinTable(name = "TB_PRODUTO_PEDIDO",
            joinColumns = {
                @JoinColumn(name = "ID_PRODUTO")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "ID_PEDIDO")
            })
    private List<Produto> produtos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente clientePedido;

    @Column(name = "DT_PEDIDO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPedido;

    @Column(name = "DE_PEDIDO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @Size(min = 1, max = 100, message = "{pedido.statusPedido.erro}")
    @Column(name = "ST_PEDIDO", length = 100, nullable = false)
    private String statusPedido;

    @Digits(integer = 6, fraction = 2, message = "{pedido.valorPedido.erro}")
    @Column(name = "VL_PEDIDO", precision = 6, scale = 2, nullable = false)
    private BigDecimal valorPedido;

    @Size(min = 1, max = 50, message = "{pedido.formaPagamentoPedido.erro}")
    @Column(name = "FP_PEDIDO", length = 100, nullable = false)
    private String formaPagamentoPedido;

    public Pedido() {
    }

    public Pedido(Integer codigoPedido, List<Produto> produtos, Cliente clientePedido, Date dataPedido, Date dataEntrega, String statusPedido, BigDecimal valorPedido, String formaPagamentoPedido) {
        this.codigoPedido = codigoPedido;
        this.produtos = produtos;
        this.clientePedido = clientePedido;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.statusPedido = statusPedido;
        this.valorPedido = valorPedido;
        this.formaPagamentoPedido = formaPagamentoPedido;
    }

    public Integer getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getClientePedido() {
        return clientePedido;
    }

    public void setClientePedido(Cliente clientePedido) {
        this.clientePedido = clientePedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(BigDecimal valorPedido) {
        this.valorPedido = valorPedido;
    }

    public String getFormaPagamentoPedido() {
        return formaPagamentoPedido;
    }

    public void setFormaPagamentoPedido(String formaPagamentoPedido) {
        this.formaPagamentoPedido = formaPagamentoPedido;
    }
}
