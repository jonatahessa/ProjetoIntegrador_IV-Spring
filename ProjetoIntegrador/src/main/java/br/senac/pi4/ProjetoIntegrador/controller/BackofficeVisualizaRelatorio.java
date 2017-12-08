/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joliveira
 */

@Controller
@RequestMapping("/backoffice/relatorio")
public class BackofficeVisualizaRelatorio {
    
    @Autowired
    private  PedidoService pedidoService;
    
    @RequestMapping
    public ModelAndView abrirRelatorio() {
        
        return new ModelAndView("backoffice/pedido/relatorio");
    }
    
}
