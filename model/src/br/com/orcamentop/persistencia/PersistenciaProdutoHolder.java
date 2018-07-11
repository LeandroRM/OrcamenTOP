package br.com.orcamentop.persistencia;

import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;

/**
 * br/com/orcamentop/persistencia/PersistenciaOrcamentoHolder.java . Generated
 * by the IDL-to-Java compiler (portable), version "3.2" from orcamentop.idl
 * Domingo, 10 de Junho de 2018 23h26min58s BRT
 */
public final class PersistenciaProdutoHolder implements Streamable {

    public PersistenciaProduto value = null;

    public PersistenciaProdutoHolder() {
    }

    public PersistenciaProdutoHolder(PersistenciaProduto initialValue) {
        value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        value = PersistenciaProdutoHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        PersistenciaProdutoHelper.write(o, value);
    }

    @Override
    public TypeCode _type() {
        return PersistenciaProdutoHelper.type();
    }
}