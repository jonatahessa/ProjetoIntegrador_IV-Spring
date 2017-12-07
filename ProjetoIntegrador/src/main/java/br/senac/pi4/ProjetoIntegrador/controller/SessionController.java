package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.entity.Cartao;
import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import br.senac.pi4.ProjetoIntegrador.entity.Endereco;
import br.senac.pi4.ProjetoIntegrador.entity.Imagem;
import br.senac.pi4.ProjetoIntegrador.entity.Pedido;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import br.senac.pi4.ProjetoIntegrador.repository.ClienteServiceImpl;
import br.senac.pi4.ProjetoIntegrador.repository.EnderecoServiceImpl;
import br.senac.pi4.ProjetoIntegrador.repository.ImagemServiceImpl;
import br.senac.pi4.ProjetoIntegrador.repository.PedidoServiceImpl;
import br.senac.pi4.ProjetoIntegrador.repository.ProdutoServiceImpl;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.catalina.Globals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sessao")
@Scope("session")
public class SessionController implements Serializable {

    @Autowired
    ClienteServiceImpl serviceCliente;

    @Autowired
    ProdutoServiceImpl serviceProduto;

    @Autowired
    ImagemServiceImpl serviceImagem;

    @Autowired
    EnderecoServiceImpl serviceEndereco;

    @Autowired
    PedidoServiceImpl servicePedido;

    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    HttpSession sessao = request.getSession();

    private Set<Produto> carrinho = new HashSet<Produto>();
    private Long idCliente = (Long) sessao.getAttribute("idDoCliente");
    private Cartao cartao = new Cartao();
    private int qntCarrinho = 1;
    private Long idEndereco = null;
    private BigDecimal total = new BigDecimal("0.0");
    private boolean temEstoque = true;

    @RequestMapping("/adicionar/{id}")
    public ModelAndView adicionarProduto(@PathVariable("id") Long idProduto,
            RedirectAttributes redirectAttributes) {
        boolean igual = false;
        for (Produto p : carrinho) {
            if (p.getCodigoProduto() == idProduto) {
                if (p.getQuantEstoqueProduto() - (p.getQntCarrinho() + 1) < 0) {
                    temEstoque = false;
                    redirectAttributes.addFlashAttribute("msgEstoque",
                            "Quantidade indisponivel no estoque! ");
                    return new ModelAndView("redirect:/");
                }
                temEstoque = true;
                qntCarrinho++;
                p.setQntCarrinho(qntCarrinho);
                igual = true;
            }
        }

        if (igual == false) {
            Produto p = serviceProduto.obter(idProduto);
            p.setQntCarrinho(1);
            carrinho.add(p);
        }

        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/comprar/{id}")
    public ModelAndView comprarProduto(@PathVariable("id") Long idProduto,
            RedirectAttributes redirectAttributes) {
        boolean igual = false;
        for (Produto p : carrinho) {
            if (p.getCodigoProduto() == idProduto) {
                if (p.getQuantEstoqueProduto() - (p.getQntCarrinho() + 1) < 0) {
                    temEstoque = false;
                    redirectAttributes.addFlashAttribute("msgEstoque",
                            "Quantidade indisponivel no estoque! ");
                    return new ModelAndView("redirect:/");
                }
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
        return new ModelAndView("redirect:/sessao/carrinho");
    }

    @RequestMapping("/remover/{id}")
    public ModelAndView removerProduto(@PathVariable("id") Long idProduto,
            RedirectAttributes redirectAttributes, @ModelAttribute("qnt") @Valid int qnt) {

        for (Produto p : carrinho) {
            if (p.getCodigoProduto() == idProduto) {
                int qntAtual = p.getQntCarrinho() - 1;
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

    @RequestMapping("/add/{id}")
    public ModelAndView addProduto(@PathVariable("id") Long idProduto,
            RedirectAttributes redirectAttributes, @ModelAttribute("qnt") @Valid int qnt) {

        for (Produto p : carrinho) {
            if (p.getCodigoProduto() == idProduto) {
                if (p.getQuantEstoqueProduto() - (p.getQntCarrinho() + 1) < 0) {
                    temEstoque = false;
                    return new ModelAndView("redirect:/sessao/carrinho");
                }
                int qntAtual = p.getQntCarrinho() + 1;
                p.setQntCarrinho(qntAtual);
            }
        }
        temEstoque = false;
        return new ModelAndView("redirect:/sessao/carrinho");
    }

    public Set<Produto> getCarrinho() {
        return carrinho;
    }

    @RequestMapping(value = "/carrinho", method = RequestMethod.GET)
    public ModelAndView carrinho(RedirectAttributes redirectAttributes) {
        BigDecimal tempTotal = new BigDecimal("0.0");
        BigDecimal produto = new BigDecimal("0.0");
        List<Imagem> imagens = new ArrayList<>();
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
        total = total.add(new BigDecimal("12.0"));

        if (temEstoque == true) {
            return new ModelAndView("clientside/carrinho").addObject("total", total).addObject("vazio", vazio);
        } else {
            redirectAttributes.addFlashAttribute("msgEstoque",
                    "Quantidade indisponivel no estoque! ");
            return new ModelAndView("clientside/carrinho").addObject("total", total).addObject("vazio", vazio);
        }
    }

    @RequestMapping(value = "/checkoutEndereco")
    public ModelAndView checkoutEndereco() {
        Cliente cliente = serviceCliente.obter(idCliente);
        List<Endereco> enderecos = cliente.getEnderecos();
        return new ModelAndView("clientside/checkoutEndereco").addObject("enderecos", enderecos).addObject("cliente", cliente);
    }

    @RequestMapping(value = "/checkoutPagamento")
    public ModelAndView checkoutPagamento(@ModelAttribute("id") Long codigoEndereco) {
        idEndereco = codigoEndereco;
        return new ModelAndView("clientside/checkoutPagamento").addObject("cartao", new Cartao());
    }

    @RequestMapping(value = "/validaCartao")
    public ModelAndView validaCartao(@ModelAttribute("cartao") @Valid Cartao c,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("clientside/checkoutPagamento")
                    .addObject("cartao", c);
        }
        cartao = c;
        return new ModelAndView("redirect:/sessao/checkoutConfirmacao");
    }

    @RequestMapping(value = "/checkoutConfirmacao")
    public ModelAndView checkoutConfirmacao() {
        Endereco endereco = serviceEndereco.obter(idEndereco);
        return new ModelAndView("clientside/checkoutConfirmacao").addObject("endereco", endereco).addObject("cartao", cartao).addObject("total", total);
    }

    @RequestMapping(value = "/salvarPedido")
    public ModelAndView salvarPedido() {
        Pedido pedido = new Pedido();
        pedido.setClientePedido(serviceCliente.obter(idCliente));
        pedido.setDataPedido(new Date());
        pedido.setFormaPagamentoPedido("Cartão em " + cartao.getParcelas() + " Vezes");
        pedido.setProdutos(carrinho);
        pedido.setStatusPedido("Pedido Recebido!");
        pedido.setUltimaAtualizacao(new Date());
        pedido.setValorPedido(total);
//        removerEstoque(pedido);

        servicePedido.incluir(pedido);
        carrinho = null;
        total = null;
        idEndereco = null;
        qntCarrinho = 0;

        return new ModelAndView("redirect:/admin/perfil");
    }

    public void removerEstoque(Pedido pedido) {
        for (Produto p : carrinho) {
            int qnt = p.getQuantEstoqueProduto() - p.getQntCarrinho();
            p.setQuantEstoqueProduto(qnt);
            serviceProduto.alterar(p);
        }
    }

}
