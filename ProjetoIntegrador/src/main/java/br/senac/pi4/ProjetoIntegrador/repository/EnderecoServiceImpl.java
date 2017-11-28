/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.repository;

import br.senac.pi4.ProjetoIntegrador.Service.EnderecoService;
import br.senac.pi4.ProjetoIntegrador.entity.EnderecosAlternativos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thalles
 */
@Repository
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository repo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EnderecosAlternativos> listar(Long codigoCliente) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM tb_cliente_endereco "
                + "WHERE id_cliente= :idcliente").setParameter("idcliente", codigoCliente);
        return query.getResultList();
    }

    @Override
    public void incluir(EnderecosAlternativos produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(EnderecosAlternativos produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Integer codigoEndereco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}