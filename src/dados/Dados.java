package dados;
import inicio.*;

public class Dados {
	 private Cliente[] clientes;
	 private int nClientes = 0;
	 private Administrador[] administradores;
	 private int nAdmin = 0;
	 private Restaurante[] restaurantes;
	 private int nRestaurantes = 0;
	 
	 public Dados() {
		 clientes = new Cliente[50];
		 administradores = new Administrador[50];
		 
	 }
	 
	 public Cliente[] getClientes() {
		 return clientes;
	 }
	 
	 public Cliente getClientes(int i) {
		 return clientes[i];
	 }
	 
	public String[] getNomeClientes() {
		String[] s = new String[nClientes];
		for(int i = 0; i < nClientes; i++) {
			s[i] = clientes[i].getNome();
		}
		return s;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
	
	public void setCliente(int i, Cliente a) {
		clientes[i] = a;
	}
	
	public int getnClientes() {
		return nClientes;
	}
	
	public void setnClientes(int nClientes) {
		this.nClientes = nClientes;
	}
	
	public Administrador[] getAdministradores() {
		return administradores;
	}
	
	public Administrador getAdministrador(int i) {
		return administradores[i];
	}
	
	public String[] getNomeAdministradores() {
		String[] s = new String[nAdmin];
		for(int i = 0; i < nAdmin; i++) {
			s[i] = administradores[i].getNome();
		}
		return s;
	}
	
	public void setAdministradores(Administrador[] administradores) {
		this.administradores = administradores;
	}
	
	public void setAdministrador(int i, Administrador a) {
		administradores[i] = a;
	}
	
	public int getnAdmin() {
		return nAdmin;
	}
	
	public void setnAdmin(int nAdmin) {
		this.nAdmin = nAdmin;
	}
	
	public Restaurante[] getRestaurantes() {
		return restaurantes;
	}
	
	public Restaurante getRestaurantes(int i) {
		return restaurantes[i];
	}
	
	public void setRestaurantes(Restaurante[] restaurantes) {
		this.restaurantes = restaurantes;
	}
	
	public void setRestaurente(int i, Restaurante r) {
		restaurantes[i] = r;
	}
	
	public int getnRestaurantes() {
		return nRestaurantes;
	}
	
	public void setnRestaurantes(int nRestaurantes) {
		this.nRestaurantes = nRestaurantes;
	}
	
	public void preencherDados() {
		for(int i = 0; i < 10; i++) {
			String s = String.valueOf(i);
			clientes[i] = new Cliente("Cliente".concat(s), "email".concat(s), "senha".concat(s), "endereco".concat(s));
			administradores[i] = new Administrador("Adm".concat(s), "email".concat(s), "senha".concat(s), 
					"restaurante".concat(s)); 
			restaurantes[i] = new Restaurante("Nome".concat(s), "categoria".concat(s), "taxa".concat(s), "descricao".concat(s), "retirada".concat(s));
		}
	}
	

	
	
	
	
	
}
