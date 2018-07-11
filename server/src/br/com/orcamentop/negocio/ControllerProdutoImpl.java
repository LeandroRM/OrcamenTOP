package br.com.orcamentop.negocio;

import br.com.orcamentop.Servidor;
import br.com.orcamentop.dto.ListaProduto;
import br.com.orcamentop.dto.Produto;
import br.com.orcamentop.persistencia.PersistenciaProduto;
import br.com.orcamentop.persistencia.PersistenciaProdutoHelper;
import java.util.List;
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
        
        List<Produto> listaProduto = lista.getLista();
        if (produto.getCodigo() == 0) { //Adiciona
            adicionar(listaProduto, produto);
        } else { //Altera
            if (!alterar(listaProduto, produto)) {
                return false;
            }
        }

        persistencia.salvar(lista);
        return true;
    }
    
    private void adicionar(final List<Produto> listaProdutos, Produto produto) {
        int novoCodigo = 1;
        if (!listaProdutos.isEmpty()) {
            novoCodigo = listaProdutos.get(listaProdutos.size() - 1).getCodigo() + 1;
        } 

        produto.setCodigo(novoCodigo);
        listaProdutos.add(produto);
    }
    
    private boolean alterar(final List<Produto> listaProdutos, Produto produto) {
        for (Produto p : listaProdutos) {
            if (p.getCodigo() == produto.getCodigo()) {
                p.setDescricao(produto.getDescricao());
                p.setValor(produto.getValor());
                return true;
            }
        }
        return false;
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
