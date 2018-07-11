package br.com.orcamentop.negocio;

import br.com.orcamentop.dto.ListaProduto;
import br.com.orcamentop.dto.ListaProdutoHelper;
import br.com.orcamentop.dto.Produto;
import br.com.orcamentop.dto.ProdutoHelper;
import java.util.HashMap;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public abstract class ControllerProdutoPOA extends org.omg.PortableServer.Servant
        implements ControllerProdutoOperations, org.omg.CORBA.portable.InvokeHandler {

    private static HashMap _methods = new HashMap();

    // Type-specific CORBA::Object operations
    private static final String[] ID = {"IDL:br/com/orcamentop/negocio/ControllerProduto:1.0"};
    
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

        Produto produto;
        boolean bResult;
        
        switch (__method) {
            case 0: //gravar
                produto = ProdutoHelper.read(in);
                bResult = this.gravar(produto);
                out = rh.createReply();
                out.write_boolean(bResult);
                break;
            case 1: //remover
                produto = ProdutoHelper.read(in);
                bResult = this.remover(produto);
                out = rh.createReply();
                out.write_boolean(bResult);
                break;
            case 2: //carregar
                ListaProduto lista = this.carregar();
                out = rh.createReply();
                ListaProdutoHelper.write(out, lista);
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

    public ControllerProduto _this() {
        return ControllerProdutoHelper.narrow(
                super._this_object());
    }

    public ControllerProduto _this(org.omg.CORBA.ORB orb) {
        return ControllerProdutoHelper.narrow(
                super._this_object(orb));
    }
}
