package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.Service.ClienteService;
import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import br.senac.pi4.ProjetoIntegrador.entity.Endereco;
import br.senac.pi4.ProjetoIntegrador.entity.Imagem;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import br.senac.pi4.ProjetoIntegrador.entity.Telefone;
import br.senac.pi4.ProjetoIntegrador.repository.CategoriaServiceImpl;
import br.senac.pi4.ProjetoIntegrador.repository.ImagemServiceImpl;
import br.senac.pi4.ProjetoIntegrador.repository.ProdutoServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Scope("session")
public class ClientSideController {

    @Autowired
    private CategoriaServiceImpl serviceCategoria;

    @Autowired
    private ImagemServiceImpl serviceImagem;

    @Autowired
    private ProdutoServiceImpl serviceProduto;

    @Autowired
    private ClienteService clienteService;
    
    private Long idCliente;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Armazenamento de cliente para cadastro *
     */
    private Cliente clienteCadastro;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        List<Produto> produtos = serviceProduto.listar(0, 100);
        List<Imagem> imagens = new ArrayList<>();

        boolean vazio = false;

        if (produtos.isEmpty()) {
            vazio = true;
        }

        for (Produto p : produtos) {
            if (p.getQuantEstoqueProduto() == 0) {
                p.setEstoque(false);
            } else {
                p.setEstoque(true);
            }
            List<Imagem> img = p.getImagens();
            for (Imagem i : img) {
                if (i.getSequenciaImagem() == 1) {
                    i.setIdProduto(p.getCodigoProduto());
                    imagens.add(i);
                }
            }
        }

        return new ModelAndView("clientside/home")
                .addObject("produtos", produtos)
                .addObject("imagens", imagens)
                .addObject("vazio", vazio);
    }

    @RequestMapping(value = "/pesquisa")
    public ModelAndView pesquisa(@ModelAttribute("pesquisa") String pesquisa) {
        List<Produto> produtos = serviceProduto.pesquisar(pesquisa);
        List<Imagem> imagens = new ArrayList<>();
        boolean vazio = false;

        if (produtos.isEmpty()) {
            vazio = true;
        }

        for (Produto p : produtos) {
            if (p.getQuantEstoqueProduto() == 0) {
                p.setEstoque(false);
            } else {
                p.setEstoque(true);
            }
            List<Imagem> img = p.getImagens();
            for (Imagem i : img) {
                if (i.getSequenciaImagem() == 1) {
                    i.setIdProduto(p.getCodigoProduto());
                    imagens.add(i);
                }
            }
        }

        return new ModelAndView("clientside/home")
                .addObject("produtos", produtos)
                .addObject("imagens", imagens)
                .addObject("vazio", vazio)
                .addObject("cliente", sessaoCliente());
    }

    @RequestMapping(value = "/descricao/{id}")
    public ModelAndView descricao(@PathVariable("id") Long idProduto) {
        Produto produto = serviceProduto.obter(idProduto);
        List<Imagem> imagens = produto.getImagens();

        if (produto.getQuantEstoqueProduto() == 0) {
            produto.setEstoque(false);
        } else {
            produto.setEstoque(true);
        }

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

        boolean inclusao = (cliente.getCodigoCliente() == null);

        if (clienteR.hasErrors()) {
            if (inclusao) {
                return new ModelAndView("clientside/clienteCadastro");
            } else {
                return new ModelAndView("clientside/clienteCadastro");
            }

        }
        if (inclusao) {
            clienteCadastro = cliente;
        } else {
            clienteService.alterar(cliente);
        }

        if (inclusao) {
            return new ModelAndView("clientside/clienteCadastroTelefone")
                    .addObject("telefone", new Telefone());
        } else {
            ModelAndView mv = new ModelAndView("redirect:/admin/perfil");
            attributes.addFlashAttribute("mensagem", "Cliente alterado com sucesso");
            return mv;
        }

    }

    @RequestMapping(value = "/novoCliente/endereco", method = RequestMethod.POST)
    public ModelAndView cadastrarEnderecoCliente(
            @ModelAttribute(value = "endereco") @Valid Endereco endereco, BindingResult bindingResult,
            RedirectAttributes attributes) {

        boolean inclusao = (endereco.getCodigoEndereco() == null);

        if (bindingResult.hasErrors()) {
            if (inclusao) {
                return new ModelAndView("clientside/clienteCadastroEndereco");
            } else {
                return new ModelAndView("clientside/clientePerfil");
            }

        }
        if (inclusao) {
            List<Endereco> enderecos = new ArrayList<>();
            enderecos.add(endereco);
            clienteCadastro.setEnderecos(enderecos);
        } else {
            //clienteService.alterar(cliente);
        }

        if (inclusao) {
            return new ModelAndView("redirect:/finalizarCadastro");
        } else {
            ModelAndView mv = new ModelAndView("redirect:/admin/perfil");
            attributes.addFlashAttribute("mensagem", "Enderecos alterados com sucesso");
            return mv;
        }
    }

    @RequestMapping(value = "/novoCliente/telefone", method = RequestMethod.POST)
    public ModelAndView cadastrarTelefoneCliente(
            @ModelAttribute(value = "telefone") @Valid Telefone telefone, BindingResult bindingResult,
            RedirectAttributes attributes) {

        boolean inclusao = (telefone.getCodigoTelefone() == null);

        if (bindingResult.hasErrors()) {
            if (inclusao) {
                return new ModelAndView("clientside/clienteCadastroTelefone");
            } else {
                return new ModelAndView("clientside/clientePerfil");
            }

        }
        if (inclusao) {
            List<Telefone> telefones = new ArrayList<>();
            telefones.add(telefone);
            clienteCadastro.setTelefones(telefones);
        } else {
            //clienteService.alterar(cliente);
        }

        if (inclusao) {
            return new ModelAndView("clientside/clienteCadastroEndereco")
                    .addObject("endereco", new Endereco());
        } else {
            ModelAndView mv = new ModelAndView("redirect:/admin/perfil");
            attributes.addFlashAttribute("mensagem", "Telefones alterados com sucesso");
            return mv;
        }
    }

    @RequestMapping(value = "/finalizarCadastro")
    public ModelAndView finalizarCadastro(RedirectAttributes redirectAttributes) {

        clienteCadastro.setRoleCliente("ROLE_JOSELITO");
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(clienteCadastro.getSenhaCliente());
        clienteCadastro.setSenhaCliente(hashedPassword);
        clienteCadastro.setEnabled(true);

        clienteService.incluir(clienteCadastro);

        redirectAttributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso");
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/login")

    public String login() {
        return "clientside/login";
    }

    @RequestMapping("/login-error")
    public ModelAndView loginError() {
        return new ModelAndView("clientside/login").addObject("erro", true);
    }
    
    @RequestMapping("/meusDados")
    public ModelAndView meusDados() {
        Cliente cliente = clienteService.obter(idCliente);
        
        return new ModelAndView("clientside/perfil/perfil_meusDados").addObject("cliente", cliente);
    }

}
