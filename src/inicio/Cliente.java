package inicio;

public class Cliente extends Usuario{
	
	protected String endereco;

	public Cliente(String nome, String email, String senha, String endereco) {
		super(nome, email, senha);
		this.endereco = endereco;
	}


}
