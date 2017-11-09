/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Service;

import br.senac.pi4.ProjetoIntegrador.entity.Pedido;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author thales.dsouza
 */
public interface PedidoService extends Serializable {
    
    public List<Pedido> listar(int offset, int quantidade);
       
    public Pedido obter(Integer codigoPedido);
    
    public void incluir(Pedido pedido);
    
}

