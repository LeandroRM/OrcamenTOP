
import br.com.orcamentop.controller.PersistenciaXML;
import br.com.orcamentop.model.ListaPessoa;
import br.com.orcamentop.model.Pessoa;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class Main {
    public static void main(String[] args) {
        ListaPessoa listaPessoa = new ListaPessoa();
        Pessoa pessoa = new Pessoa(1);
        pessoa.setNome("Leandro");
        pessoa.setTelefone("988139881");
        pessoa.setEmail("leandro.ramos@effecti.com.br");
        listaPessoa.getLista().add(pessoa);
        
        pessoa = new Pessoa(2);
        pessoa.setNome("Wesley");
        pessoa.setTelefone("988139881");
        pessoa.setEmail("leandro.ramos@effecti.com.br");
        listaPessoa.getLista().add(pessoa);
        
        PersistenciaXML.getInstance().save(listaPessoa);
        
        ListaPessoa novaLista = PersistenciaXML.getInstance().loadPessoas();
        novaLista.getLista().forEach((Pessoa p) -> {
            System.out.println(p.toString());
        });
    }
}
