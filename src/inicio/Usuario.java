package inicio;

public abstract class Usuario {
	protected String nome;
	protected String email;
	protected String senha;
	
	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public void cadastrarNome(String n) {
		nome = n;
	}
	public void cadastrarEmail(String e) {
		email = e;
	}
	public void cadastrarSenha(String s) {
		senha = s;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
