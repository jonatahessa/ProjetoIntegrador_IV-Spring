package br.senac.pi4.ProjetoIntegrador.repository;
import br.senac.pi4.ProjetoIntegrador.Service.EnderecoService;
import br.senac.pi4.ProjetoIntegrador.entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository repo;


    @Override
    public Endereco obter(Long codigoEndereco) {
        return repo.findOne(codigoEndereco);
    }
    
    @Override
    public void incluir(Endereco produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Endereco produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Integer codigoEndereco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}