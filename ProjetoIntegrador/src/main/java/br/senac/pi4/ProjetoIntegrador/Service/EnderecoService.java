/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Service;

import br.senac.pi4.ProjetoIntegrador.Models.Endereco;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface EnderecoService extends Serializable {
    
    public List<Endereco> listar(int offset, int quantidade);
    
    public List<Endereco> listarPorCategoria(Endereco endereco, int offset, int quantidade);
    
    public Endereco obter(Integer codigoEndereco);
    
    public void incluir(Endereco produto);
    
    public void alterar(Endereco produto);
    
    public void remover(Integer codigoEndereco);
}

