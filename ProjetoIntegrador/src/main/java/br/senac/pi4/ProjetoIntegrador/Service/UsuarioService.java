package br.senac.pi4.ProjetoIntegrador.Service;

import br.senac.pi4.ProjetoIntegrador.config.SecurityConfig;
import br.senac.pi4.ProjetoIntegrador.entity.Usuario;
import br.senac.pi4.ProjetoIntegrador.entity.Papel;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    private static final Map<String, Usuario> USUARIOS;

    static {
        
        USUARIOS = new LinkedHashMap<String, Usuario>();

        USUARIOS.put("Livia Cristina", new Usuario(new Long(1),
                SecurityConfig.passwordEncoder().encode("1234"),
                "437.931.688-21",
                "Livia Cristina",
                Arrays.asList(new Papel("ROLE_BOÇA"))));

        USUARIOS.put("Eloisa Apolinario", new Usuario(new Long(2),
                SecurityConfig.passwordEncoder().encode("1234"),
                "437.931.688-24",
                "Eloisa Apolinario",
                Arrays.asList(new Papel("ROLE_JOSELITO"))));

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return USUARIOS.get(username);
    }

}
