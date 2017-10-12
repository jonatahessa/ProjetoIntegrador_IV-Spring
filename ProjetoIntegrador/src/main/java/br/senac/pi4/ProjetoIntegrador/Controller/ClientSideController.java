/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author jonata
 */

@Controller
public class ClientSideController {
    
    @RequestMapping("/")
    public String home() {
        return "clientside/home";
    }
    
    @RequestMapping("/descricao")
    public String produtos() {
        return "clientside/descricao";
    }
    
    @RequestMapping("/carrinho")
    public String carrinho() {
        return "clientside/carrinho";
    }
    
    @RequestMapping("/perfil")
    public String perfil() {
        return "clientside/clientePerfil";
    }
    
    @RequestMapping("/cadastroC")
    public String cadastroC() {
        return "clientside/clienteCadastro";
    }
    
}
