package br.com.orcamentop.persistencia;

import br.com.orcamentop.dto.ListaProduto;
import br.com.orcamentop.dto.ListaProdutoHelper;
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
public abstract class PersistenciaProdutoPOA extends org.omg.PortableServer.Servant
        implements PersistenciaProdutoOperations, InvokeHandler {

    private static HashMap _methods = new HashMap();

    // Type-specific CORBA::Object operations
    private static final String[] ID = {"IDL:br/com/orcamentop/persistencia/PersistenciaProduto:1.0"};
    
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

        ListaProduto listaProduto;
        boolean bResult;
        
        switch (__method) {
            case 0: //salvar
                listaProduto = ListaProdutoHelper.read(in);
                bResult = this.salvar(listaProduto);
                out = rh.createReply();
                out.write_boolean(bResult);
                break;
            case 1: //carregar
                listaProduto = this.carregar();
                out = rh.createReply();
                ListaProdutoHelper.write(out, listaProduto);
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

    public PersistenciaProduto _this() {
        return PersistenciaProdutoHelper.narrow(super._this_object());
    }

    public PersistenciaProduto _this(org.omg.CORBA.ORB orb) {
        return PersistenciaProdutoHelper.narrow(super._this_object(orb));
    }
}
