package inicio;

public class Restaurante {
	private String categoria_restaurante;
	private double taxa_entrega;
	private String descricao;
	private String local_retirada;
	private String nome;
	
	public Restaurante(String categoria_restaurante, double taxa_entrega, String descricao, String local_retirada,
			String nome) {
		super();
		this.categoria_restaurante = categoria_restaurante;
		this.taxa_entrega = taxa_entrega;
		this.descricao = descricao;
		this.local_retirada = local_retirada;
		this.nome = nome;
	}

	public String getCategoria_restaurante() {
		return categoria_restaurante;
	}

	public void setCategoria_restaurante(String categoria_restaurante) {
		this.categoria_restaurante = categoria_restaurante;
	}

	public double getTaxa_entrega() {
		return taxa_entrega;
	}

	public void setTaxa_entrega(double taxa_entrega) {
		this.taxa_entrega = taxa_entrega;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal_retirada() {
		return local_retirada;
	}

	public void setLocal_retirada(String local_retirada) {
		this.local_retirada = local_retirada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}	
