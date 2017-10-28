/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador;

import javax.persistence.Persistence;

/**
 *
 * @author jonat
 */
public class GerarBD {
    
  public static void main(String[] args) {
    Persistence.generateSchema("projeto4", null);
  }
  
}
