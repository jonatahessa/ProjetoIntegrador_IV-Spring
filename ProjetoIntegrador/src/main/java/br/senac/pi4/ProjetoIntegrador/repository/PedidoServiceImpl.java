/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.repository;

import br.senac.pi4.ProjetoIntegrador.Service.PedidoService;
import br.senac.pi4.ProjetoIntegrador.entity.Pedido;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thales.dsouza
 */
@Repository
public class PedidoServiceImpl implements PedidoService{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private PedidoRepository repo;
    
    @Override
    public List<Pedido> listar(int offset, int quantidade) {
        Iterable<Pedido> pedidos = repo.findAll();
        Iterator it = pedidos.iterator();
        List<Pedido> lista = new ArrayList<Pedido>();
        while (it.hasNext()) {
            Pedido p = (Pedido) it.next();
            lista.add(p);
        }
        return lista;
    }
    
    @Override
    public Pedido obter(Long codigoPedido) {
        return repo.findOne(codigoPedido);
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

    @Override
    @Transactional
    public void alterar(Pedido pedido) {
        entityManager.merge(pedido);
    } 
}
