package br.senac.pi4.ProjetoIntegrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminSideController {
    
    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public String perfil() {
        return "clientside/clientePerfil";
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
