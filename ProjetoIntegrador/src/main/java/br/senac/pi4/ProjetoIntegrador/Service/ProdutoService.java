/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Service;

import br.senac.pi4.ProjetoIntegrador.Models.Categoria;
import br.senac.pi4.ProjetoIntegrador.Models.Produto;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface ProdutoService extends Serializable {
    
    public List<Produto> listar(int offset, int quantidade);
    
    public List<Produto> listarPorCategoria(Categoria categoria, int offset, int quantidade);
    
    public Produto obter(Integer codigoProduto);
    
    public void incluir(Produto produto);
    
    public void alterar(Produto produto);
    
    public void remover(Integer codigoProduto);
}
