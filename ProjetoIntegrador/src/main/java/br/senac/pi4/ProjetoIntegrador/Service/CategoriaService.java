/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Service;

import br.senac.pi4.ProjetoIntegrador.Models.Categoria;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface CategoriaService extends Serializable {
    
    public List<Categoria> listar();
    
    public Categoria obter(Integer codigoCategoria);
}
