package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import br.senac.pi4.ProjetoIntegrador.entity.Imagem;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import br.senac.pi4.ProjetoIntegrador.repository.CategoriaServiceImpl;
import br.senac.pi4.ProjetoIntegrador.repository.ImagemServiceImpl;
import br.senac.pi4.ProjetoIntegrador.repository.ProdutoServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClientSideController {

    @Autowired
    CategoriaServiceImpl serviceCategoria;

    @Autowired
    ImagemServiceImpl serviceImagem;

    @Autowired
    ProdutoServiceImpl serviceProduto;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {

        List<Produto> listaProdutos = new ArrayList<>();

        List<Produto> produtos = serviceProduto.listar(0, 100);
        List<Imagem> imagens = serviceImagem.listar(0, 100);

        return new ModelAndView("clientside/home").addObject("produtos", produtos).addObject("imagens", imagens);
    }

    @RequestMapping(value = "/descricao/{id}")
    public ModelAndView descricao(@PathVariable("id") Long idProduto) {

        Produto produto = serviceProduto.obter(idProduto);
        List<Imagem> imagens = serviceImagem.obterCodigoProduto(Long.parseLong("" + idProduto));

        return new ModelAndView("clientside/descricao")
                .addObject("produto", produto)
                .addObject("imagem", imagens);
    }

    @RequestMapping(value = "/cadastroC")
    public ModelAndView cadastroC(Cliente cliente) {
        return new ModelAndView("clientside/clienteCadastro")
                .addObject("cliente", new Cliente());
    }

    @RequestMapping(value = "/novoCliente", method = RequestMethod.POST)
    public ModelAndView cadastrarCliente(
            @ModelAttribute("cliente") @Valid Cliente cliente,
            BindingResult result,
            RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return new ModelAndView("clientside/clienteCadastro");
        }

        ModelAndView mv = new ModelAndView("redirect:/cadastroC");
        attributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso");
        return mv;
    }

    @RequestMapping("/login")
    public String login() {
        return "clientside/login";
    }

}
