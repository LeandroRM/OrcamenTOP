package br.com.orcamentop.dto;

import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

/**
 * br/com/orcamentop/PessoaHolder.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.2" from orcamentop.idl Domingo, 10 de Junho de 2018
 * 23h26min58s BRT
 */
public final class PessoaHolder implements org.omg.CORBA.portable.Streamable {

    public Pessoa value = null;

    public PessoaHolder() {
    }

    public PessoaHolder(Pessoa initialValue) {
        value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        value = PessoaHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        PessoaHelper.write(o, value);
    }

    @Override
    public TypeCode _type() {
        return PessoaHelper.type();
    }
}
