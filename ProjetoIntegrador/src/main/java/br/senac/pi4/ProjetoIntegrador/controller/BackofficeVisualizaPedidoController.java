/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.controller;

import br.senac.pi4.ProjetoIntegrador.Service.ClienteService;
import br.senac.pi4.ProjetoIntegrador.Service.PedidoService;
import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import br.senac.pi4.ProjetoIntegrador.entity.Pedido;
import br.senac.pi4.ProjetoIntegrador.entity.Produto;
import java.util.Date;
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

/**
 *
 * @author eloisa.asilva2
 */
@Controller
@RequestMapping("/pedido")
public class BackofficeVisualizaPedidoController {

    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private ClienteService clienteService;

    
    @RequestMapping
    public ModelAndView listar() {
        List<Pedido> pedido = pedidoService.listar(0, 100);
        return new ModelAndView("backoffice/pedido/listarPedidos")
                .addObject("pedido", pedido);
           
    }
    
    @RequestMapping("/detalhe")
    public ModelAndView abrirDetalhe(@ModelAttribute("pedido") @Valid Pedido p) {
        Cliente cliente = p.getClientePedido();
        p.setIdCliente(cliente.getCodigoCliente());
        return new ModelAndView("backoffice/pedido/detalhePedido").addObject("pedido", p);
    }
    
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ModelAndView salvar(
            @ModelAttribute("pedido") @Valid Pedido p,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes){
        p.setClientePedido(clienteService.obter(p.getIdCliente()));
        p.setUltimaAtualizacao(new Date());
        pedidoService.alterar(p);
        return new ModelAndView("redirect:/pedido");
    }
}
