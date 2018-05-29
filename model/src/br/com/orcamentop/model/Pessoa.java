package br.com.orcamentop.model;

/**
 * 
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class Pessoa {
    private final int codigo;
    private String nome;
    private String telefone;
    private String email;

    public Pessoa(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return codigo;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pessoa(").append(codigo).append(") -> ");
        sb.append(nome).append(" - ");
        sb.append(email).append(" - ");
        sb.append(telefone);

        return sb.toString();
    }
}
