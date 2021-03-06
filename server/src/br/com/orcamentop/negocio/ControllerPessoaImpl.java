package br.com.orcamentop.negocio;

import br.com.orcamentop.Servidor;
import br.com.orcamentop.dto.ListaPessoa;
import br.com.orcamentop.dto.Pessoa;
import br.com.orcamentop.persistencia.PersistenciaPessoa;
import br.com.orcamentop.persistencia.PersistenciaPessoaHelper;
import java.util.List;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class ControllerPessoaImpl extends ControllerPessoaPOA {

    private ListaPessoa lista;
    private PersistenciaPessoa persistencia;
    
    public ControllerPessoaImpl() {
        this(null);
    }

    public ControllerPessoaImpl(ListaPessoa lista) {
        this.lista = lista;
        this.persistencia = getPersistenciaPessoaRef();
        carregar();
    }
    
    @Override
    public boolean gravar(Pessoa pessoa) {
        if (pessoa == null) {
            return false;
        }
        
        List<Pessoa> listaPessoas = lista.getLista();
        if (pessoa.getCodigo() == 0) { //Adiciona
            adicionar(listaPessoas, pessoa);
        } else { //Altera
            if (!alterar(listaPessoas, pessoa)) {
                return false;
            }
        }
        
        persistencia.salvar(lista);
        return true;
    }
    
    private void adicionar(final List<Pessoa> listaPessoas, Pessoa pessoa) {
        int novoCodigo = 1;
        if (!listaPessoas.isEmpty()) {
            novoCodigo = listaPessoas.get(listaPessoas.size() - 1).getCodigo() + 1;
        } 

        pessoa.setCodigo(novoCodigo);
        listaPessoas.add(pessoa);
    }
    
    private boolean alterar(final List<Pessoa> listaPessoas, Pessoa pessoa) {
        for (Pessoa p : listaPessoas) {
            if (p.getCodigo() == pessoa.getCodigo()) {
                p.setNome(pessoa.getNome());
                p.setTelefone(pessoa.getTelefone());
                p.setEmail(pessoa.getEmail());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remover(Pessoa pessoa) {
        if (pessoa == null) {
            return false;
        }
        int index = getIndex(pessoa);
        if (index > -1) {
            lista.getLista().remove(index);
            persistencia.salvar(lista);
        }
        return true;
    }

    @Override
    public ListaPessoa carregar() {
        if (lista == null) {
            this.lista = this.persistencia.carregar();
        }
        
        return lista;
    }
    
    private int getIndex(Pessoa pessoa) {
        int index = -1;
        for (int i = 0; i < lista.getLista().size(); i++) {
            if (lista.getLista().get(i).getCodigo() == pessoa.getCodigo()) {
                index = i;
                break;
            }
        }
        return index;
    }

    private PersistenciaPessoa getPersistenciaPessoaRef() {
        PersistenciaPessoa pp = null;
        try {
            ORB orb = Servidor.getInstance().getOrb();
            //Obtem referencia para o servico de nomes
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            //Obtem referencia para o servidor
            String name = "PersistenciaPessoa";
            pp = PersistenciaPessoaHelper.narrow(ncRef.resolve_str(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pp;
    }
    
    public void setLista(ListaPessoa lista) {
        this.lista = lista;
    }
}
