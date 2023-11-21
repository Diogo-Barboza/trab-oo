package inicio;

public class Restaurante {

	private String nome;
	private String categoria_restaurante;
	private String taxa_entrega;
	private String descricao;
	private String local_retirada;
	
	public Restaurante(String nome, String categoria_restaurante, String taxa_entrega, String descricao, String local_retirada) {
		super();
		this.nome = nome;
		this.categoria_restaurante = categoria_restaurante;
		this.taxa_entrega = taxa_entrega;
		this.descricao = descricao;
		this.local_retirada = local_retirada;
	}

	public String getCategoria_restaurante() {
		return categoria_restaurante;
	}

	public void setCategoria_restaurante(String categoria_restaurante) {
		this.categoria_restaurante = categoria_restaurante;
	}

	public String getTaxa_entrega() {
		return taxa_entrega;
	}

	public void setTaxa_entrega(String taxa_entrega) {
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

	@Override
	public String toString() {
		return "Restaurante [Nome = " + nome + "\n Categoria do restaurante = " + categoria_restaurante + "\n taxa de entrega = "
				+ taxa_entrega + "\n Descrição = " + descricao + "\n Local de retirada = " + local_retirada + "]";
	}
	
	
	
	
}	
