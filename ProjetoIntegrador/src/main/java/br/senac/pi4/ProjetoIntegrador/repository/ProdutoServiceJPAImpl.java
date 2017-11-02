package br.senac.pi4.ProjetoIntegrador.repository;


import br.senac.pi4.ProjetoIntegrador.Service.ProdutoService;
import br.senac.pi4.ProjetoIntegrador.entity.Categoria;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoServiceJPAImpl implements ProdutoService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Produto> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery("SELECT * FROM tb_produto");
        return query.getResultList();
    }

    @Override
    public List<Produto> listarPorCategoria(Categoria categoria, int offset, int quantidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto obter(Integer codigoProduto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
