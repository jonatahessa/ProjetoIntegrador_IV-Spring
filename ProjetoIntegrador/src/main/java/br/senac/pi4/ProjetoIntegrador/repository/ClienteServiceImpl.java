package br.senac.pi4.ProjetoIntegrador.repository;

import br.senac.pi4.ProjetoIntegrador.Service.ClienteService;
import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cliente> listar(int offset) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente obter(Long codigoCliente) {
        return repo.findOne(codigoCliente);
    }

    @Override
    public Cliente obterClientePeloCPF_Senha(String cpf, String senha) {
        Query query = this.entityManager.createQuery(
                "SELECT * FROM `tb_cliente` WHERE `cpf_cliente` = "
                + " :cpf AND `pw_cliente` = :senha");
        query.setParameter("cpf", cpf);
        query.setParameter("senha", senha);
        try {
            return (Cliente) query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    @Override
    public void incluir(Cliente cliente) {
        entityManager.persist(cliente);
    }

    @Override
    public void alterar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Long codigoCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
