package br.com.orcamentop.controller;

import br.com.orcamentop.dto.ListaPessoa;
import br.com.orcamentop.dto.Pessoa;
import br.com.orcamentop.interfaces.ControllerPessoa;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class ManagerPessoa implements ControllerPessoa {

    private final ListaPessoa lista;

    public ManagerPessoa() {
        this.lista = PersistenciaXML.getInstance().loadPessoas();
    }
    
    @Override
    public boolean gravar(Pessoa pessoa) {
        if (pessoa == null) {
            return false;
        }
        
        lista.getLista().add(pessoa);
        PersistenciaXML.getInstance().save(lista);
        return true;
    }

    @Override
    public boolean alterar(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaPessoa carregar() {
        return lista;
    }

    @Override
    public int gerarNovoCodigo() {
        Pessoa p = lista.getLista().stream().max((o1, o2) -> {
            Pessoa p1 = (Pessoa) o1;
            Pessoa p2 = (Pessoa) o2;
            
            return p1.getCodigo() > p2.getCodigo() ? 1 : -1;
        }).get();
        
        return p.getCodigo() + 1;
    }
}
