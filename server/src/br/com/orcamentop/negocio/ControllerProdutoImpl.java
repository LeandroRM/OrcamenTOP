package br.com.orcamentop.negocio;

import br.com.orcamentop.Servidor;
import br.com.orcamentop.dto.ListaProduto;
import br.com.orcamentop.dto.Produto;
import br.com.orcamentop.persistencia.PersistenciaProduto;
import br.com.orcamentop.persistencia.PersistenciaProdutoHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class ControllerProdutoImpl extends ControllerProdutoPOA {

    private ListaProduto lista;
    private PersistenciaProduto persistencia;
    
    public ControllerProdutoImpl() {
        this(null);
    }

    public ControllerProdutoImpl(ListaProduto lista) {
        this.lista = lista;
        this.persistencia = getPersistenciaProdutoRef();
        carregar();
    }
    
    @Override
    public boolean gravar(Produto produto) {
        if (produto == null) {
            return false;
        }
        
        lista.getLista().add(produto);
        persistencia.salvar(lista);
        return true;
    }

    @Override
    public boolean remover(Produto produto) {
        if (produto == null) {
            return false;
        }
        int index = getIndex(produto);
        if (index > -1) {
            lista.getLista().remove(index);
            persistencia.salvar(lista);
        }
        return true;
    }

    @Override
    public ListaProduto carregar() {
        if (lista == null) {
            this.lista = this.persistencia.carregar();
        }
        
        return lista;
    }
    
    private int getIndex(Produto produto) {
        int index = -1;
        for (int i = 0; i < lista.getLista().size(); i++) {
            if (lista.getLista().get(i).getCodigo() == produto.getCodigo()) {
                index = i;
                break;
            }
        }
        return index;
    }

    private PersistenciaProduto getPersistenciaProdutoRef() {
        PersistenciaProduto pp = null;
        try {
            ORB orb = Servidor.getInstance().getOrb();
            //Obtem referencia para o servico de nomes
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            //Obtem referencia para o servidor
            String name = "PersistenciaProduto";
            pp = PersistenciaProdutoHelper.narrow(ncRef.resolve_str(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pp;
    }
    
    public void setLista(ListaProduto lista) {
        this.lista = lista;
    }
}
