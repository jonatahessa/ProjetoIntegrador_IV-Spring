/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Service.Implement;

import br.senac.pi4.ProjetoIntegrador.entity.Categoria;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import br.senac.pi4.ProjetoIntegrador.Service.CategoriaService;
import br.senac.pi4.ProjetoIntegrador.Service.ProdutoService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jonat
 */
public class ServicoProdutoImplement implements ProdutoService {
    
    private static final Map<Integer, Produto> MAPA_PRODUTOS = new LinkedHashMap<Integer, Produto>();
    
    private static final String DESCRICAO_PADRAO = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
          + "Aenean vel ipsum vehicula, venenatis leo nec, ornare felis. Ut consectetur est vel pulvinar tempus. "
          + "Suspendisse commodo cursus turpis. Etiam ac enim egestas, sollicitudin libero ac, eleifend risus. "
          + "Phasellus nec posuere magna, in vehicula elit. "
          + "Etiam rhoncus, ipsum eget dapibus vulputate, massa nisi feugiat odio, a consectetur urna diam id risus. "
          + "Morbi sed pharetra nisl, nec aliquam ex. Morbi congue urna ut semper aliquam. "
          + "Sed aliquet turpis ac sem egestas dignissim. Praesent interdum dapibus cursus. "
          + "Cras posuere tempor lectus, ac porttitor tellus maximus vel.";

    static {
        CategoriaService categoria = new ServiceCategoriaImplement();
    }
    
    @Override
    public List<Produto> listar(int offset, int quantidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
