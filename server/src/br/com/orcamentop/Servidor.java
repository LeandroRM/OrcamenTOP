package br.com.orcamentop;

import br.com.orcamentop.negocio.ControllerOrcamento;
import br.com.orcamentop.negocio.ControllerOrcamentoHelper;
import br.com.orcamentop.negocio.ControllerOrcamentoImpl;
import br.com.orcamentop.negocio.ControllerPessoa;
import br.com.orcamentop.negocio.ControllerPessoaHelper;
import br.com.orcamentop.negocio.ControllerPessoaImpl;
import br.com.orcamentop.negocio.ControllerProduto;
import br.com.orcamentop.negocio.ControllerProdutoHelper;
import br.com.orcamentop.negocio.ControllerProdutoImpl;
import br.com.orcamentop.persistencia.PersistenciaOrcamento;
import br.com.orcamentop.persistencia.PersistenciaOrcamentoHelper;
import br.com.orcamentop.persistencia.PersistenciaOrcamentoImpl;
import br.com.orcamentop.persistencia.PersistenciaPessoa;
import br.com.orcamentop.persistencia.PersistenciaPessoaHelper;
import br.com.orcamentop.persistencia.PersistenciaPessoaImpl;
import br.com.orcamentop.persistencia.PersistenciaProduto;
import br.com.orcamentop.persistencia.PersistenciaProdutoHelper;
import br.com.orcamentop.persistencia.PersistenciaProdutoImpl;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class Servidor {
    
    private static Servidor instance;
    private ORB orb;
    
    private Servidor() {
        try {
            java.util.Properties props = System.getProperties();
            props.put("org.omg.CORBA.ORBInitialPort", "1050");
            props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
            props.put("com.sun.CORBA.giop.ORBGIOPVersion", "1.0");
            //Cria e inicializa o ORB
            orb = ORB.init(new String[]{}, props);
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
            e.printStackTrace(System.out);
        }
    }
    
    public static Servidor getInstance() {
        if (instance == null) {
            instance = new Servidor();
        }
        
        return instance;
    }
    
    public void run() {
        // Aguarda chamadas dos clientes
        System.out.println("Server waiting connections ....");
        orb.run();
    }
    
    private void initPersistencias() {
        try {
            // Ativa o POA
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            // Obtém uma referência para o servidor de nomes
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Cria a implementação e registra no ORB
            PersistenciaPessoaImpl pessoaImpl = new PersistenciaPessoaImpl();
            // Pega a referência do servidor
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(pessoaImpl);
            PersistenciaPessoa href = PersistenciaPessoaHelper.narrow(ref);
            // Registra o servidor no servico de nomes
            String name = "PersistenciaPessoa";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);
            
            // Cria a implementação e registra no ORB
            PersistenciaProdutoImpl produtoImpl = new PersistenciaProdutoImpl();
            // Pega a referência do servidor
            ref = rootpoa.servant_to_reference(produtoImpl);
            PersistenciaProduto produtoHref = PersistenciaProdutoHelper.narrow(ref);
            // Registra o servidor no servico de nomes
            name = "PersistenciaProduto";
            path = ncRef.to_name(name);
            ncRef.rebind(path, produtoHref);
            
            // Cria a implementação e registra no ORB
            PersistenciaOrcamentoImpl orcamentoImpl = new PersistenciaOrcamentoImpl();
            // Pega a referência do servidor
            ref = rootpoa.servant_to_reference(orcamentoImpl);
            PersistenciaOrcamento orcamentoHref = PersistenciaOrcamentoHelper.narrow(ref);
            // Registra o servidor no servico de nomes
            name = "PersistenciaOrcamento";
            path = ncRef.to_name(name);
            ncRef.rebind(path, orcamentoHref);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    private void initControllers() {
        try {
            // Ativa o POA
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            // Obtém uma referência para o servidor de nomes
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            // Cria a implementação e registra no ORB
            ControllerPessoaImpl impl = new ControllerPessoaImpl();
            // Pega a referência do servidor
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(impl);
            ControllerPessoa href = ControllerPessoaHelper.narrow(ref);
            // Registra o servidor no servico de nomes
            String name = "ControllerPessoa";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);
            
            // Cria a implementação e registra no ORB
            ControllerProdutoImpl produtoImpl = new ControllerProdutoImpl();
            // Pega a referência do servidor
            ref = rootpoa.servant_to_reference(produtoImpl);
            ControllerProduto produtoHref = ControllerProdutoHelper.narrow(ref);
            // Registra o servidor no servico de nomes
            name = "ControllerProduto";
            path = ncRef.to_name(name);
            ncRef.rebind(path, produtoHref);
            
            // Cria a implementação e registra no ORB
            ControllerOrcamentoImpl orcamentoImpl = new ControllerOrcamentoImpl();
            // Pega a referência do servidor
            ref = rootpoa.servant_to_reference(orcamentoImpl);
            ControllerOrcamento orcamentoHref = ControllerOrcamentoHelper.narrow(ref);
            // Registra o servidor no servico de nomes
            name = "ControllerOrcamento";
            path = ncRef.to_name(name);
            ncRef.rebind(path, orcamentoHref);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void main(String args[]) {
        Servidor servidor = Servidor.getInstance();
        servidor.initPersistencias();
        servidor.initControllers();
        servidor.run();
        System.out.println("Ending Server.");
    }

    public ORB getOrb() {
        return orb;
    }
}
