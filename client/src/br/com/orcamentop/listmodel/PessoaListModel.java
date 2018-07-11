package br.com.orcamentop.listmodel;

import br.com.orcamentop.dto.ListaPessoa;
import br.com.orcamentop.dto.Pessoa;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class PessoaListModel implements ListModel {

    private final ListaPessoa listaPessoa;

    public PessoaListModel(ListaPessoa listaPessoa) {
        this.listaPessoa = listaPessoa;
    }
    
    @Override
    public int getSize() {
        return listaPessoa.getLista().size();
    }

    @Override
    public Object getElementAt(int index) {
        Pessoa pessoa = getPessoaAt(index);
        
        if (pessoa != null) {
            return pessoa.getNome();
        } else {
            return "";
        }
    }
    
    public Pessoa getPessoaAt(int index) {
        if (index < 0 || index > getSize()) {
            return null;
        }
        
        return listaPessoa.getLista().get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }

}
