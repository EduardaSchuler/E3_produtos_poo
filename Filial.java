import java.util.*;


// =======================================================
// Esta classe está parcialmente implementada
// Você deve completar o código para realizar as tarefas
// =======================================================

public class Filial {

	private String cnpj;
	private String endereco;
	private Set<Produto> produtosDisponiveis;


	public Filial (String cnpj, String endereco) {
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.produtosDisponiveis = new HashSet<Produto>();
	}

	public String getCnpj () {
		return this.cnpj;
	}

	public String getEndereco () {
		return this.endereco;
	}

	public Set<Produto> getProdutosDisponiveis(){
		return produtosDisponiveis;
	}

	public boolean adicionarProduto (Produto produto) {
		return produtosDisponiveis.add(produto);
	}
}

