/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import br.senac.pi4.ProjetoIntegrador.repository.ProdutoServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/sessao")
@Scope("session")

public class SessionController implements Serializable{
    
    private List<Produto> carrinho = new ArrayList<Produto>();

    @RequestMapping("/adicionar/{id}")
    public ModelAndView adicionarProduto(@PathVariable("id") Integer idProduto, RedirectAttributes redirectAttributes) {
        ProdutoServiceImpl psi = new ProdutoServiceImpl();
        Produto p = psi.obter(idProduto);
        carrinho.add(p);
            return new ModelAndView("redirect:/compra");
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }
    
}