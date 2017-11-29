package br.senac.pi4.ProjetoIntegrador.security;

import br.senac.pi4.ProjetoIntegrador.Service.ClienteService;
import br.senac.pi4.ProjetoIntegrador.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetails")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private ClienteService clienteService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

        Cliente cliente = clienteService.obterClienteByCPF(cpf);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(cliente.getRoleCliente()));

        UserDetails userDetails = new User(
                cliente.getCpfCliente(), 
                cliente.getSenhaCliente(), 
                cliente.getEnabled(),
                true,
                true,
                true,
                authorities);

        return userDetails;
        
    }


}
