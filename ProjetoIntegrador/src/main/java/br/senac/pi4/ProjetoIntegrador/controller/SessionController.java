/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.entity.Imagem;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import br.senac.pi4.ProjetoIntegrador.repository.ImagemServiceImpl;
import br.senac.pi4.ProjetoIntegrador.repository.ProdutoServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sessao")
@Scope("session")
public class SessionController implements Serializable {

    @Autowired
    ProdutoServiceImpl serviceProduto;
    
    @Autowired
    ImagemServiceImpl serviceImagem;

    private List<Produto> carrinho = new ArrayList<Produto>();
    private List<Imagem> imagens = new ArrayList<Imagem>();

    @RequestMapping("/adicionar/{id}")
    public ModelAndView adicionarProduto(@PathVariable("id") Long idProduto,
            RedirectAttributes redirectAttributes) {
        Produto p = serviceProduto.obter(idProduto);
//        List<Imagem> temp = serviceImagem.obterCodigoProduto(p.getCodigoProduto());
        carrinho.add(p);     
//        imagens.add(temp.get(0));
        return new ModelAndView("redirect:/");
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }
    
     public List<Imagem> getImagens() {
        return imagens;
    }
    
     @RequestMapping(value = "/carrinho", method = RequestMethod.GET)
    public ModelAndView carrinho() {
        return new ModelAndView("clientside/carrinho");
    }

}
