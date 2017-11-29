package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.Service.ClienteService;
import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminSideController {

    @Autowired
    private ClienteService clienteService;

    public Cliente sessaoCliente() {

        SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext) {

            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication) {

                String cpf = authentication.getName();

                Cliente cliente = clienteService.obterClienteByCPF(cpf);
                SessionController sc = new SessionController();
                sc.setCliente(cliente);
                return cliente;
            }
        }

        return null;
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public ModelAndView perfil() {
        return new ModelAndView("clientside/clientePerfil").addObject("cliente", sessaoCliente());
    }

    @RequestMapping(value = "/checkoutPagamento", method = RequestMethod.GET)
    public String clienteCheckoutPagamento() {
        return "clientside/checkoutPagamento";
    }

    @RequestMapping(value = "/checkoutConfirmacao", method = RequestMethod.GET)
    public String clienteCheckoutConfirmacao() {
        return "clientside/checkoutConfirmacao";
    }
}
