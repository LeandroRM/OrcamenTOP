package br.com.orcamentop.model;

import br.com.orcamentop.interfaces.XMLParser;
import com.thoughtworks.xstream.XStream;
import java.util.List;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class Orcamento 
        implements XMLParser{
    private final int codigo;
    private List<Produto> listaProduto;
    private List<Pessoa> listaPessoa;

    public Orcamento(int codigo) {
        this.codigo = codigo;
    }
    
    public double getValorTotal() {
        double valor = 0;
        
        valor = getListaProduto().stream()
                .map((produto) -> produto.getValor())
                .reduce(valor, (accumulator, _item) -> accumulator + _item);
        
        return valor;
    }
    
    @Override
    public String parseToXML() {
        XStream parser = getParser();
        return parser.toXML(this);
    }

    @Override
    public XStream getParser() {
        XStream parser = new XStream();
        parser.alias("orcamento", Orcamento.class);
        return parser;
    }

    @Override
    public String getDir() {
        return "Orcamento/";
    }
    
    @Override
    public String getFileName() {
        return Integer.toString(getCodigo()) + ".xml";
    }

    public void addProduto(Produto produto) {
        listaProduto.add(produto);
    }

    public void addPessoa(Pessoa pessoa) {
        listaPessoa.add(pessoa);
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public List<Pessoa> getListaPessoa() {
        return listaPessoa;
    }
}
