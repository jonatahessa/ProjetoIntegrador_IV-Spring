
package br.senac.pi4.ProjetoIntegrador.Classes;

public class Imagem {

    private Integer codigoImagem;
    private String nomeImagem;
    private String legendaImagem;
    private Integer sequenciaImagem;
    private Produto produto;

    public Imagem() {

    }

    public Imagem(Integer codigoImagem, String nomeImagem, String legendaImagem, Integer sequenciaImagem, Produto produto) {
        this.codigoImagem = codigoImagem;
        this.nomeImagem = nomeImagem;
        this.legendaImagem = legendaImagem;
        this.sequenciaImagem = sequenciaImagem;
        this.produto = produto;
    }

    public Integer getSequenciaImagem() {
        return sequenciaImagem;
    }

    public void setSequenciaImagem(Integer sequenciaImagem) {
        this.sequenciaImagem = sequenciaImagem;
    }

    public Integer getCodigoImagem() {
        return codigoImagem;
    }

    public void setCodigoImagem(Integer codigoImagem) {
        this.codigoImagem = codigoImagem;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public String getLegendaImagem() {
        return legendaImagem;
    }

    public void setLegendaImagem(String legendaImagem) {
        this.legendaImagem = legendaImagem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
