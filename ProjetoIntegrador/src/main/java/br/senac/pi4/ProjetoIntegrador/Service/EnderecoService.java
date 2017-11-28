/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Service;

import br.senac.pi4.ProjetoIntegrador.entity.EnderecosAlternativos;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface EnderecoService extends Serializable {
    
    public List<EnderecosAlternativos> listar(Long codigoCliente);

    public void incluir(EnderecosAlternativos produto);
    
    public void alterar(EnderecosAlternativos produto);
    
    public void remover(Integer codigoEndereco);
}

