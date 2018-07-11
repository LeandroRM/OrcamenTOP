package br.com.orcamentop.listmodel;

import br.com.orcamentop.dto.ListaProduto;
import br.com.orcamentop.dto.Produto;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class ProdutoListModel implements ListModel {

    private final ListaProduto listaProduto;

    public ProdutoListModel(ListaProduto listaProduto) {
        this.listaProduto = listaProduto;
    }
    
    @Override
    public int getSize() {
        return listaProduto.getLista().size();
    }

    @Override
    public Object getElementAt(int index) {
        Produto produto = getProdutoAt(index);
        
        if (produto != null) {
            return produto.getDescricao();
        } else {
            return "";
        }
    }
    
    public Produto getProdutoAt(int index) {
        if (index < 0 || index > getSize()) {
            return null;
        }
        
        return listaProduto.getLista().get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }

}
