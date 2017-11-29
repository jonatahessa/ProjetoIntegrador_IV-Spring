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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public Cliente obterClienteByCPF(String cpf) {
        
        Query query = entityManager.createQuery("FROM Cliente c WHERE cpf_cliente = :cpf").setParameter("cpf", cpf);
        
        Cliente cliente = (Cliente) query.getSingleResult();
        
        if (cliente == null) {
            return null;
        }
        
        return cliente;
        
    }
    
    @Transactional
    @Override
    public void incluir(Cliente cliente) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(cliente.getPassword());
        cliente.setSenhaCliente(hashedPassword);
        cliente.setEnabled(true);
        cliente.setRoleCliente("ROLE_JOSELITO");
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
