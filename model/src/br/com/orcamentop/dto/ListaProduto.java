package br.com.orcamentop.dto;

import br.com.orcamentop.interfaces.XMLParser;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class ListaProduto implements XMLParser {
    private final List<Produto> lista;

    public ListaProduto() {
        this.lista = new ArrayList<>();
    }

    public ListaProduto(List<Produto> lista) {
        this.lista = lista;
    }

    public List<Produto> getLista() {
        return lista;
    }

    @Override
    public String parseToXML() {
        XStream parser = getParser();
        return parser.toXML(this);
    }

    @Override
    public XStream getParser() {
        XStream parser = new XStream();
        parser.alias("produtos", ListaProduto.class);
        parser.alias("produto", Produto.class);
        parser.addImplicitCollection(ListaProduto.class, "lista");
        
        return parser;
    }

    @Override
    public String getFileName() {
        return "Produtos.xml";
    }
}
