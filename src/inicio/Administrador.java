package inicio;

public class Administrador extends Usuario {
	
	protected Restaurante restaurante;

	public Administrador(String nome, String email, String senha, Restaurante restaurante) {
		super(nome, email, senha);
		this.restaurante = restaurante;
	}
	
	public void cadastrarRestaurante(String nome, String categoria_restaurante, double taxa_entrega, 
			String local_retirada) {
		
	}
	public void excluirRestaurante(String restaurante) {
		
	}
	
	
}
