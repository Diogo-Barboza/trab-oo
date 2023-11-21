package principal;
import java.util.*;
import dados.*;
import inicio.*;

public class Principal {
	
	private static Dados d = new Dados();
	private static Scanner entrada = new Scanner(System.in);	
	
	public static void main(String[] args) {
		int op = -1;
		//d.preencherDados();

		while(op != 0) {
			System.out.println(menuInicial());
			op = entrada.nextInt();
			switch (op) {
			case 0:
				System.out.println("Obrigado por utilizar o sistema!");
				break;
			case 1:
				if(lerDadosLoginAdministrador() == true) {
					System.out.println("DEU CERTO");
					break;
				}
				break;
			case 2:
				if(lerDadosLoginCliente() == true) {
					System.out.println("DEU CERTO");
					break;
				}
				break;
			case 3:
				cadastrarAdministrador();
				break;
			case 4:
				cadastrarCliente();
				break;
			case 5: //TESTE DE LISTAGEM/BUSCA

				break;
			default:
				System.out.println("\nOpção Invalida! Tente novamente.\n");
				break;
			}
			
				
		}
		
		
		

	}

	public static String menuInicial() {
		String saida = new String("Escolha uma das opcoes a seguir:\n");
		saida = saida + "0 - Sair da aplicação\n";
		saida = saida + "1 - Entrar como Restaurante\n";
		saida = saida + "2 - Entrar como Cliente\n";
		saida = saida + "3 - Cadastrar conta de Restaurante\n";
		saida = saida + "4 - Cadastrar conta de cliente\n";
		return saida;
		
	}
	
	public static boolean cadastrarRestaurante() {
		Restaurante r = lerDadosRestaurante();
		if(d.getnRestaurantes() < 50) {
			d.setRestaurante(d.getnRestaurantes(), r);
			d.setnRestaurantes(d.getnRestaurantes() + 1);
			System.out.println("Restaurante cadastrado com sucesso!\n");
			return true;
		} else {
			System.out.println("Não foi possivel cadastrar o Restaurante!\n");
			return false;
		}
	}
	
	public static Restaurante lerDadosRestaurante() {
		String categoria_restaurante;
		String taxa_entrega;
		String descricao;
		String local_retirada;
		String nome;
		entrada.nextLine(); //esvazia dados do teclado
		System.out.println("Digite o nome do restaurante: ");
		nome = entrada.nextLine();
		System.out.println("Digite a categoria do restuarante:");
		categoria_restaurante = entrada.nextLine();
		System.out.println("Digite a taxa de entrega do restaurante:");
		taxa_entrega = entrada.nextLine();
		System.out.println("Digite a descrição do restaurante:");
		descricao = entrada.nextLine();
		System.out.println("Digite o local de retirada do restaurante:");
		local_retirada = entrada.nextLine();
		Restaurante r = new Restaurante(nome, categoria_restaurante, taxa_entrega, descricao, local_retirada);
		return r;	
	}
	
	public static boolean cadastrarAdministrador() {
		Administrador r = lerDadosAdministrador();
		if(d.getnAdmin() < 50) {
			d.setAdministrador(d.getnAdmin(), r);
			d.setnAdmin(d.getnAdmin() + 1);
			System.out.println("Administrador cadastrado com sucesso!\n");
			return true;
		} else {
			System.out.println("Não foi possivel cadastrar o Administrador!\n");
			return false;
		}
	}
	
	public static Administrador lerDadosAdministrador() {
		String nome;
		String email;
		String senha;
		entrada.nextLine(); //esvazia dados do teclado
		System.out.println("Digite seu nome: ");
		nome = entrada.nextLine();
		System.out.println("Digite seu email: ");
		email = entrada.nextLine();
		System.out.println("Digite sua senha: ");
		senha = entrada.nextLine();
		Administrador a = new Administrador(nome, email, senha);
		return a;
	}
	
	public static boolean lerDadosLoginAdministrador() {
		boolean resultado = false;
		String email;
		String senha;
		entrada.nextLine(); //esvazia dados do teclado
		System.out.println("Digite seu email: ");
		email = entrada.nextLine();
		System.out.println("Digite sua senha: ");
		senha = entrada.nextLine();
		if(d.getnAdmin() == 0) {
			System.out.println("SEM DADOS");
			return false;
		}else {
			for(int i = 0; i < d.getnAdmin(); i++) {
				if(d.getAdministradores()[i].getEmail().compareToIgnoreCase(email) == 0) {
					if(d.getAdministradores()[i].getSenha().compareTo(senha) == 0) {
						System.out.println("Login efetuado com sucesso!");
						resultado = true;
					}else {
						System.out.println("Senha incorreta! Tente novamente.");
						resultado = false;
					}

				}else {
					System.out.println("Usuário não cadastrado! Registre-se.");
					resultado = false;
				}
			}
		}
		return resultado;
	}
	
	
	public static boolean cadastrarCliente() {
		Cliente r = lerDadosCliente();
		if(d.getnClientes() < 50) {
			d.setCliente(d.getnClientes(), r);
			d.setnClientes(d.getnClientes() + 1);
			System.out.println("Cliente cadastrado com sucesso!\n");
			return true;
		} else {
			System.out.println("Não foi possivel cadastrar o Cliente!\n");
			return false;
		}
	}
	
	public static Cliente lerDadosCliente() {
		String nome;
		String email;
		String senha;
		String endereco;
		entrada.nextLine(); //esvazia dados do teclado
		System.out.println("Digite seu nome: ");
		nome = entrada.nextLine();
		System.out.println("Digite seu email: ");
		email = entrada.nextLine();
		System.out.println("Digite sua senha: ");
		senha = entrada.nextLine();
		System.out.println("Digite seu endereço: ");
		endereco = entrada.nextLine();
		Cliente r = new Cliente(nome, email, senha, endereco);
		return r;
	}
	
	public static boolean lerDadosLoginCliente() {
		boolean resultado = false;
		String email;
		String senha;
		entrada.nextLine(); //esvazia dados do teclado
		System.out.println("Digite seu email: ");
		email = entrada.nextLine();
		System.out.println("Digite sua senha: ");
		senha = entrada.nextLine();
		if(d.getnClientes() == 0) {
			System.out.println("SEM DADOS");
			return false;
		}else {
			for(int i = 0; i < d.getnClientes(); i++) {
				if(d.getClientes()[i].getEmail().compareToIgnoreCase(email) == 0) {
					if(d.getClientes()[i].getSenha().compareTo(senha) == 0) {
						System.out.println("Login efetuado com sucesso!");
						resultado = true;
					}else {
						System.out.println("Senha incorreta! Tente novamente.");
						resultado = false;
					}

				}else {
					System.out.println("Usuário não cadastrado! Registre-se.");
					resultado = false;
				}
			}
		}
		return resultado;
	}
	
	
	public static void listarRestaurantes() { 
		for(int i = 0; i < d.getnRestaurantes(); i++) 
			System.out.println(i + " -> " + d.getRestaurantes()[i].toString());

	}
	
	public static void listarClientes() { 
		for(int i = 0; i < d.getnClientes(); i++) 
			System.out.println(i + " -> " + d.getClientes()[i].toString());

	}
	
}
