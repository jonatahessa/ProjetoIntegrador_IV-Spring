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
 * @author joliveira
 */

@Controller
public class BackOfficeController {
    
    @RequestMapping("/backoffice/produto")
    public String produto() {
        return "backoffice/produto";
    }
}
