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
abstract public class PersistenciaOrcamentoHelper {

    private static String _id = "IDL:br/com/orcamentop/persistencia/PersistenciaOrcamento:1.0";

    public static void insert(Any a, PersistenciaOrcamento that) {
        OutputStream out = a.create_output_stream();
        a.type(type());
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }

    public static PersistenciaOrcamento extract(Any a) {
        return read(a.create_input_stream());
    }

    private static TypeCode __typeCode = null;

    synchronized public static TypeCode type() {
        if (__typeCode == null) {
            __typeCode = ORB.init().create_interface_tc(PersistenciaOrcamentoHelper.id(), "PersistenciaOrcamento");
        }
 
        return __typeCode;
    }

    public static String id() {
        return _id;
    }

    public static PersistenciaOrcamento read(InputStream istream) {
        return narrow(istream.read_Object(_PersistenciaOrcamentoStub.class));
    }

    public static void write(OutputStream ostream, PersistenciaOrcamento value) {
        ostream.write_Object((Object) value);
    }

    public static PersistenciaOrcamento narrow(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof PersistenciaOrcamento) {
            return (PersistenciaOrcamento) obj;
        } else if (!obj._is_a(id())) {
            throw new BAD_PARAM();
        } else {
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _PersistenciaOrcamentoStub stub = new _PersistenciaOrcamentoStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

    public static PersistenciaOrcamento unchecked_narrow(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof PersistenciaOrcamento) {
            return (PersistenciaOrcamento) obj;
        } else {
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _PersistenciaOrcamentoStub stub = new _PersistenciaOrcamentoStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }
}