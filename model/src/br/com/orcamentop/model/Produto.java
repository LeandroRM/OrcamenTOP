package br.com.orcamentop.model;

import br.com.orcamentop.interfaces.XMLParser;
import com.thoughtworks.xstream.XStream;

/**
 * 
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class Produto 
        implements XMLParser {
    private int codigo;
    private String descricao;
    private double valor;

    @Override
    public String parseToXML() {
        XStream parser = getParser();
        return parser.toXML(this);
    }

    @Override
    public XStream getParser() {
        XStream parser = new XStream();
        parser.alias("produto", Produto.class);
        return parser;
    }
    
    @Override
    public String getDir() {
        return "Produto/";
    }
    
    @Override
    public String getFileName() {
        return Integer.toString(getCodigo()) + ".xml";
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
