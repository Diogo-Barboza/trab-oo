package inicio;

public class Cliente extends Usuario{
	
	protected Endereco endereco;

	public Cliente(String nome, String email, String senha, Endereco endereco) {
		super(nome, email, senha);
		this.endereco = endereco;
	}
	
	public void adicionarEndereco(String cep, String pais, String cidade, String bairro, String complemento,
			int numero, String estado, String ponto_de_refencia) {
		
	}

}
