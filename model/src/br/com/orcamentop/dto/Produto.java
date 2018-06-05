package br.com.orcamentop.dto;


/**
 * 
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class Produto {
    private final int codigo;
    private String descricao;
    private double valor;

    public Produto(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
