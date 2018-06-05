
import br.com.orcamentop.controller.ManagerPessoa;
import br.com.orcamentop.controller.PersistenciaXML;
import br.com.orcamentop.dto.ListaPessoa;
import br.com.orcamentop.dto.Pessoa;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class Main {
    public static void main(String[] args) {
        ManagerPessoa manager = new ManagerPessoa();
//        Pessoa pessoa = new Pessoa(1);
//        pessoa.setNome("Leandro");
//        pessoa.setTelefone("988139881");
//        pessoa.setEmail("leandro.ramos@effecti.com.br");
//        manager.gravar(pessoa);
//        
//        pessoa = new Pessoa(2);
//        pessoa.setNome("Wesley");
//        pessoa.setTelefone("988139881");
//        pessoa.setEmail("wesley.bezerra@ifc.edu.br");
//        manager.gravar(pessoa);
        
        System.out.println(manager.gerarNovoCodigo());
    }
}
