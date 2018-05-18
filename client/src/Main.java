
import br.com.orcamentop.controller.PersistenciaXML;
import br.com.orcamentop.model.Pessoa;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1);
        pessoa.setNome("Leandro");
        pessoa.setTelefone("988139881");
        pessoa.setEmail("leandro.ramos@effecti.com.br");
        
        PersistenciaXML.getInstance().save(pessoa);
    }
}
