package br.senac.pi4.ProjetoIntegrador.entity;

import javax.validation.constraints.Size;

public class Cartao {
    
    @Size(min = 19, max = 19, message = "{cartao.numero.erro}")
    private String numero;
    
    @Size(min = 1, max = 100, message = "{cartao.nome.erro}")
    private String nome;
    
    @Size(min = 5, max = 5, message = "{cartao.vencimento.erro}")
    private String vencimento;
    
    @Size(min = 3, max = 3, message = "{cartao.codigo.erro}")
    private String codigo;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
      
}
