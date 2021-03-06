package br.com.orcamentop.dto;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.StructMember;
import org.omg.CORBA.TCKind;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.InputStream;

/**
 * br/com/orcamentop/OrcamentoHelper.java . Generated by the IDL-to-Java
 * compiler (portable), version "3.2" from orcamentop.idl Domingo, 10 de Junho
 * de 2018 23h26min58s BRT
 */
abstract public class OrcamentoHelper {

    private static String _id = "IDL:br/com/orcamentop/Orcamento:1.0";
    private static TypeCode __typeCode = null;
    private static boolean __active = false;

    public static void insert(Any a, Orcamento that) {
        OutputStream out = a.create_output_stream();
        a.type(type());
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }

    public static Orcamento extract(Any a) {
        return read(a.create_input_stream());
    }

    synchronized public static TypeCode type() {
        if (__typeCode == null) {
            synchronized (TypeCode.class) {
                if (__typeCode == null) {
                    if (__active) {
                        return ORB.init().create_recursive_tc(_id);
                    }
                    
                    __active = true;
                    StructMember[] members = new StructMember[8];
                    TypeCode tcOfMembers;
                    
                    tcOfMembers = ORB.init().get_primitive_tc(TCKind.tk_long);
                    members[0] = new StructMember(
                            "codigo",
                            tcOfMembers,
                            null);
                    
                    tcOfMembers = ProdutoHelper.type();
                    tcOfMembers = ORB.init().create_sequence_tc(0, tcOfMembers);
                    tcOfMembers = ORB.init().create_alias_tc(
                            ListaProdutoHelper.id(), 
                            "ListaProduto", 
                            tcOfMembers);
                    members[1] = new StructMember(
                            "listaProduto",
                            tcOfMembers,
                            null);
                    
                    tcOfMembers = PessoaHelper.type();
                    tcOfMembers = ORB.init().create_sequence_tc(0, tcOfMembers);
                    tcOfMembers = ORB.init().create_alias_tc(
                            ListaPessoaHelper.id(), 
                            "ListaPessoa", 
                            tcOfMembers);
                    members[2] = new StructMember(
                            "listaCliente",
                            tcOfMembers,
                            null);
                    
                    tcOfMembers = ORB.init().create_wstring_tc(0);
                    members[3] = new StructMember(
                            "descricao",
                            tcOfMembers,
                            null);
                    
                    tcOfMembers = ORB.init().create_wstring_tc(0);
                    members[4] = new StructMember(
                            "observacao",
                            tcOfMembers,
                            null);
                    
                    tcOfMembers = ORB.init().create_wstring_tc(0);
                    members[5] = new StructMember(
                            "localCompra",
                            tcOfMembers,
                            null);
                    
                    tcOfMembers = ORB.init().get_primitive_tc(
                            TCKind.tk_longlong);
                    members[6] = new StructMember(
                            "dataCompra",
                            tcOfMembers,
                            null);
                    
                    tcOfMembers = ORB.init().get_primitive_tc(
                            TCKind.tk_longlong);
                    members[7] = new StructMember(
                            "dataCriado",
                            tcOfMembers,
                            null);
                    
                    __typeCode = ORB.init().create_struct_tc(
                            OrcamentoHelper.id(),
                            "Orcamento",
                            members);
                    __active = false;
                }
            }
        }
        
        return __typeCode;
    }

    public static String id() {
        return _id;
    }

    public static Orcamento read(InputStream istream) {
        Orcamento value = new Orcamento();
        value.setCodigo(istream.read_long());
        value.setListaProduto(ListaProdutoHelper.read(istream));
        value.setListaPessoa(ListaPessoaHelper.read(istream));
        value.setDescricao(istream.read_wstring());
        value.setObservacao(istream.read_wstring());
        value.setLocalCompra(istream.read_wstring());
        value.setDataCompra(istream.read_longlong());
        value.setDataCriado(istream.read_longlong());
        return value;
    }

    public static void write(OutputStream ostream, Orcamento value) {
        ostream.write_long(value.getCodigo());
        ListaProdutoHelper.write(ostream, value.getListaProduto());
        ListaPessoaHelper.write(ostream, value.getListaPessoa());
        ostream.write_wstring(value.getDescricao());
        ostream.write_wstring(value.getObservacao());
        ostream.write_wstring(value.getLocalCompra());
        ostream.write_longlong(value.getDataCompra());
        ostream.write_longlong(value.getDataCriado());
    }
}
