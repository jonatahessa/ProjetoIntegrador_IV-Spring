/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.entity;

import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jonat
 */
public class Pedido {
    
    private Integer codigoPedido;
    
    private List<Produto> produtosPedido;
    
    private Cliente clientePedido;
    
    private Date dataPedido;
}
