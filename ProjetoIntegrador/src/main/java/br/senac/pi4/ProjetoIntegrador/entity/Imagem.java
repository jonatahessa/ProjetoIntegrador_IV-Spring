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
import javax.validation.constraints.Digits;

public class Imagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_IMAGEM")
    private Integer codigoImagem;
    
    @Column(name = "NM_IMAGEM", length = 100, nullable = false)
    private String nomeImagem;
    
    @Column(name = "DS_IMAGEM", length = 100)
    private String legendaImagem;
    
    @Digits(integer = 11, fraction = 0, message = "{imagem.sequenciaImagem.erro}")
    @Column(name = "SQ_IMAGEM", nullable = false)
    private Integer sequenciaImagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUTO", nullable = false)
    private Produto produto;

    public Imagem() {

    }

    public Imagem(Integer codigoImagem, String nomeImagem, String legendaImagem, Integer sequenciaImagem, Produto produto) {
        this.codigoImagem = codigoImagem;
        this.nomeImagem = nomeImagem;
        this.legendaImagem = legendaImagem;
        this.sequenciaImagem = sequenciaImagem;
        this.produto = produto;
    }

    public Integer getSequenciaImagem() {
        return sequenciaImagem;
    }

    public void setSequenciaImagem(Integer sequenciaImagem) {
        this.sequenciaImagem = sequenciaImagem;
    }

    public Integer getCodigoImagem() {
        return codigoImagem;
    }

    public void setCodigoImagem(Integer codigoImagem) {
        this.codigoImagem = codigoImagem;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public String getLegendaImagem() {
        return legendaImagem;
    }

    public void setLegendaImagem(String legendaImagem) {
        this.legendaImagem = legendaImagem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
