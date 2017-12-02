package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.Service.ClienteService;
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
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private CategoriaServiceImpl serviceCategoria;

    @Autowired
    private ImagemServiceImpl serviceImagem;

    @Autowired
    private ProdutoServiceImpl serviceProduto;

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {

        List<Produto> listaProdutos = new ArrayList<>();

        List<Produto> produtos = serviceProduto.listar(0, 100);
        List<Imagem> imagens = serviceImagem.listar(0, 100);

        return new ModelAndView("clientside/home")
                .addObject("produtos", produtos)
                .addObject("imagens", imagens)
                .addObject("cliente", sessaoCliente());
    }

    @RequestMapping(value = "/descricao/{id}")
    public ModelAndView descricao(@PathVariable("id") Long idProduto) {

        Produto produto = serviceProduto.obter(idProduto);
        List<Imagem> imagens = produto.getImagens();
        
        return new ModelAndView("clientside/descricao")
                .addObject("produto", produto).addObject("imagens", imagens);
    }

    @RequestMapping(value = "/cadastroC")
    public ModelAndView cadastroC() {
        return new ModelAndView("clientside/clienteCadastro")
                .addObject("cliente", new Cliente());
    }

    public Cliente sessaoCliente() {

        SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext) {
            
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication) {
                
                String cpf = authentication.getName();
                
                Cliente cliente = clienteService.obterClienteByCPF(cpf);
               
                return cliente;
                
            }
        }

        return null;
    }

    @RequestMapping(value = "/novoCliente", method = RequestMethod.POST)
    public ModelAndView cadastrarCliente(
            @ModelAttribute(value = "cliente") @Valid Cliente cliente, BindingResult clienteR,
            RedirectAttributes attributes) {

        boolean inclusao = (sessaoCliente().getCodigoCliente() == null);

        if (clienteR.hasErrors()) {
            if (inclusao) {
                return new ModelAndView("clientside/clienteCadastro");
            } else {
                return new ModelAndView("clientside/clientePerfil");
            }

        }
        if (inclusao) {
            clienteService.incluir(cliente);
        } else {
            clienteService.alterar(cliente);
        }

        if (inclusao) {
            ModelAndView mv = new ModelAndView("redirect:/cadastroC");
            attributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("redirect:/admin/perfil");
            attributes.addFlashAttribute("mensagem", "Cliente alterado com sucesso");
            return mv;
        }

    }

    @RequestMapping("/login")
    public String login() {
        return "clientside/login";
    }

    @RequestMapping("/login-error")
    public ModelAndView loginError() {
        return new ModelAndView("clientside/login").addObject("erro", true);
    }

}
