package br.com.orcamentop.interfaces;

import br.com.orcamentop.dto.ListaProduto;
import br.com.orcamentop.dto.Produto;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public interface ControllerProduto {
    public boolean gravar(Produto produto);
    public boolean alterar(Produto produto);
    public boolean remover(Produto produto);
    public ListaProduto carregar();
    public int gerarNovoCodigo();
}
