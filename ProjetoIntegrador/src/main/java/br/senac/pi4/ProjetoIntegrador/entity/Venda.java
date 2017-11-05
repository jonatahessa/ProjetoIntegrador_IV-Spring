/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.entity;

import br.senac.pi4.ProjetoIntegrador.entity.Pedido;
import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import br.senac.pi4.ProjetoIntegrador.entity.Endereco;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jonat
 */
public class Venda {
    
    private Integer codigoVenda;
    
    private Date dataVenda;
    
    private List<Produto> produtosVenda;
    
    private Cliente clienteVenda;
    
    private Endereco enderecoVenda;
    
    private Pedido pedidoVenda;
}
