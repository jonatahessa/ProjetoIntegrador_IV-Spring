/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Controller;

import br.senac.pi4.ProjetoIntegrador.Classes.Produto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joliveira
 */
@Controller
public class BackOfficeController {

    @RequestMapping("/backoffice/Produtos")
    public ModelAndView produto() {
        List<Produto> listaProdutos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Produto produto = new Produto();
            produto.setCodigoProduto(i);
            produto.setTituloProduto("Produto: " + i);
            listaProdutos.add(produto);
           }
        
        return new ModelAndView("backoffice/listaDeProdutos").addObject("prod", listaProdutos);
    }
}
