package br.com.orcamentop.persistencia;

import br.com.orcamentop.dto.ListaProduto;
import br.com.orcamentop.dto.ListaProdutoHelper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;
import org.omg.CORBA.MARSHAL;
import org.omg.CORBA.ORB;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.RemarshalException;

/**
 * br/com/orcamentop/persistencia/_PersistenciaOrcamentoStub.java . Generated by
 * the IDL-to-Java compiler (portable), version "3.2" from orcamentop.idl
 * Domingo, 10 de Junho de 2018 23h26min58s BRT
 */
public class _PersistenciaProdutoStub extends ObjectImpl implements PersistenciaProduto {
    
    // Type-specific CORBA::Object operations
    private static String[] __ids = {
        "IDL:br/com/orcamentop/persistencia/PersistenciaProduto:1.0"};
    
    @Override
    public boolean salvar(ListaProduto pessoa) {
        InputStream in = null;
        
        try {
            OutputStream out = _request("salvar", true);
            ListaProdutoHelper.write(out, pessoa);
            in = _invoke(out);
            boolean $result = in.read_boolean();
            return $result;
        } catch (ApplicationException ex) {
            in = ex.getInputStream();
            String _id = ex.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException rm) {
            return salvar(pessoa);
        } finally {
            _releaseReply(in);
        }
    }

    @Override
    public ListaProduto carregar() {
        InputStream in = null;
        
        try {
            OutputStream out = _request("carregar", true);
            in = _invoke(out);
            ListaProduto listaProduto = ListaProdutoHelper.read(in);
            return listaProduto;
        } catch (ApplicationException ex) {
            in = ex.getInputStream();
            String _id = ex.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException rm) {
            return carregar();
        } finally {
            _releaseReply(in);
        }
    }

    @Override
    public String[] _ids() {
        return (String[]) __ids.clone();
    }

    private void readObject(ObjectInputStream s) throws IOException {
        String str = s.readUTF();
        String[] args = null;
        Properties props = null;
        ORB orb = ORB.init(args, props);
        
        try {
            Object obj = orb.string_to_object(str);
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _set_delegate(delegate);
        } finally {
            orb.destroy();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        String[] args = null;
        Properties props = null;
        ORB orb = ORB.init(args, props);
        
        try {
            String str = orb.object_to_string(this);
            s.writeUTF(str);
        } finally {
            orb.destroy();
        }
    }
}