package br.com.orcamentop.negocio;

import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;
/**
 * br/com/orcamentop/negocio/ControllerOrcamentoHolder.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from orcamentop.idl Domingo,
 * 10 de Junho de 2018 23h26min58s BRT
 */
public final class ControllerOrcamentoHolder implements Streamable {

    public ControllerOrcamento value = null;

    public ControllerOrcamentoHolder() {
    }

    public ControllerOrcamentoHolder(ControllerOrcamento initialValue) {
        value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        value = ControllerOrcamentoHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        ControllerOrcamentoHelper.write(o, value);
    }

    @Override
    public TypeCode _type() {
        return ControllerOrcamentoHelper.type();
    }
}
