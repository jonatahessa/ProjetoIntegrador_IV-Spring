package br.senac.pi4.ProjetoIntegrador.repository;

import br.senac.pi4.ProjetoIntegrador.Service.ProdutoService;
import br.senac.pi4.ProjetoIntegrador.entity.Categoria;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repo;
   
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Produto> listar(int offset, int quantidade) {
        Iterable<Produto> produtos = repo.findAll();
        Iterator it = produtos.iterator();
        List<Produto> lista = new ArrayList<Produto>();
        while (it.hasNext()) {
            Produto p = (Produto) it.next();
            lista.add(p);
        }
        return lista;
    }

//     @PersistenceContext
//    private EntityManager entityManager;
//    
//    @Override
//    public List<Produto> listar(int offset, int quantidade) {
//        Query query = entityManager.createQuery("SELECT * from tb_produto");
//        return query.getResultList();
//    }
    
    @Override
    public List<Produto> listarPorCategoria(Categoria categoria, int offset, int quantidade) {
        throw new UnsupportedOperationException(""); //To change body of generated methods, choose Tools | Templates.
    }
    
//    @Override
//    public Produto obter(Integer codigoProduto) {
//        Query query = entityManager.createQuery("SELECT * from tb_produto WHERE id_produto = :codigoProduto;");
//        query.setParameter("codigoProduto", codigoProduto);
//        List list = query.getResultList();
//        return (Produto) list.get(0);
//    }
    
    @Override
    public Produto obter(Integer codigoProduto) {
        TypedQuery<Produto> query = entityManager
                .createQuery(
                        "SELECT * from tb_produto WHERE id_produto = :codigoProduto;",
                        Produto.class).setParameter("codigoProduto", codigoProduto);
        return query.getSingleResult();
    }

    @Override
    public void incluir(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Integer codigoProduto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
