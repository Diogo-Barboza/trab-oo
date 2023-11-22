package dados;
import java.util.*;

import inicio.*;

@SuppressWarnings("unused")
public class Dados {
	 private Cliente[] clientes; // USUARIOS NORMAIS QUE COMPRAM
	 private int nClientes = 0; // CONTADOR DE CLIENTES
	 private Administrador[] administradores; // USUARIO QUE TEM PERMISSAO DE CRIAR RESTAURANTE
	 private int nAdmin = 0; //CONTADOR DE USUARIOS ADMIN
	 private Restaurante[] restaurantes; // RESTAURATNTES
	 private int nRestaurantes = 0;
	 private Item[] itens; // ITENS DO CARDÁPIO
	 private int nItens = 0; // CONTADOR DE ITENS
	 private Carrinho[] carrinhos; // CARRINHO DO CLIENTE
	 private int nItensCarrinho = 0; // CONTAODOR DE ITENS NO CARRINHO
	 
	 public Dados() {
		 clientes = new Cliente[50];
		 administradores = new Administrador[50];
		 restaurantes = new Restaurante[50];
		 itens = new Item[50];
		 carrinhos = new Carrinho[50];
		 
	 }
	 
	 // Clientes
	 
	 public Cliente[] getClientes() {
		 return clientes;
	 }
	 
	 public Cliente getClientes(int i) {
		 return clientes[i];
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
	
	//Adiministradores
	
	public Administrador[] getAdministradores() {
		return administradores;
	}
	
	public Administrador getAdministrador(int i) {
		return administradores[i];
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
	
	//Restaurantes
	
	public Restaurante[] getRestaurantes() {
		return restaurantes;
	}
	
	public Restaurante getRestaurante(int i) {
		return restaurantes[i];
	}
	
	public void setRestaurantes(Restaurante[] restaurantes) {
		this.restaurantes = restaurantes;
	}
	
	public void setRestaurante(int i, Restaurante r) {
		restaurantes[i] = r;
	}
	
	public int getnRestaurantes() {
		return nRestaurantes;
	}
	
	public void setnRestaurantes(int nRestaurantes) {
		this.nRestaurantes = nRestaurantes;
	}
	
// itens 
	
	public Item[] getItens() {
		return itens;
	}
	
	public Item getItem(int i) {
		return itens[i];
	}
	
	public void setItens(Item[] itens) {
		this.itens = itens;
	}
	
	public void setItem(int i, Item r) {
		itens[i] = r;
	}
	
	public int getnItens() {
		return nItens;
	}
	
	public void setnItens(int nItens) {
		this.nItens = nItens;
	}
	
	// Carrinho
	public Carrinho[] getCarrinhos() {
		return carrinhos;
	}
	
	public Carrinho getCarrinho(int i) {
		return carrinhos[i];
	}
	
	public void setCarrinhos(Carrinho[] carrinhos) {
		this.carrinhos = carrinhos;
	}
	
	public void setCarrinho(int i, Carrinho c) {
		carrinhos[i] = c;
	}
	
	public int getnItensCarrinho() {
		return nItensCarrinho;
	}
	
	public void setnItensCarrinho(int nItensCarrinho) {
		this.nItensCarrinho = nItensCarrinho;
	}
	
	/*public void preencherDados() {
		for(int i = 0; i < 10; i++) {
			String s = String.valueOf(i);
			clientes[i] = new Cliente("Cliente".concat(s), "email".concat(s), "senha".concat(s), "endereco".concat(s));
			administradores[i] = new Administrador("Adm".concat(s), "email".concat(s), "senha".concat(s)); 
			restaurantes[i] = new Restaurante("Nome".concat(s), "categoria".concat(s), "taxa".concat(s), "descricao".concat(s), "retirada".concat(s));
		}
	}*/
	
	
	
	
	
}
