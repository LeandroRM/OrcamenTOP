package br.com.orcamentop.dto;

import br.com.orcamentop.interfaces.XMLParser;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class ListaPessoa implements XMLParser {
    private final List<Pessoa> lista;

    public ListaPessoa() {
        this.lista = new ArrayList<>();
    }

    public ListaPessoa(List<Pessoa> lista) {
        this.lista = lista;
    }

    public List<Pessoa> getLista() {
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
        // clear out existing permissions and set own ones
        parser.addPermission(NoTypePermission.NONE);
        // allow some basics
        parser.addPermission(NullPermission.NULL);
        parser.addPermission(PrimitiveTypePermission.PRIMITIVES);
        parser.addPermission(AnyTypePermission.ANY);
        parser.allowTypeHierarchy(Collection.class);
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
