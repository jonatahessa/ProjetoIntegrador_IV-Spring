/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.ProjetoIntegrador.entity;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Casa
 */
public class Usuario implements UserDetails {

    private List<Papel> papeis;

    private Integer codigoCliente;

    private String senhaCliente;

    private String cpfCliente;

    private String nomeCompletoCliente;

    public Usuario(Integer codigoCliente, String senhaCliente, String cpfCliente, String nomeCompletoCliente, List<Papel> papeis) {
        this.codigoCliente = codigoCliente;
        this.senhaCliente = senhaCliente;
        this.cpfCliente = cpfCliente;
        this.nomeCompletoCliente = nomeCompletoCliente;
        this.papeis = papeis;
    }

    @Override
    public Collection<Papel> getAuthorities() {
        return papeis;
    }

    @Override
    public String getPassword() {
        return senhaCliente;
    }

    @Override
    public String getUsername() {
        return cpfCliente;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
