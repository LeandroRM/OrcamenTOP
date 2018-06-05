package br.com.orcamentop.interfaces;

import br.com.orcamentop.dto.ListaPessoa;
import br.com.orcamentop.dto.Pessoa;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public interface ControllerPessoa {
    public boolean gravar(Pessoa pessoa);
    public boolean alterar(Pessoa pessoa);
    public boolean remover(Pessoa pessoa);
    public ListaPessoa carregar();
    public int gerarNovoCodigo();
}
