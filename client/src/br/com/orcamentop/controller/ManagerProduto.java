package br.com.orcamentop.controller;

import br.com.orcamentop.dto.ListaProduto;
import br.com.orcamentop.dto.Produto;
import br.com.orcamentop.interfaces.ControllerProduto;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class ManagerProduto implements ControllerProduto {

    private final ListaProduto lista;

    public ManagerProduto() {
        this.lista = PersistenciaXML.getInstance().loadProdutos();
    }
    
    @Override
    public boolean gravar(Produto produto) {
        if (produto == null) {
            return false;
        }
        
        this.lista.getLista().add(produto);
        PersistenciaXML.getInstance().save(lista);
        return true;
    }

    @Override
    public boolean alterar(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaProduto carregar() {
        return lista;
    }

    @Override
    public int gerarNovoCodigo() {
        Produto p = lista.getLista().stream().max((o1, o2) -> {
            Produto p1 = (Produto) o1;
            Produto p2 = (Produto) o2;
            
            return p1.getCodigo() > p2.getCodigo() ? 1 : -1;
        }).get();
        
        return p.getCodigo() + 1;
    }

}
