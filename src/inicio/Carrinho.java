package inicio;

public class Carrinho {
	private String nome;
	private String restaurante_nome;
	private String preco;
	private String obs;
	
	public Carrinho(String nome, String restaurante_nome, String preco, String obs) {
		super();
		this.nome = nome;
		this.restaurante_nome = restaurante_nome;
		this.preco = preco;
		this.obs = obs;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRestaurante_nome() {
		return restaurante_nome;
	}

	public void setRestaurante_nome(String restaurante_nome) {
		this.restaurante_nome = restaurante_nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String toString() {
		return "Carrinho [Nome = " + nome + "\nNome do restaurante = " + restaurante_nome + "\nPreço=" + preco + "\nObservações = " + obs
				+ "]";
	}
	
	
	
}
