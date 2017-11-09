/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.repository;

import br.senac.pi4.ProjetoIntegrador.Service.PedidoService;
import br.senac.pi4.ProjetoIntegrador.entity.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author thales.dsouza
 */
public class PedidoServiceImpl implements PedidoService{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Pedido> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery("SELECT * from tb_pedido");
        return query.getResultList();
    }
    
    @Override
    public Pedido obter(Integer codigoPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void incluir(Pedido pedido) {
        throw new UnsupportedOperationException("INSERT INTO tb_pedido (de_pedido, dt_pedido, fp_pedido, st_pedido, vl_pedido, id_cliente)"
                + "VALUES (" + pedido.getDataEntrega() + ","
                             + pedido.getDataPedido() + ","
                             + pedido.getFormaPagamentoPedido() + ","
                             + pedido.getStatusPedido() + ","
                             + pedido.getValorPedido() + ","
                             + pedido.getClientePedido() + ");"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
