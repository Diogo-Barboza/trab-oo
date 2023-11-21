package inicio;

public class Administrador extends Usuario {

	public Administrador(String nome, String email, String senha) {
		super(nome, email, senha);
	}

	public int compareTo(String senha) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int compareToIgnoreCase(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Administrador [Nome = " + nome + "\n Email = " + email + "]";
	}



}
