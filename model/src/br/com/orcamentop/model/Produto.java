package br.com.orcamentop.model;


/**
 * 
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class Produto {
    private int codigo;
    private String descricao;
    private double valor;

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
