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

    @RequestMapping(value = "/clientePedidos", method = RequestMethod.GET)
    public String clientePedidos() {
        return "clientside/clientePedidos";
    }

    @RequestMapping(value = "/checkoutEndereco", method = RequestMethod.GET)
    public String clienteCheckoutEndereco() {
        return "clientside/checkoutEndereco";
    }

    @RequestMapping(value = "/checkoutPagamento", method = RequestMethod.GET)
    public String clienteCheckoutPagamento() {
        return "clientside/checkoutPagamento";
    }

}
