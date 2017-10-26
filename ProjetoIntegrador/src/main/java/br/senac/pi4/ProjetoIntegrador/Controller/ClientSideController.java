/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.Controller;

import br.senac.pi4.ProjetoIntegrador.Models.Imagem;
import br.senac.pi4.ProjetoIntegrador.Models.Produto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jonata
 */

@Controller
public class ClientSideController {

    @RequestMapping("/")
    public ModelAndView home() {
        List<Produto> listaProdutos = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            
            Produto produto = new Produto();
            
            produto.setTituloProduto("Produto titulo " + i);
            produto.setDescricaoProduto("Descricao do item " + i);
            produto.setPrecoProduto(new BigDecimal(i));
            produto.setContadorProduto(i);
            produto.setCorProduto("background: #2098D1;");
            
            List<Imagem> imagens = new ArrayList<>();
            
            Imagem img1 = new Imagem();
            img1.setNomeImagem("/images/oculosTeste.jpg");
            img1.setLegendaImagem("Imagem de um oculos");
            img1.setSequenciaImagem(1);
            imagens.add(img1);
            
            Imagem img2 = new Imagem();
            img2.setNomeImagem("/images/oculosTeste.jpg");
            img2.setLegendaImagem("Imagem de um oculos");
            img2.setSequenciaImagem(2);
            imagens.add(img2);
            
            Imagem img3 = new Imagem();
            img3.setNomeImagem("/images/oculosTeste.jpg");
            img3.setLegendaImagem("Imagem de um oculos");
            img3.setSequenciaImagem(3);
            imagens.add(img3);
            
            produto.setImagens(imagens);
            
            listaProdutos.add(produto);
            
        }
        return new ModelAndView("clientside/home").addObject("produtos", listaProdutos);
    }

    @RequestMapping("/descricao{id}")
    public ModelAndView descricao(@PathVariable("id") Integer idProduto){
        return new ModelAndView("clientside/descricao")
                .addObject(idProduto);
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

    @RequestMapping("/clientePedidos")
    public String clientePedidos() {
        return "clientside/clientePedidos";
    }
    
    @RequestMapping("/checkoutEndereco")
    public String clienteCheckoutEndereco() {
        return "clientside/checkoutEndereco";
    }
    
    @RequestMapping("/checkoutPagamento")
    public String clienteCheckoutPagamento() {
        return "clientside/checkoutPagamento";
    }
}
