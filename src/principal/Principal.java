package principal;
import java.util.Scanner;
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
				break;
			case 2:
				break;
			case 3:
				
				break;
			case 4:
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
		if(d.getnRestaurantes() < 100) {
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
	
	
}
