
// =======================================================
// Esta classe está parcialmente implementada
// Você deve completar o código para realizar as tarefas
// =======================================================

public class Produto implements Comparable<Produto>{

	private int cod;
	private String nome;
	private double preco;

	public Produto (int cod, String nome, double preco) {
		this.setCod(cod);
		this.setNome(nome);
		this.setPreco(preco);
	}

	public int getCod () {
		return this.cod;
	}

	public String getNome () {
		return this.nome;
	}

	public double getPreco () {
		return this.preco;
	}

	public void setCod (int cod) {
		this.cod = cod;
	}

	public void setNome (String nome) {
		this.nome = nome.toUpperCase();
	}

	public void setPreco (double preco) {
		this.preco = (preco>0)? preco : 0.0;
	}

	@Override
    public String toString() {
        return String.format("[codigo=%s, nome=%s, preco=R$%.2f]",cod,nome,preco);
    }

	@Override
	public boolean equals(Object obj){
		if(obj == null) return false;
		if(this == obj) return false;
		if(getClass() != obj.getClass()) return false;
		Produto outroPod = (Produto) obj;
		return cod == outroPod.cod;
	}

	@Override
	public int hashCode(){
		String codigo = Integer.toString(cod);
		return codigo.hashCode();
	}

	@Override
	public int compareTo(Produto o) {
		return Double.compare(this.preco, o.getPreco());
	}
}

