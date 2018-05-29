package br.com.orcamentop.model;

import br.com.orcamentop.interfaces.XMLParser;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class ListaOrcamento implements XMLParser{
    private final List<Orcamento> lista;

    public ListaOrcamento() {
        this.lista = new ArrayList<>();
    }

    public ListaOrcamento(List<Orcamento> lista) {
        this.lista = lista;
    }

    public List<Orcamento> getLista() {
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
        parser.alias("orcamentos", ListaOrcamento.class);
        parser.alias("orcamento", Produto.class);
        parser.addImplicitCollection(ListaOrcamento.class, "lista");
        
        return parser;
    }

    @Override
    public String getFileName() {
        return "Orcamentos.xml";
    }
}
