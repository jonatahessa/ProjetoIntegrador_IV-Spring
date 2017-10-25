/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Classes;

import java.util.Set;

/**
 *
 * @author joliveira
 */
public class Categoria {

    private long codigoCategoria;
    private String nomeCategoria;
    private Set<Produto> produtos;

    public Categoria() {
    }

    public Categoria(long codigoCategoria, String nomeCategoria, Set<Produto> produtos) {
        this.codigoCategoria = codigoCategoria;
        this.nomeCategoria = nomeCategoria;
        this.produtos = produtos;
    }

    public long getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(long codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}
