package br.com.orcamentop.negocio;

import br.com.orcamentop.Servidor;
import br.com.orcamentop.dto.ListaOrcamento;
import br.com.orcamentop.dto.Orcamento;
import br.com.orcamentop.persistencia.PersistenciaOrcamento;
import br.com.orcamentop.persistencia.PersistenciaOrcamentoHelper;
import java.util.List;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class ControllerOrcamentoImpl extends ControllerOrcamentoPOA {

    private ListaOrcamento lista;
    private PersistenciaOrcamento persistencia;
    
    public ControllerOrcamentoImpl() {
        this(null);
    }

    public ControllerOrcamentoImpl(ListaOrcamento lista) {
        this.lista = lista;
        this.persistencia = getPersistenciaOrcamentoRef();
        carregar();
    }
    
    @Override
    public boolean gravar(Orcamento orcamento) {
        if (orcamento == null) {
            return false;
        }
        List<Orcamento> listaOrcamentos = lista.getLista();
        if (orcamento.getCodigo() == 0) { //Adiciona
            adicionar(listaOrcamentos, orcamento);
        } else { //Altera
            if (!alterar(listaOrcamentos, orcamento)) {
                return false;
            }
        }
        persistencia.salvar(lista);
        return true;
    }
    
    private void adicionar(final List<Orcamento> listaOrcamentos, Orcamento orcamento) {
        int novoCodigo = 1;
        if (!listaOrcamentos.isEmpty()) {
            novoCodigo = listaOrcamentos.get(listaOrcamentos.size() - 1).getCodigo() + 1;
        } 

        orcamento.setCodigo(novoCodigo);
        listaOrcamentos.add(orcamento);
    }
    
    private boolean alterar(final List<Orcamento> listaOrcamentos, Orcamento orcamento) {
        for (Orcamento p : listaOrcamentos) {
            if (p.getCodigo() == orcamento.getCodigo()) {
                p.setDataCompra(orcamento.getDataCompra());
                p.setDataCriado(orcamento.getDataCriado());
                p.setDescricao(orcamento.getDescricao());
                p.setListaPessoa(orcamento.getListaPessoa());
                p.setListaProduto(orcamento.getListaProduto());
                p.setLocalCompra(orcamento.getLocalCompra());
                p.setObservacao(orcamento.getObservacao());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remover(Orcamento orcamento) {
        if (orcamento == null) {
            return false;
        }
        int index = getIndex(orcamento);
        if (index > -1) {
            lista.getLista().remove(index);
            persistencia.salvar(lista);
        }
        return true;
    }

    @Override
    public ListaOrcamento carregar() {
        if (lista == null) {
            this.lista = this.persistencia.carregar();
        }
        
        return lista;
    }
    
    private int getIndex(Orcamento orcamento) {
        int index = -1;
        for (int i = 0; i < lista.getLista().size(); i++) {
            if (lista.getLista().get(i).getCodigo() == orcamento.getCodigo()) {
                index = i;
                break;
            }
        }
        return index;
    }

    private PersistenciaOrcamento getPersistenciaOrcamentoRef() {
        PersistenciaOrcamento pp = null;
        try {
            ORB orb = Servidor.getInstance().getOrb();
            //Obtem referencia para o servico de nomes
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            //Obtem referencia para o servidor
            String name = "PersistenciaOrcamento";
            pp = PersistenciaOrcamentoHelper.narrow(ncRef.resolve_str(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pp;
    }
    
    public void setLista(ListaOrcamento lista) {
        this.lista = lista;
    }
}
