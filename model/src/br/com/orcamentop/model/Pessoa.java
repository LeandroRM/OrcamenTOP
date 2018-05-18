package br.com.orcamentop.model;

import br.com.orcamentop.interfaces.XMLParser;
import com.thoughtworks.xstream.XStream;

/**
 * 
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class Pessoa 
        implements XMLParser {
    private final int codigo;
    private String nome;
    private String telefone;
    private String email;

    public Pessoa(int codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String parseToXML() {
        XStream parser = getParser();
        return parser.toXML(this);
    }

    @Override
    public XStream getParser() {
        XStream parser = new XStream();
        parser.alias("pessoa", Pessoa.class);
        
        return parser;
    }

    @Override
    public String getDir() {
        return "Pessoa.xml";
    }
    
    @Override
    public String getFileName() {
        return Integer.toString(getCodigo()) + ".xml";
    }

    public int getCodigo() {
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
