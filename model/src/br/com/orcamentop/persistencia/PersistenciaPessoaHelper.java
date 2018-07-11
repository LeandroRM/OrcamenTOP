package br.com.orcamentop.persistencia;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;

/**
 * br/com/orcamentop/persistencia/PersistenciaOrcamentoHelper.java . Generated
 * by the IDL-to-Java compiler (portable), version "3.2" from orcamentop.idl
 * Domingo, 10 de Junho de 2018 23h26min58s BRT
 */
abstract public class PersistenciaPessoaHelper {

    private static String _id = "IDL:br/com/orcamentop/persistencia/PersistenciaPessoa:1.0";

    public static void insert(Any a, PersistenciaPessoa that) {
        OutputStream out = a.create_output_stream();
        a.type(type());
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }

    public static PersistenciaPessoa extract(Any a) {
        return read(a.create_input_stream());
    }

    private static TypeCode __typeCode = null;

    synchronized public static TypeCode type() {
        if (__typeCode == null) {
            __typeCode = ORB.init().create_interface_tc(PersistenciaPessoaHelper.id(), "PersistenciaPessoa");
        }
 
        return __typeCode;
    }

    public static String id() {
        return _id;
    }

    public static PersistenciaPessoa read(InputStream istream) {
        return narrow(istream.read_Object(_PersistenciaPessoaStub.class));
    }

    public static void write(OutputStream ostream, PersistenciaPessoa value) {
        ostream.write_Object((Object) value);
    }

    public static PersistenciaPessoa narrow(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof PersistenciaPessoa) {
            return (PersistenciaPessoa) obj;
        } else if (!obj._is_a(id())) {
            throw new BAD_PARAM();
        } else {
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _PersistenciaPessoaStub stub = new _PersistenciaPessoaStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

    public static PersistenciaPessoa unchecked_narrow(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof PersistenciaPessoa) {
            return (PersistenciaPessoa) obj;
        } else {
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _PersistenciaPessoaStub stub = new _PersistenciaPessoaStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }
}