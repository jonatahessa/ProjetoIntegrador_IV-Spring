package br.senac.pi4.ProjetoIntegrador.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long codigoCliente;

    @Size(min = 1, message = "{cliente.emailCliente.erro}")
    @Column(name = "EM_CLIENTE", length = 100, nullable = false)
    private String emailCliente;

    @Size(min = 1, message = "{cliente.senhaCliente.erro}")
    @Column(name = "PW_CLIENTE", length = 100, nullable = false)
    private String senhaCliente;

    @CPF(message = "{cliente.cpfCliente.erro}")
    @Column(name = "CPF_CLIENTE", length = 14, nullable = false)
    private String cpfCliente;

    @Column(name = "NS_CLIENTE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date nascCliente;

    @OneToMany(mappedBy = "clientePedido", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Pedido> pedidos;

    @Size(min = 1, message = "{cliente.nomeCompletoCliente.erro}")
    @Column(name = "NC_CLIENTE", length = 255, nullable = false)
    private String nomeCompletoCliente;

  
    private char sexoCliente;

    @Size(min = 1, message = "{cliente.apelidoCliente.erro}")
    @Column(name = "AP_CLIENTE", length = 50, nullable = false)
    private String apelidoCliente;

    @Size(min = 1, message = "{telefone.dddTelefoneCliente.erro}")
    @Column(name = "DDT_CLIENTE", length = 3, nullable = true)
    private String dddTelefone;

    @Size(min = 1, message = "{telefone.dddCelularCliente.erro}")
    @Column(name = "DDC_CLIENTE", length = 3, nullable = true)
    private String dddCelular;

    @Size(min = 1, message = "{telefone.telefone.erro}")
    @Column(name = "TF_CLIENTE", length = 8, nullable = true)
    private String telefone;

    @Size(min = 1, message = "{telefone.celular.erro}")
    @Column(name = "TC_CLIENTE", length = 9, nullable = true)
    private String celular;

    @Size(min = 1, max = 500, message = "{endereco.logradouroEndereco.erro}")
    @Column(name = "LO_CLIENTE", length = 100, nullable = false)
    private String logradouroCliente;

    @Size(min = 1, max = 11, message = "{endereco.numeroEndereco.erro}")
    @Column(name = "NU_CLIENTE", length = 100, nullable = false)
    private String numeroCliente;

    @Size(min = 1, max = 100, message = "{endereco.complementoEndereco.erro}")
    @Column(name = "CP_CLIENTE", length = 100, nullable = true)
    private String complementoCliente;

    @Size(min = 1, max = 100, message = "{endereco.bairroEndereco.erro}")
    @Column(name = "BR_CLIENTE", length = 100, nullable = false)
    private String bairroCliente;

    @Size(min = 1, max = 100, message = "{endereco.cidadeEndereco.erro}")
    @Column(name = "CD_CLIENTE", length = 100, nullable = false)
    private String cidadeCliente;

    @Size(min = 1, max = 2, message = "{endereco.estadoEndereco.erro}")
    @Column(name = "ES_CLIENTE", length = 2, nullable = false)
    private String estadoCliente;

    @Column(name = "CE_CLIENTE", length = 9, nullable = true)
    private String cepCliente;

    public Cliente() {
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

    public String getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(String dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public String getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(String dddCelular) {
        this.dddCelular = dddCelular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getLogradouroCliente() {
        return logradouroCliente;
    }

    public void setLogradouroCliente(String logradouroCliente) {
        this.logradouroCliente = logradouroCliente;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getComplementoCliente() {
        return complementoCliente;
    }

    public void setComplementoCliente(String complementoCliente) {
        this.complementoCliente = complementoCliente;
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }
    
    
    
    
}
