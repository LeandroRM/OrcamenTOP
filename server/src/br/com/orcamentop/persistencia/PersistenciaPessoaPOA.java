package br.com.orcamentop.persistencia;

import br.com.orcamentop.dto.ListaPessoa;
import br.com.orcamentop.dto.ListaPessoaHelper;
import java.util.HashMap;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;
import org.omg.PortableServer.POA;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public abstract class PersistenciaPessoaPOA extends org.omg.PortableServer.Servant
        implements PersistenciaPessoaOperations, InvokeHandler {

    private static HashMap _methods = new HashMap();

    // Type-specific CORBA::Object operations
    private static final String[] ID = {"IDL:br/com/orcamentop/persistencia/PersistenciaPessoa:1.0"};
    
    static {
        _methods.put("salvar", new Integer(0));
        _methods.put("carregar", new Integer(1));
    }

    @Override
    public OutputStream _invoke(String method, InputStream in, ResponseHandler rh) {
        OutputStream out = null;
        Integer __method = (Integer) _methods.get(method);
        
        if (__method == null) {
            throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
        }

        ListaPessoa listaPessoa;
        boolean bResult;
        
        switch (__method) {
            case 0: //salvar
                listaPessoa = ListaPessoaHelper.read(in);
                bResult = this.salvar(listaPessoa);
                out = rh.createReply();
                out.write_boolean(bResult);
                break;
            case 1: //carregar
                listaPessoa = this.carregar();
                out = rh.createReply();
                ListaPessoaHelper.write(out, listaPessoa);
                break;
            default:
                throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
        }

        return out;
    } // _invoke

    @Override
    public String[] _all_interfaces(POA poa, byte[] objectId) {
        return (String[]) ID.clone();
    }

    public PersistenciaPessoa _this() {
        return PersistenciaPessoaHelper.narrow(super._this_object());
    }

    public PersistenciaPessoa _this(org.omg.CORBA.ORB orb) {
        return PersistenciaPessoaHelper.narrow(super._this_object(orb));
    }
}
