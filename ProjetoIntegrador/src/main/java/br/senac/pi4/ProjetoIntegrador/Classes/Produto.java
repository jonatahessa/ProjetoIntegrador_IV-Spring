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

    private long codigoProduto;
    private int quantEstoqueProduto;
    private int avalicaçãoProduto;
    private String marcaProduto;
    private String modeloProduto;
    private String corProduto;
    private char generoProduto;
    private char tamanhoProduto;
    private boolean statusEstoqueProduto;
    private String lenteCorProduto;
    private String lenteTipoProduto;
    private String descricaoProduto;
    // Decidir como irá guardar
    private String[] imagemProduto;
    private String altImagemProduto;
    private BigDecimal precoProduto;
    private boolean promocaoProduto;
    private BigDecimal porcentagemPromocaoProduto;
    private double alturaProduto;
    private double larguraProduto;
    private double comprimentoProduto;
    private double pesoProduto;

    public long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantEstoqueProduto() {
        return quantEstoqueProduto;
    }

    public void setQuantEstoqueProduto(int quantEstoqueProduto) {
        this.quantEstoqueProduto = quantEstoqueProduto;
    }

    public int getAvalicaçãoProduto() {
        return avalicaçãoProduto;
    }

    public void setAvalicaçãoProduto(int avalicaçãoProduto) {
        this.avalicaçãoProduto = avalicaçãoProduto;
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

    public boolean isStatusEstoqueProduto() {
        return statusEstoqueProduto;
    }

    public void setStatusEstoqueProduto(boolean statusEstoqueProduto) {
        this.statusEstoqueProduto = statusEstoqueProduto;
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

    public String[] getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String[] imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public String getAltImagemProduto() {
        return altImagemProduto;
    }

    public void setAltImagemProduto(String altImagemProduto) {
        this.altImagemProduto = altImagemProduto;
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

    public Produto(long codigoProduto, int quantEstoqueProduto, int avalicaçãoProduto, String marcaProduto, String modeloProduto, String corProduto, char generoProduto, char tamanhoProduto, boolean statusEstoqueProduto, String lenteCorProduto, String lenteTipoProduto, String descricaoProduto, String[] imagemProduto, String altImagemProduto, BigDecimal precoProduto, boolean promocaoProduto, BigDecimal porcentagemPromocaoProduto, double alturaProduto, double larguraProduto, double comprimentoProduto, double pesoProduto) {
        this.codigoProduto = codigoProduto;
        this.quantEstoqueProduto = quantEstoqueProduto;
        this.avalicaçãoProduto = avalicaçãoProduto;
        this.marcaProduto = marcaProduto;
        this.modeloProduto = modeloProduto;
        this.corProduto = corProduto;
        this.generoProduto = generoProduto;
        this.tamanhoProduto = tamanhoProduto;
        this.statusEstoqueProduto = statusEstoqueProduto;
        this.lenteCorProduto = lenteCorProduto;
        this.lenteTipoProduto = lenteTipoProduto;
        this.descricaoProduto = descricaoProduto;
        this.imagemProduto = imagemProduto;
        this.altImagemProduto = altImagemProduto;
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
