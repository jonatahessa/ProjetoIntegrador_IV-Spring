/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Classes;

import java.math.BigDecimal;

/**
 *
 * @author joliveira
 */
public class Produto {

    private Integer codigoProduto;
    private String tituloProduto;
    private int quantEstoqueProduto;
    private int avaliacaoProduto;
    private String marcaProduto;
    private String modeloProduto;
    private String corProduto;
    private char generoProduto;
    private char tamanhoProduto;
    private String lenteCorProduto;
    private String lenteTipoProduto;
    private String descricaoProduto;
    // Decidir como irá guardar
    private BigDecimal precoProduto;
    private boolean promocaoProduto;
    private BigDecimal porcentagemPromocaoProduto;
    private double alturaProduto;
    private double larguraProduto;
    private double comprimentoProduto;
    private double pesoProduto;

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getTituloProduto() {
        return tituloProduto;
    }

    public void setTituloProduto(String tituloProduto) {
        this.tituloProduto = tituloProduto;
    }
    
    public int getQuantEstoqueProduto() {
        return quantEstoqueProduto;
    }

    public void setQuantEstoqueProduto(int quantEstoqueProduto) {
        this.quantEstoqueProduto = quantEstoqueProduto;
    }

    public int getAvaliacaoProduto() {
        return avaliacaoProduto;
    }

    public void setAvalicaçãoProduto(int avaliacaoProduto) {
        this.avaliacaoProduto = avaliacaoProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public String getModeloProduto() {
        return modeloProduto;
    }

    public void setModeloProduto(String modeloProduto) {
        this.modeloProduto = modeloProduto;
    }

    public String getCorProduto() {
        return corProduto;
    }

    public void setCorProduto(String corProduto) {
        this.corProduto = corProduto;
    }

    public char getGeneroProduto() {
        return generoProduto;
    }

    public void setGeneroProduto(char generoProduto) {
        this.generoProduto = generoProduto;
    }

    public char getTamanhoProduto() {
        return tamanhoProduto;
    }

    public void setTamanhoProduto(char tamanhoProduto) {
        this.tamanhoProduto = tamanhoProduto;
    }

    public String getLenteCorProduto() {
        return lenteCorProduto;
    }

    public void setLenteCorProduto(String lenteCorProduto) {
        this.lenteCorProduto = lenteCorProduto;
    }

    public String getLenteTipoProduto() {
        return lenteTipoProduto;
    }

    public void setLenteTipoProduto(String lenteTipoProduto) {
        this.lenteTipoProduto = lenteTipoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(BigDecimal precoProduto) {
        this.precoProduto = precoProduto;
    }

    public boolean isPromocaoProduto() {
        return promocaoProduto;
    }

    public void setPromocaoProduto(boolean promocaoProduto) {
        this.promocaoProduto = promocaoProduto;
    }

    public BigDecimal getPorcentagemPromocaoProduto() {
        return porcentagemPromocaoProduto;
    }

    public void setPorcentagemPromocaoProduto(BigDecimal porcentagemPromocaoProduto) {
        this.porcentagemPromocaoProduto = porcentagemPromocaoProduto;
    }

    public double getAlturaProduto() {
        return alturaProduto;
    }

    public void setAlturaProduto(double alturaProduto) {
        this.alturaProduto = alturaProduto;
    }

    public double getLarguraProduto() {
        return larguraProduto;
    }

    public void setLarguraProduto(double larguraProduto) {
        this.larguraProduto = larguraProduto;
    }

    public double getComprimentoProduto() {
        return comprimentoProduto;
    }

    public void setComprimentoProduto(double comprimentoProduto) {
        this.comprimentoProduto = comprimentoProduto;
    }

    public double getPesoProduto() {
        return pesoProduto;
    }

    public void setPesoProduto(double pesoProduto) {
        this.pesoProduto = pesoProduto;
    }

    public Produto(Integer codigoProduto, int quantEstoqueProduto, int avaliacaoProduto, String marcaProduto, String modeloProduto, String corProduto, char generoProduto, char tamanhoProduto, String lenteCorProduto, String lenteTipoProduto, String descricaoProduto, BigDecimal precoProduto, boolean promocaoProduto, BigDecimal porcentagemPromocaoProduto, double alturaProduto, double larguraProduto, double comprimentoProduto, double pesoProduto) {
        this.codigoProduto = codigoProduto;
        this.quantEstoqueProduto = quantEstoqueProduto;
        this.avaliacaoProduto = avaliacaoProduto;
        this.marcaProduto = marcaProduto;
        this.modeloProduto = modeloProduto;
        this.corProduto = corProduto;
        this.generoProduto = generoProduto;
        this.tamanhoProduto = tamanhoProduto;
        this.lenteCorProduto = lenteCorProduto;
        this.lenteTipoProduto = lenteTipoProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.promocaoProduto = promocaoProduto;
        this.porcentagemPromocaoProduto = porcentagemPromocaoProduto;
        this.alturaProduto = alturaProduto;
        this.larguraProduto = larguraProduto;
        this.comprimentoProduto = comprimentoProduto;
        this.pesoProduto = pesoProduto;
    }

    public Produto() {
    }

}
