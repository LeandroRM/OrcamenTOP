package br.com.orcamentop.dto;

import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;

/**
 * br/com/orcamentop/ListaPessoaHolder.java . Generated by the IDL-to-Java
 * compiler (portable), version "3.2" from orcamentop.idl Domingo, 10 de Junho
 * de 2018 23h26min58s BRT
 */
public final class ListaPessoaHolder implements Streamable {

    public ListaPessoa value = null;

    public ListaPessoaHolder() {
    }

    public ListaPessoaHolder(ListaPessoa initialValue) {
        value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        value = ListaPessoaHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        ListaPessoaHelper.write(o, value);
    }

    @Override
    public TypeCode _type() {
        return ListaPessoaHelper.type();
    }
}
