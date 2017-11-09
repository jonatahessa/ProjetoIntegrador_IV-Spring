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
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        List<Produto> listaProdutos = prodService.listar(0, 100);
        List<Categoria> listaCategorias = catService.listar();

        return new ModelAndView("backoffice/produto/listaDeProdutos").addObject("prod", listaProdutos).addObject("categorias", listaCategorias).addObject("produto", new Produto());
    }
    //Cadastro de Produto;
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public ModelAndView salvar(
            @ModelAttribute("produto") @Valid Produto p,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("produto/input");
        }
        boolean inclusao = (p.getCodigoProduto()== null);
        p.setDtCadastroProduto(new Date());

        if (p.getIdCategorias() != null && !p.getIdCategorias().isEmpty()) {
            Set<Categoria> categorias = new LinkedHashSet<Categoria>();
            for (Integer i : p.getIdCategorias()) {
                Categoria c = catService.obter(i);
                Set<Produto> produtos = new LinkedHashSet<Produto>();
                produtos.add(p);
                c.setProdutos(produtos);
                categorias.add(c);
            }
            p.setCategorias(categorias);
        }
        if (inclusao) {
            prodService.incluir(p);
        } else {
            prodService.alterar(p);
        }

        redirectAttributes.addFlashAttribute("msgSucesso",
                "Produto " + p.getTituloProduto()+ " cadastrado com sucesso");
        return new ModelAndView("redirect:/gerenciamento/produto");
    }
}
