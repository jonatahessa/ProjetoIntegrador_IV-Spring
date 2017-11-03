package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.entity.Imagem;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientSideController {

    @RequestMapping("/")
    public ModelAndView home() {
        // CADASTRO
        List<Produto> listaProdutos = new ArrayList<>();
        for (int i = 0; i < 9; i++) {

            Produto produto = new Produto();

            produto.setTituloProduto("Produto titulo " + i);
            produto.setDescricaoProduto("Descricao do item " + i);
            produto.setPrecoProduto(new BigDecimal(i));
            produto.setGeneroProduto('m');
            produto.setContadorProduto(i);
            produto.setCodigoProduto(i);
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

    @RequestMapping("/descricao/{id}")
    public ModelAndView descricao(@PathVariable("id") Integer idProduto) {

        // METODO OBTER POR ID
        Produto produto = new Produto();

        produto.setTituloProduto("Produto titulo " + idProduto);
        produto.setDescricaoProduto("Descricao do item " + idProduto);
        produto.setPrecoProduto(new BigDecimal(idProduto));
        produto.setContadorProduto(idProduto);
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

        return new ModelAndView("clientside/descricao")
                .addObject("idProduto", idProduto)
                .addObject("produto", produto);
    }

    @RequestMapping("/carrinho")
    public ModelAndView carrinho() {
        List<Imagem> imagens = new ArrayList<>();

        Imagem img = new Imagem();
        img.setNomeImagem("/images/oculosTeste.jpg");
        img.setLegendaImagem("Imagem de um oculos");
        img.setSequenciaImagem(1);
        imagens.add(img);
        
        Produto produto = new Produto();
        produto.setTituloProduto("Óculos Oakley Preto");
        produto.setPrecoProduto(new BigDecimal("400.00"));
        produto.setImagens(imagens);
        
        Produto produto2 = new Produto();
        produto2.setTituloProduto("Óculos Adidas Preto");
        produto2.setPrecoProduto(new BigDecimal("500.00"));
        produto2.setImagens(imagens);
        
        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto);
        produtos.add(produto2);
        
        BigDecimal temp = new BigDecimal("0");
        BigDecimal total = new BigDecimal("0");
        for (Produto p : produtos) {
            temp = p.getPrecoProduto();
            total = total.add(temp);
            
        }
        
        return new ModelAndView("clientside/carrinho")
                .addObject("produtos", produtos)
                .addObject("total", total);
        
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
