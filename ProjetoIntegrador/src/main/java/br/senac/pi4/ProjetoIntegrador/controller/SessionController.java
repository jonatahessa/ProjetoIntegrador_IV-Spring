
package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.entity.EnderecosAlternativos;
import br.senac.pi4.ProjetoIntegrador.entity.Imagem;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import br.senac.pi4.ProjetoIntegrador.repository.EnderecoServiceImpl;
import br.senac.pi4.ProjetoIntegrador.repository.ImagemServiceImpl;
import br.senac.pi4.ProjetoIntegrador.repository.ProdutoServiceImpl;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    @Autowired
    EnderecoServiceImpl serviceEndereco;

    private List<Produto> carrinho = new ArrayList<Produto>();
    private List<Imagem> imagens = new ArrayList<Imagem>();
    private int qntCarrinho = 1;
    private int idEndereco = 1;
    private boolean frete = false;
    private BigDecimal total = new BigDecimal("0.0");
    
    @RequestMapping("/adicionar/{id}")
    public ModelAndView adicionarProduto(@PathVariable("id") Long idProduto,
            RedirectAttributes redirectAttributes) {
        boolean igual = false;
        for (Produto p : carrinho) {
            if (p.getCodigoProduto() == idProduto) {
                qntCarrinho++;
                igual = true;
            }
        }
        for (Produto p : carrinho) {
            if (p.getCodigoProduto() == idProduto) {
                p.setQntCarrinho(qntCarrinho);
            }
        }

        if (igual == false) {
            Produto p = serviceProduto.obter(idProduto);
            p.setQntCarrinho(1);
//        List<Imagem> temp = serviceImagem.obterCodigoProduto(p.getCodigoProduto());
            carrinho.add(p);
//        imagens.add(temp.get(0));

        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/remover/{id}")
    public ModelAndView removerProduto(@PathVariable("id") Long idProduto,
            RedirectAttributes redirectAttributes, @ModelAttribute("qnt") @Valid int qnt) {

        for (Produto p : carrinho) {
            if (p.getCodigoProduto() == idProduto) {
                int qntAtual = p.getQntCarrinho() - qnt;
                if (qntAtual != 0) {
                    p.setQntCarrinho(qntAtual);
                    break;
                } else {
                    carrinho.remove(p);
                    break;
                }
            }
        }
        return new ModelAndView("redirect:/sessao/carrinho");
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }
    
    @RequestMapping(value = "/carrinho", method = RequestMethod.GET)
    public ModelAndView carrinho() {
        BigDecimal tempTotal = new BigDecimal("0.0");
        BigDecimal produto = new BigDecimal("0.0");
        boolean vazio = false;
        if (carrinho.isEmpty()) {
            vazio = true;
        } else {
            for (Produto p : carrinho) {
                produto = p.getPrecoProduto().multiply(new BigDecimal(p.getQntCarrinho()));
                tempTotal = tempTotal.add(produto);
            }
        }
        total = tempTotal;
        return new ModelAndView("clientside/carrinho").addObject("total", total).addObject("vazio", vazio).addObject("frete", frete);
    }
    
    @RequestMapping(value = "/frete")
    public ModelAndView frete() {
        frete = true;
        total.add(new BigDecimal(12.00));
        return new ModelAndView("redirect:/sessao/carrinho");
    }
    
    @RequestMapping(value = "/checkoutEndereco")
    public ModelAndView checkoutEndereco() {
        List<EnderecosAlternativos> enderecos = serviceEndereco.listar(Long.parseLong(""+1));
        return new ModelAndView("clientside/checkoutEndereco").addObject("enderecos", enderecos);
    }
    
    @RequestMapping(value = "/checkoutPagamento")
    public ModelAndView checkoutPagamento(@ModelAttribute("id") @Valid int codigoEndereco) {
        idEndereco = codigoEndereco;
        return new ModelAndView("clientside/checkoutPagamento");
    }

}
