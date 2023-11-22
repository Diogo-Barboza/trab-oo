package inicio;

public class Item {
	private String categoria;
	private String descricao;
	private String restaurante_item;
	private String preco;
	private String nome;
	
	public Item (String nome, String descricao, String restaurante_item, String preco, String categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.restaurante_item = restaurante_item;
		this.preco = preco;
		this.categoria = categoria;
	}
	

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRestaurante_item() {
		return restaurante_item;
	}

	public void setRestaurante_Item(String restaurante_item) {
		this.restaurante_item = restaurante_item;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return "Item [Nome = " + nome + "\n Categoria = " + categoria + "\n preco = "
				+ preco + "\n Descrição = " + descricao + "\n Restaurante deste item = " + restaurante_item + "]\n";
	}

}
