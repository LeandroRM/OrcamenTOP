package br.com.orcamentop.model;

import java.util.Date;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class Orcamento {
    private final int codigo;
    private final ListaProduto listaProduto;
    private final ListaPessoa listaPessoa;
    
    private String descricao;
    private String observacao;
    private String localCompra;
    private Date dataCompra;
    private Date dataOrcamentoCriado;

    /**
     * Cria um novo orçamento com a hora atual
     * 
     * @param codigo 
     */
    public Orcamento(int codigo) {
        this(codigo, new Date(System.currentTimeMillis()));
    }
    
    public Orcamento(int codigo, Date dataOrcamentoCriado) {
        this.codigo = codigo;
        this.listaProduto = new ListaProduto();
        this.listaPessoa = new ListaPessoa();
    }

    public Orcamento(int codigo, ListaProduto listaProduto, ListaPessoa listaPessoa) {
        this.codigo = codigo;
        this.listaProduto = listaProduto;
        this.listaPessoa = listaPessoa;
    }
    
    public double getValorTotal() {
        double valor = 0;
        
        valor = getListaProduto().getLista().stream()
                .map((produto) -> produto.getValor())
                .reduce(valor, (accumulator, _item) -> accumulator + _item);
        
        return valor;
    }
    
    public double getValorPorPessoa() {
        return getValorTotal() / getQuantidadePessoas();
    }
    
    public int getQuantidadePessoas() {
        return getListaPessoa().getLista().size();
    }
    
    public void addProduto(Produto produto) {
        getListaProduto().getLista().add(produto);
    }

    public void addPessoa(Pessoa pessoa) {
        getListaPessoa().getLista().add(pessoa);
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public ListaProduto getListaProduto() {
        return listaProduto;
    }

    public ListaPessoa getListaPessoa() {
        return listaPessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getLocalCompra() {
        return localCompra;
    }

    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataOrcamentoCriado() {
        return dataOrcamentoCriado;
    }
}
