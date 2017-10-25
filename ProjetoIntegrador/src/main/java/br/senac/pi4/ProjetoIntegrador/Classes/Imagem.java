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
public class Imagem {

    private Integer codigoImagem;
    private String nomeImagem;
    private String legendaImagem;
    private Produto produto;

    public Imagem() {

    }

    public Imagem(Integer codigoImagem, String nomeImagem, String legendaImagem) {
        this.codigoImagem = codigoImagem;
        this.nomeImagem = nomeImagem;
        this.legendaImagem = legendaImagem;
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
