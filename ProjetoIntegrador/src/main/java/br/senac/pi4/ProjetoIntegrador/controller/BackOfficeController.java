/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.Service.ProdutoService;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import br.senac.pi4.ProjetoIntegrador.repository.ProdutoServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joliveira
 */
@Controller
public class BackOfficeController {

    @Autowired
    private ProdutoService service;

    @RequestMapping("/backoffice/produtos")
    public ModelAndView produto() {
        List<Produto> lista = service.listar(0, 100);

        return new ModelAndView("backoffice/produto/listaDeProdutos").addObject("prod", lista);
    }
    
    @RequestMapping("/backoffice/produtos/cadastro")
    public ModelAndView cadastro() {
        
        return new ModelAndView("backoffice/produto/cadastroDeProdutos");
    }
}
