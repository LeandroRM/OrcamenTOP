package br.com.orcamentop.dto;

/**
 * br/com/orcamentop/Pessoa.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.2" from orcamentop.idl Domingo, 10 de Junho de 2018
 * 23h26min58s BRT
 */
public final class Pessoa implements org.omg.CORBA.portable.IDLEntity {

    private int codigo = (int) 0;
    private String nome = "";
    private String telefone = "";
    private String email = "";

    public Pessoa() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
