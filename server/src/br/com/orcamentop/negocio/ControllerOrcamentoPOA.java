package br.com.orcamentop.negocio;

import br.com.orcamentop.dto.ListaOrcamento;
import br.com.orcamentop.dto.ListaOrcamentoHelper;
import br.com.orcamentop.dto.Orcamento;
import br.com.orcamentop.dto.OrcamentoHelper;
import java.util.HashMap;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public abstract class ControllerOrcamentoPOA extends org.omg.PortableServer.Servant
        implements ControllerOrcamentoOperations, org.omg.CORBA.portable.InvokeHandler {

    private static HashMap _methods = new HashMap();

    // Type-specific CORBA::Object operations
    private static final String[] ID = {"IDL:br/com/orcamentop/negocio/ControllerOrcamento:1.0"};
    
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

        Orcamento orcamento;
        boolean bResult;
        
        switch (__method) {
            case 0: //gravar
                orcamento = OrcamentoHelper.read(in);
                bResult = this.gravar(orcamento);
                out = rh.createReply();
                out.write_boolean(bResult);
                break;
            case 1: //remover
                orcamento = OrcamentoHelper.read(in);
                bResult = this.remover(orcamento);
                out = rh.createReply();
                out.write_boolean(bResult);
                break;
            case 2: //carregar
                ListaOrcamento lista = this.carregar();
                out = rh.createReply();
                ListaOrcamentoHelper.write(out, lista);
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

    public ControllerOrcamento _this() {
        return ControllerOrcamentoHelper.narrow(
                super._this_object());
    }

    public ControllerOrcamento _this(org.omg.CORBA.ORB orb) {
        return ControllerOrcamentoHelper.narrow(
                super._this_object(orb));
    }
}
