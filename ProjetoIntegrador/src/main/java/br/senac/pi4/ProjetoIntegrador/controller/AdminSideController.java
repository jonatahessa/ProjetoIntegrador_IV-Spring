package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.Service.ClienteService;
import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import br.senac.pi4.ProjetoIntegrador.entity.Pedido;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
                return cliente;
            }
        }

        return null;
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public ModelAndView clientePedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        Cliente c = clienteService.obter(Long.parseLong("5"));
        pedidos = c.getPedidos();
        boolean vazio = false;
        if (pedidos.size() == 0) {
            vazio = true;
        }
        return new ModelAndView("clientside/clientePerfil").addObject("pedidos", pedidos).addObject("vazio", vazio);
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
