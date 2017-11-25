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
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoServiceImpl implements ProdutoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProdutoRepository repo;

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

    @Override
    public Produto obter(Long idProduto) {
        return repo.findOne(idProduto);
    }

    @Override
    @Transactional
    public void incluir(Produto produto) {
        entityManager.persist(produto);
    }

    @Override
    @Transactional
    public void alterar(Produto produto) {
        entityManager.merge(produto);
    }

    @Override
    @Transactional
    public void remover(Long idProduto) {
        Produto p = entityManager.find(Produto.class, idProduto);
        entityManager.remove(p);
    }

}
