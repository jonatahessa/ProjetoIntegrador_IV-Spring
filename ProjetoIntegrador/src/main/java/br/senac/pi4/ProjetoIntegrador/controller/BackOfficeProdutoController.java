/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.Service.CategoriaService;
import br.senac.pi4.ProjetoIntegrador.Service.ProdutoService;
import br.senac.pi4.ProjetoIntegrador.entity.Categoria;
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
public class BackOfficeProdutoController {

    @Autowired
    private ProdutoService prodService;
    
    @Autowired
    private CategoriaService catService;

    @RequestMapping("/backoffice/produtos")
    public ModelAndView produto() {
        List<Produto> lista = prodService.listar(0, 100);

        return new ModelAndView("backoffice/produto/listaDeProdutos").addObject("prod", lista);
    }
    
    @RequestMapping("/backoffice/produtos/cadastro")
    public ModelAndView cadastro() {
        List<Categoria> lista = catService.listar();
        
        return new ModelAndView("backoffice/produto/cadastroDeProdutos").addObject("categorias", lista);
    }
    
    @RequestMapping("/backoffice/produtos/cadastrar")
    public ModelAndView cadastrar() {
        
        return null;
    }
}
