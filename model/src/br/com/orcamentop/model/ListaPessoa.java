package br.com.orcamentop.model;

import br.com.orcamentop.interfaces.XMLParser;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class ListaPessoa implements XMLParser{
    private final ArrayList<Pessoa> lista;

    public ListaPessoa() {
        this.lista = new ArrayList<>();
    }

    public ListaPessoa(ArrayList<Pessoa> lista) {
        this.lista = lista;
    }

    public ArrayList<Pessoa> getLista() {
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
        parser.alias("pessoas", ListaPessoa.class);
        parser.alias("pessoa", Pessoa.class);
        parser.addImplicitCollection(ListaPessoa.class, "lista", Pessoa.class);
        
        return parser;
    }

    @Override
    public String getFileName() {
        return "Pessoas.xml";
    }
}
