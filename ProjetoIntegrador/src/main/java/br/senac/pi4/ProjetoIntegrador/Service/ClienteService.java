/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Service;

import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface ClienteService extends Serializable {
    
    public List<Cliente> listar(int offset);
    
    public Cliente obter(Long codigoCliente);
    
    public void incluir(Cliente cliente);
    
    public void alterar(Cliente cliente);
    
    public void remover(Long codigoCliente);
}
