package br.com.orcamentop.dto;

/**
 * br/com/orcamentop/Orcamento.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.2" from orcamentop.idl Domingo, 10 de Junho de 2018
 * 23h26min58s BRT
 */
public final class Orcamento implements org.omg.CORBA.portable.IDLEntity {

    private int codigo = (int) 0;
    private ListaProduto listaProduto = null;
    private ListaPessoa listaPessoa = null;
    private String descricao = null;
    private String observacao = null;
    private String localCompra = null;
    private long dataCompra = (long) 0;
    private long dataCriado = (long) 0;

    public Orcamento() {
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ListaProduto getListaProduto() {
        return this.listaProduto;
    }

    public void setListaProduto(ListaProduto listaProduto) {
        this.listaProduto = listaProduto;
    }

    public ListaPessoa getListaPessoa() {
        return this.listaPessoa;
    }

    public void setListaPessoa(ListaPessoa listaPessoa) {
        this.listaPessoa = listaPessoa;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getLocalCompra() {
        return this.localCompra;
    }

    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }

    public long getDataCompra() {
        return this.dataCompra;
    }

    public void setDataCompra(long dataCompra) {
        this.dataCompra = dataCompra;
    }

    public long getDataCriado() {
        return this.dataCriado;
    }

    public void setDataCriado(long dataCriado) {
        this.dataCriado = dataCriado;
    }
} // class Orcamento
