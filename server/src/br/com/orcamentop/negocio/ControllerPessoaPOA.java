package br.com.orcamentop.negocio;

import br.com.orcamentop.dto.ListaPessoa;
import br.com.orcamentop.dto.ListaPessoaHelper;
import br.com.orcamentop.dto.Pessoa;
import br.com.orcamentop.dto.PessoaHelper;
import java.util.HashMap;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public abstract class ControllerPessoaPOA extends org.omg.PortableServer.Servant
        implements ControllerPessoaOperations, org.omg.CORBA.portable.InvokeHandler {

    private static HashMap _methods = new HashMap();

    // Type-specific CORBA::Object operations
    private static final String[] ID = {"IDL:br/com/orcamentop/negocio/ControllerPessoa:1.0"};
    
    static {
        _methods.put("gravar", new Integer(0));
        _methods.put("remover", new Integer(1));
        _methods.put("carregar", new Integer(2));
    }

    @Override
    public OutputStream _invoke(String method, InputStream in, ResponseHandler rh) {
        OutputStream out = null;
        Integer __method = (Integer) _methods.get(method);
        
        if (__method == null) {
            throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
        }

        Pessoa pessoa;
        boolean bResult;
        
        switch (__method) {
            case 0: //gravar
                pessoa = PessoaHelper.read(in);
                bResult = this.gravar(pessoa);
                out = rh.createReply();
                out.write_boolean(bResult);
                break;
            case 1: //remover
                pessoa = PessoaHelper.read(in);
                bResult = this.remover(pessoa);
                out = rh.createReply();
                out.write_boolean(bResult);
                break;
            case 2: //carregar
                ListaPessoa lista = this.carregar();
                out = rh.createReply();
                ListaPessoaHelper.write(out, lista);
                break;
            default:
                throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
        }

        return out;
    } // _invoke

    @Override
    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] objectId) {
        return (String[]) ID.clone();
    }

    public ControllerPessoa _this() {
        return ControllerPessoaHelper.narrow(
                super._this_object());
    }

    public ControllerPessoa _this(org.omg.CORBA.ORB orb) {
        return ControllerPessoaHelper.narrow(
                super._this_object(orb));
    }
}
