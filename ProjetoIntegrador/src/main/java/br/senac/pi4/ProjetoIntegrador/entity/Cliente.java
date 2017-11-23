package br.senac.pi4.ProjetoIntegrador.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long codigoCliente;

    @Column(name = "EM_CLIENTE", length = 100, nullable = false)
    private String emailCliente;

    @Column(name = "PW_CLIENTE", length = 100, nullable = false)
    private String senhaCliente;

    @Column(name = "CP_CLIENTE", length = 14, nullable = false)
    private String cpfCliente;

    @Column(name = "NS_CLIENTE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date nascCliente;

    @OneToMany(mappedBy = "clientePedido", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Pedido> pedidos;

    @Size(min = 0, message = "{cliente.nomeCompletoCliente.erro}")
    private String nomeCompletoCliente;

    private char sexoCliente;

    private String apelidoCliente;

    @ManyToMany
    @JoinTable(name = "TB_CLIENTE_TELEFONE",
            joinColumns = {
                @JoinColumn(name = "ID_CLIENTE")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "ID_TELEFONE")
            })
    private List<Telefone> telefones;

    @ManyToMany
    @JoinTable(name = "TB_CLIENTE_ENDERECO",
            joinColumns = {
                @JoinColumn(name = "ID_CLIENTE")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "ID_ENDERECO")
            })
    private Set<Endereco> endereco;

    public Cliente() {
    }

    public Cliente(Long codigoCliente, String emailCliente, String senhaCliente, String cpfCliente, Date nascCliente, List<Pedido> pedidos, String nomeCompletoCliente, char sexoCliente, String apelidoCliente, List<Telefone> telefones, Set<Endereco> endereco) {
        this.codigoCliente = codigoCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.cpfCliente = cpfCliente;
        this.nascCliente = nascCliente;
        this.pedidos = pedidos;
        this.nomeCompletoCliente = nomeCompletoCliente;
        this.sexoCliente = sexoCliente;
        this.apelidoCliente = apelidoCliente;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    public String getNomeCompletoCliente() {
        return nomeCompletoCliente;
    }

    public void setNomeCompletoCliente(String nomeCompletoCliente) {
        this.nomeCompletoCliente = nomeCompletoCliente;
    }

    public char getSexoCliente() {
        return sexoCliente;
    }

    public void setSexoCliente(char sexoCliente) {
        this.sexoCliente = sexoCliente;
    }

    public String getApelidoCliente() {
        return apelidoCliente;
    }

    public void setApelidoCliente(String apelidoCliente) {
        this.apelidoCliente = apelidoCliente;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Date getNascCliente() {
        return nascCliente;
    }

    public void setNascCliente(Date nascCliente) {
        this.nascCliente = nascCliente;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Set<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(Set<Endereco> endereco) {
        this.endereco = endereco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
