
package br.senac.pi4.ProjetoIntegrador.Service;

import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import java.io.Serializable;
import java.util.List;


public interface ClienteService extends Serializable {
    
    public List<Cliente> listar(int offset);
    
    public Cliente obter(Long codigoCliente);
    
    public void incluir(Cliente cliente);
    
    public void alterar(Cliente cliente);
    
    public void remover(Long codigoCliente);
}
