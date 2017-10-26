package br.senac.pi4.ProjetoIntegrador.Classes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Integer codigoProduto;

    @Size(min = 1, max = 100, message = "{produto.tituloProduto.erro}")
    @Column(name = "TL_PRODUTO", length = 100, nullable = false)
    private String tituloProduto;

    @Digits(integer = 11, fraction = 0, message = "{produto.quantEstoque.erro}")
    @Column(name = "QT_PRODUTO", nullable = false)
    private int quantEstoqueProduto;

    @Column(name = "AV_PRODUTO")
    private int avaliacaoProduto;

    @Size(min = 1, max = 50, message = "{produto.marcaProduto.erro}")
    @Column(name = "MC_PRODUTO", length = 50, nullable = false)
    private String marcaProduto;

    @Size(min = 1, max = 50, message = "{produto.modeloProduto.erro}")
    @Column(name = "MD_PRODUTO", length = 50, nullable = false)
    private String modeloProduto;

    @Size(min = 1, max = 20, message = "{produto.corProduto.erro}")
    @Column(name = "CO_PRODUTO", length = 20, nullable = false)
    private String corProduto;

    @Size(min = 1, max = 1, message = "{produto.generoProduto.erro}")
    @Column(name = "GE_PRODUTO", length = 1, nullable = false)
    private char generoProduto;

    @Size(min = 1, max = 5, message = "{produto.tamanhoProduto.erro}")
    @Column(name = "TM_PRODUTO", length = 5, nullable = false)
    private char tamanhoProduto;

    @Size(min = 1, max = 20, message = "{produto.lenteCorProduto.erro}")
    @Column(name = "CL_PRODUTO", length = 20, nullable = false)
    private String lenteCorProduto;

    @Size(min = 1, max = 100, message = "{produto.lenteTipoProduto.erro}")
    @Column(name = "LT_PRODUTO", length = 100, nullable = false)
    private String lenteTipoProduto;

    @Size(min = 1, max = 1000, message = "{produto.descricaoProduto.erro}")
    @Column(name = "DS_PRODUTO", length = 1000, nullable = false)
    private String descricaoProduto;

    @Digits(integer = 6, fraction = 2, message = "{produto.precoProduto.erro}")
    @Column(name = "VL_PRODUTO", precision = 6, scale = 2, nullable = false)
    private BigDecimal precoProduto;

    @Column(name = "PR_PRODUTO", nullable = false)
    private boolean promocaoProduto;

    @Digits(integer = 6, fraction = 2, message = "{produto.precoProduto.erro}")
    @Column(name = "VP_PRODUTO", precision = 6, scale = 2, nullable = false)
    private BigDecimal porcentagemPromocaoProduto;

    @Column(name = "DT_PRODUTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastroProduto;

    @Column(name = "AT_PRODUTO", precision = 10, scale = 2)
    private double alturaProduto;

    @Column(name = "LG_PRODUTO", precision = 10, scale = 2)
    private double larguraProduto;

    @Column(name = "CM_PRODUTO", precision = 10, scale = 2)
    private double comprimentoProduto;

    @Column(name = "PS_PRODUTO", precision = 10, scale = 2)
    private double pesoProduto;

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Imagem> imagens;

    @ManyToMany
    @JoinTable(name = "TB_PRODUTO_CATEGORIA",
            joinColumns = {
                @JoinColumn(name = "ID_PRODUTO")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "ID_CATEGORIA")
            })
    private Set<Categoria> categorias;

    @Digits(integer = 11, fraction = 0, message = "{produto.quantEstoque.erro}")
    @Column(name = "QT_PRODUTO", nullable = false)
    private int contadorProduto;

    public Produto() {
    }

    public Produto(Integer codigoProduto, String tituloProduto, int quantEstoqueProduto, int avaliacaoProduto, String marcaProduto, String modeloProduto, String corProduto, char generoProduto, char tamanhoProduto, String lenteCorProduto, String lenteTipoProduto, String descricaoProduto, BigDecimal precoProduto, boolean promocaoProduto, BigDecimal porcentagemPromocaoProduto, Date dtCadastroProduto, double alturaProduto, double larguraProduto, double comprimentoProduto, double pesoProduto, List<Imagem> imagens, Set<Categoria> categorias, int contadorProduto) {
        this.codigoProduto = codigoProduto;
        this.tituloProduto = tituloProduto;
        this.quantEstoqueProduto = quantEstoqueProduto;
        this.avaliacaoProduto = avaliacaoProduto;
        this.marcaProduto = marcaProduto;
        this.modeloProduto = modeloProduto;
        this.corProduto = corProduto;
        this.generoProduto = generoProduto;
        this.tamanhoProduto = tamanhoProduto;
        this.lenteCorProduto = lenteCorProduto;
        this.lenteTipoProduto = lenteTipoProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.promocaoProduto = promocaoProduto;
        this.porcentagemPromocaoProduto = porcentagemPromocaoProduto;
        this.dtCadastroProduto = dtCadastroProduto;
        this.alturaProduto = alturaProduto;
        this.larguraProduto = larguraProduto;
        this.comprimentoProduto = comprimentoProduto;
        this.pesoProduto = pesoProduto;
        this.imagens = imagens;
        this.categorias = categorias;
        this.contadorProduto = contadorProduto;
    }

    public int getContadorProduto() {
        return contadorProduto;
    }

    public void setContadorProduto(int contadorProduto) {
        this.contadorProduto = contadorProduto;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getTituloProduto() {
        return tituloProduto;
    }

    public void setTituloProduto(String tituloProduto) {
        this.tituloProduto = tituloProduto;
    }

    public int getQuantEstoqueProduto() {
        return quantEstoqueProduto;
    }

    public void setQuantEstoqueProduto(int quantEstoqueProduto) {
        this.quantEstoqueProduto = quantEstoqueProduto;
    }

    public int getAvaliacaoProduto() {
        return avaliacaoProduto;
    }

    public void setAvaliacaoProduto(int avaliacaoProduto) {
        this.avaliacaoProduto = avaliacaoProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public String getModeloProduto() {
        return modeloProduto;
    }

    public void setModeloProduto(String modeloProduto) {
        this.modeloProduto = modeloProduto;
    }

    public String getCorProduto() {
        return corProduto;
    }

    public void setCorProduto(String corProduto) {
        this.corProduto = corProduto;
    }

    public char getGeneroProduto() {
        return generoProduto;
    }

    public void setGeneroProduto(char generoProduto) {
        this.generoProduto = generoProduto;
    }

    public char getTamanhoProduto() {
        return tamanhoProduto;
    }

    public void setTamanhoProduto(char tamanhoProduto) {
        this.tamanhoProduto = tamanhoProduto;
    }

    public String getLenteCorProduto() {
        return lenteCorProduto;
    }

    public void setLenteCorProduto(String lenteCorProduto) {
        this.lenteCorProduto = lenteCorProduto;
    }

    public String getLenteTipoProduto() {
        return lenteTipoProduto;
    }

    public void setLenteTipoProduto(String lenteTipoProduto) {
        this.lenteTipoProduto = lenteTipoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(BigDecimal precoProduto) {
        this.precoProduto = precoProduto;
    }

    public boolean isPromocaoProduto() {
        return promocaoProduto;
    }

    public void setPromocaoProduto(boolean promocaoProduto) {
        this.promocaoProduto = promocaoProduto;
    }

    public BigDecimal getPorcentagemPromocaoProduto() {
        return porcentagemPromocaoProduto;
    }

    public void setPorcentagemPromocaoProduto(BigDecimal porcentagemPromocaoProduto) {
        this.porcentagemPromocaoProduto = porcentagemPromocaoProduto;
    }

    public Date getDtCadastroProduto() {
        return dtCadastroProduto;
    }

    public void setDtCadastroProduto(Date dtCadastroProduto) {
        this.dtCadastroProduto = dtCadastroProduto;
    }

    public double getAlturaProduto() {
        return alturaProduto;
    }

    public void setAlturaProduto(double alturaProduto) {
        this.alturaProduto = alturaProduto;
    }

    public double getLarguraProduto() {
        return larguraProduto;
    }

    public void setLarguraProduto(double larguraProduto) {
        this.larguraProduto = larguraProduto;
    }

    public double getComprimentoProduto() {
        return comprimentoProduto;
    }

    public void setComprimentoProduto(double comprimentoProduto) {
        this.comprimentoProduto = comprimentoProduto;
    }

    public double getPesoProduto() {
        return pesoProduto;
    }

    public void setPesoProduto(double pesoProduto) {
        this.pesoProduto = pesoProduto;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }
}
