package br.senac.pi4.ProjetoIntegrador.repository;

import br.senac.pi4.ProjetoIntegrador.Service.ImagemService;
import br.senac.pi4.ProjetoIntegrador.Service.ProdutoService;
import br.senac.pi4.ProjetoIntegrador.entity.Categoria;
import br.senac.pi4.ProjetoIntegrador.entity.Imagem;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImagemServiceImpl implements ImagemService {

   @Autowired
    private ImagemRepository repo;
   
    @Autowired
    private EntityManager em;
    
    @Override
    public List<Imagem> listar(int offset, int quantidade) {
        Iterable<Imagem> imagens = repo.findAll();
        Iterator it = imagens.iterator();
        ArrayList<Imagem> lista = new ArrayList<Imagem>();
        while (it.hasNext()) {
            Imagem img = (Imagem) it.next();
            lista.add(img);
        }
        return lista;
    }

    @Override
    public List<Imagem> listarPorCategoria(Categoria categoria, int offset, int quantidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Imagem obter(Long idImagem) {
        return repo.findOne(Long.parseLong("" + idImagem));
    }

    @Override
    public void incluir(Imagem imagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Imagem imagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Integer codigoImagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public List<Imagem> obterCodigoProduto(Long codigoProduto) {
        Query query = em.createNativeQuery(
            "SELECT * FROM tb_imagem "
            + "WHERE sq_imagem = 1 "        
            + "AND id_produto = :idProd")
            .setParameter("idProd", codigoProduto);
        return query.getResultList();
    }

       
}

