package principal;

import java.util.*;
import dados.*;
import inicio.*;

public class Principal {

	private static Dados d = new Dados();
	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		int op = -1;
		int opAdmin; // SELETOR DO CASE 1 - MENU DOS ADMINISTRADORES (CRIADORES DE RESTAURANTE)
		int opCliente; // SELETOR DO CASE 2 - MENU DOS CLIENTES (COMPRADORES DOS RESTAURANTES)
		int opCarrinho; // SELETOR DENTRO DE CARRINHO;
		// d.preencherDados();

		while (op != 0) {
			System.out.println(menuInicial()); // IMPRIME O MENU
			op = entrada.nextInt();
			switch (op) {
				case 0:
					System.out.println("Obrigado por utilizar o sistema!");
					break;
				case 1: // LOGIN ADM
					if (lerDadosLoginAdministrador() == true) {
						opAdmin = -1;
						while (opAdmin != 0) {
							System.out.println(menuRestaurante()); // IMPRIMA O MENU DOS RESTARUANTES (ADMINISTRADOR)
							opAdmin = entrada.nextInt();
							switch (opAdmin) {
								case 0:
									System.out.println("Saindo do menu restaurante! Obrigado!");
									break;
								case 1: // CADASTRAR
									cadastrarRestaurante();
									break;
								case 2: // EDITAR
									editarRestaurante();
									break;
								case 3: // EXCLUIR
									removerRestaurante();
									break;
								case 4: // LISTAR
									listarRestaurantes();
									break;
								case 5:
									cadastrarItem();
									break;
								case 6:
									editarItem();
									break;
								case 7:
									listarItens();
									break;
								case 8:
									removerItem();
									break;
								case 9:
									removerAdmin();
									opAdmin = 0;
									break;
								default:
									System.out.println("\nOpção Invalida! Tente novamente.\n");
									break;
							}

						}
						break;
					}
					break;
				case 2: // LOGIN CLIENTE
					if (lerDadosLoginCliente() == true) {
						opCliente = -1;
						while (opCliente != 0) {
							System.out.println(menuCliente()); // IMPRIMA O MENU DOS CLIENTES (COMPRADOR)
							opCliente = entrada.nextInt();
							switch (opCliente) {
								case 0: // VOLTAR AO MENU
									System.out.println("Saindo do menu Cliente! Obrigado!");
									break;
								case 1: // EDITAR CONTA
									editarCliente();
									break;
								case 2: // EXCLUIR CONTA
									removerCliente();
									opCliente = 0;
									break;
								case 3: // BUSCAR RESTAURANTE
									buscarRestaurante();
									break;
								case 4: // ADICIONAR ITEM AO CARRINHO
									opCarrinho = -1;
									while(opCarrinho != 0) {
										System.out.println(menuCarrinho()); // IMPRIME O MEU DENTRO DO CARRINHO
										opCarrinho = entrada.nextInt();
										switch (opCarrinho) {
										case 0:
											opCarrinho = 0;
											break;
										case 1:
											adicionarCarrinho();
											break;
										case 2: // excluir item
											removerItemCarrinho();
											break;
										case 3: // Listar Carrinho
											listarCarrinho();
											break;
										case 4: // Simulação de pagar e zerar o carrinho
											if(d.getnItensCarrinho() != 0) {
												pagar();
											}else {
												System.out.println("Carrinho vazio. Adicione algum item.");
											}
											break;
										default:
												System.out.println("\\nOpção Invalida! Tente novamente.\\n");
												break;
										}
									}
									break;
								default:
									System.out.println("\nOpção Invalida! Tente novamente.\n");
									break;
							}

						}
						break;
					}
					break;
				case 3: // CRIAR CONTA ADM
					cadastrarAdministrador();
					break;
				case 4: // CRIAR CONTA CLIENTE
					cadastrarCliente();
					break;
				case 5: // TESTE DE LISTAGEM/BUSCA

					break;
				default:
					System.out.println("\nOpção Invalida! Tente novamente.\n");
					break;
			}

		}

	}

	public static String menuInicial() {
		String saida = new String("Escolha uma das opções a seguir:\n");
		saida = saida + "0 - Sair da aplicação\n";
		saida = saida + "1 - Entrar como Restaurante\n";
		saida = saida + "2 - Entrar como Cliente\n";
		saida = saida + "3 - Cadastrar conta de Restaurante\n";
		saida = saida + "4 - Cadastrar conta de cliente\n";
		return saida;

	}

	public static String menuRestaurante() {
		String saida = new String("Escolha uma das opções a seguir:\n");
		saida = saida + "0 - Voltar para menu principal\n";
		saida = saida + "1 - Cadastrar Restaurante\n";
		saida = saida + "2 - Editar Restaurante\n";
		saida = saida + "3 - Excluir Restaurante\n";
		saida = saida + "4 - Listar Restaurantes\n";
		saida = saida + "5 - Adicionar Item ao Cardápio\n";
		saida = saida + "6 - Editar Item\n";
		saida = saida + "7 - Listar Itens do Cardápio\n";
		saida = saida + "8 - Excluir Item do Cardápio\n";
		saida = saida + "9 - Exlcuir conta";
		return saida;
	}

	public static String menuCliente() {
		String saida = new String("Escolha uma das opções a seguir: \n");
		saida = saida + "0 - Voltar para menu principal\n";
		saida = saida + "1 - Editar conta\n";
		saida = saida + "2 - Excluir conta\n";
		saida = saida + "3 - Buscar Restaurantes\n";
		saida = saida + "4 - Adicionar Item ao carrinho";
		return saida;
	}

	public static String menuCarrinho() {
		String saida = new String("Escolha uma das opções a seguir: \n");
		saida = saida + "0 - Sair no menu\n";
		saida = saida + "1 - Adicionar ao carrinho\n";
		saida = saida + "2 - Excluir item do carrinho\n";
		saida = saida + "3 - Listar itens do carrinho\n";
		saida = saida + "4 - Pagar\n";
		return saida;
	}
	
	public static boolean cadastrarRestaurante() {
		Restaurante r = lerDadosRestaurante();
		if (d.getnRestaurantes() < 50) {
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
		entrada.nextLine(); // esvazia dados do teclado
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

	public static boolean editarRestaurante() {
		int opc = -1;
		String nome;
		entrada.nextLine();
		System.out.println("Digite o nome do restaurante que deseja editar: ");
		nome = entrada.nextLine();
		for (int i = 0; i < d.getnRestaurantes(); i++) {
			if (d.getRestaurantes()[i].getNome().compareToIgnoreCase(nome) == 0) {
				System.out.println("O restaurante a ser editado é: " + d.getRestaurantes()[i]);
				System.out.println("0 - Cancelar\n1 - Continuar");
				opc = entrada.nextInt();
				if (opc == 1) {
					Restaurante r = lerDadosRestaurante();
					if (i < d.getnRestaurantes() && i >= 0) {
						d.setRestaurante(i, r);
						System.out.println("Dados editados com sucesso");
						return true;
					}
				} else {
					System.out.println("Operação cancelada!");
					return false;
				}
			}
		}
		return false;
	}

	public static void removerRestaurante() {
		int opc = -1;
		String nome;
		entrada.nextLine();
		System.out.println("Digite o nome do restaurante que deseja remover: ");
		nome = entrada.nextLine();
		for (int i = 0; i < d.getnRestaurantes(); i++) {
			if (d.getRestaurantes()[i].getNome().compareToIgnoreCase(nome) == 0) {
				System.out.println("O restaurante a ser removido é: " + d.getRestaurantes()[i]);
				System.out.println("0 - Cancelar\n1 - Continuar");
				opc = entrada.nextInt();
				if (opc == 1) {
					if (i < d.getnRestaurantes() && i >= 0) {
						swapListaRestaurantes(i);
						d.setRestaurante(d.getnRestaurantes(), null);
						d.setnRestaurantes(d.getnRestaurantes() - 1);
						System.out.println("Restaurante removido com sucesso!");
					}
				} else {
					System.out.println("Operação cancelada!");
				}
			}
		}
	}

	public static void swapListaRestaurantes(int a) {
		for (int i = a; i < d.getnRestaurantes() - 1; i++)
			d.setRestaurante(i, d.getRestaurante(i + 1));
	}

	public static boolean cadastrarItem() {
		Item it = lerDadosItens();
		if (d.getnItens() < 50) {
			d.setItem(d.getnItens(), it);
			d.setnItens(d.getnItens() + 1);
			System.out.println("Item cadastrado com sucesso!\n");
			return true;
		} else {
			System.out.println("Não foi possivel cadastrar o Item!\n");
			return false;
		}
	}

	public static Item lerDadosItens() {
		String categoria;
		String descricao;
		String restaurante_item;
		String preco;
		String nome;
		entrada.nextLine(); // esvazia dados do teclado
		System.out.println("Digite o nome do item: ");
		nome = entrada.nextLine();
		System.out.println("Digite a categoria do item:");
		categoria = entrada.nextLine();
		System.out.println("Digite o restaurante deste item:");
		restaurante_item = entrada.nextLine();
		System.out.println("Digite a descrição do item:");
		descricao = entrada.nextLine();
		System.out.println("Digite o preço do item:");
		preco = entrada.nextLine();
		Item it = new Item(nome, categoria, descricao, restaurante_item, preco);
		return it;
	}
	
	public static boolean editarItem() {
		int opc = -1;
		String nome;
		entrada.nextLine();
		System.out.println("Digite o nome do item que deseja editar: ");
		nome = entrada.nextLine();
		for (int i = 0; i < d.getnItens(); i++) {
			if (d.getItens()[i].getNome().compareToIgnoreCase(nome) == 0) {
				System.out.println("O item a ser editado é: " + d.getItens()[i]);
				System.out.println("0 - Cancelar\n1 - Continuar");
				opc = entrada.nextInt();
				if (opc == 1) {
					Item r = lerDadosItens();
					if (i < d.getnItens() && i >= 0) {
						d.setItem(i, r);
						System.out.println("Dados editados com sucesso");
						return true;
					}
				} else {
					System.out.println("Operação cancelada!");
					return false;
				}
			}
		}
		return false;
	}
	
	public static void listarItens() {
		for (int i = 0; i < d.getnItens(); i++)
			System.out.println(i + " -> " + d.getItens()[i].toString());
	}
	
	public static void removerItem() {
		int opc = -1;
		String nome;
		entrada.nextLine();
		System.out.println("Digite o nome do Item que deseja remover: ");
		nome = entrada.nextLine();
		for (int i = 0; i < d.getnItens(); i++) {
			if (d.getItens()[i].getNome().compareToIgnoreCase(nome) == 0) {
				System.out.println("O item a ser removido é: " + d.getItens()[i]);
				System.out.println("0 - Cancelar\n1 - Continuar");
				opc = entrada.nextInt();
				if (opc == 1) {
					if (i < d.getnItens() && i >= 0) {
						swapListaRestaurantes(i);
						d.setItem(d.getnItens(), null);
						d.setnItens(d.getnItens() - 1);
						System.out.println("Item removido com sucesso!");
					}
				} else {
					System.out.println("Operação cancelada!");
				}
			}
		}
	}
	
	public static void swapListaItens(int a) {
		for (int i = a; i < d.getnItens() - 1; i++)
			d.setItem(i, d.getItem(i + 1));
	}
	
	public static void adicionarCarrinho() {
		int achou = 0;
		clearBuffer(entrada);
		System.out.println("Digite o nome do item desejado: ");
		String nomeItem = entrada.nextLine();
		
		for (int i = 0; i < d.getnItens(); i++) {
			if(d.getItens()[i].getNome().equalsIgnoreCase(nomeItem) == true) {
				System.out.println(i + "->" + d.getItens()[i].toString());
				achou++;
			}
		}
		if(achou > 0) {
			System.out.println("Digite a opcao desejada para adicionar: ");
			int opc = entrada.nextInt();
			System.out.println("Adicionar Observação: ");
			clearBuffer(entrada);
			String obs = entrada.nextLine();
			Carrinho c = new Carrinho(d.getItens()[opc].getNome(), d.getItens()[opc].getRestaurante_item(), d.getItens()[opc].getPreco(), obs);
			if (d.getnItensCarrinho() < 50) {
				d.setCarrinho(d.getnItensCarrinho(), c);
				d.setnItensCarrinho(d.getnItensCarrinho() + 1);
				System.out.println("Item adicionado ao carrinho com sucesso!\n");
			} else {
				System.out.println("Não foi possivel adicionar o Item ao carrinho!\n");
			}
		}else {
			System.out.println("Item não foi encontrado.");
		}
		if(d.getnItens() == 0) {
			System.out.println("Sem itens cadastrados.");
		}
		clearBuffer(entrada);
		
	}
	
	public static double precoCarrinho() { // Converte o preco de string para double e faz a soma de todos os itens do carrinho
		double soma = 0;
		for(int i = 0; i < d.getnItensCarrinho(); i++) {
			String num = d.getCarrinhos()[i].getPreco();
			double preco = Double.valueOf(num);
			soma = soma + preco;	
		}
		if(d.getnItensCarrinho() == 0) {
			System.out.println("Ação impossível. Sem item no carrinho!");
		}
		return soma;
	}
	
	public static boolean cadastrarAdministrador() {
		Administrador r = lerDadosAdministrador();
		if (d.getnAdmin() < 50) {
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
		entrada.nextLine(); // esvazia dados do teclado
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
		entrada.nextLine(); // esvazia dados do teclado
		System.out.println("Digite seu email: ");
		email = entrada.nextLine();
		System.out.println("Digite sua senha: ");
		senha = entrada.nextLine();
		if (d.getnAdmin() == 0) {
			System.out.println("SEM DADOS");
			return false;
		} else {
			for (int i = 0; i < d.getnAdmin(); i++) {
				if (d.getAdministradores()[i].getEmail().compareToIgnoreCase(email) == 0) {
					if (d.getAdministradores()[i].getSenha().compareTo(senha) == 0) {
						System.out.println("Login efetuado com sucesso!");
						resultado = true;
						break;
					} else {
						System.out.println("Senha incorreta! Tente novamente.");
						resultado = false;
						return false;
					}
				}
			}
			if (resultado == false) {
				System.out.println("Usuário não cadastrado! Registre-se.");
				return false;
			}
		}
		return resultado;
	}

	public static boolean editarAdm() {
		String email, senha;
		int i = 0;

		entrada.nextLine();// LIMPA TECLADO
		System.out.println("Confirme seu email: ");
		email = entrada.nextLine();
		System.out.println("Confirme sua senha: ");
		senha = entrada.nextLine();
		entrada.nextLine(); // LIMPA TECLADO

		for (int c = 0; c < d.getnAdmin(); c++) {
			if (d.getAdministradores()[c].getEmail().compareToIgnoreCase(email) == 0
					&& d.getAdministradores()[c].getSenha().compareTo(senha) == 0) {
				i = c;
				Administrador a = lerDadosAdministrador();
				if (i < d.getnAdmin() && i >= 0) {
					d.setAdministrador(i, a);
					System.out.println("Dados editados com sucesso");
					return true;
				} else {
					System.out.println("Voce escolheu um numero invalido!");
					return false;
				}
			}
		}
		return false;
	}

	public static boolean cadastrarCliente() {
		Cliente r = lerDadosCliente();
		if (d.getnClientes() < 50) {
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
		// entrada.nextLine(); //esvazia dados do teclado
		clearBuffer(entrada);
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
		entrada.nextLine(); // esvazia dados do teclado
		System.out.println("Digite seu email: ");
		email = entrada.nextLine();
		System.out.println("Digite sua senha: ");
		senha = entrada.nextLine();
		if (d.getnClientes() == 0) {
			System.out.println("SEM DADOS");
			return false;
		} else {
			for (int i = 0; i < d.getnClientes(); i++) {
				if (d.getClientes()[i].getEmail().compareToIgnoreCase(email) == 0) {
					if (d.getClientes()[i].getSenha().compareTo(senha) == 0) {
						System.out.println("Login efetuado com sucesso!");
						resultado = true;
						return true;
					} else {
						System.out.println("Senha incorreta! Tente novamente.");
						resultado = false;
						return false;
					}

				}
			}
			if (resultado == false) {
				System.out.println("Usuário não cadastrado! Registre-se.");
				resultado = false;
			}
		}

		return resultado;
	}

	public static boolean editarCliente() {
		String email, senha;
		int i = 0;

		clearBuffer(entrada);
		System.out.println("Confirme seu email: ");
		email = entrada.nextLine();
		System.out.println("Confirme sua senha: ");
		senha = entrada.nextLine();
		for (int c = 0; c < d.getnClientes(); c++) {
			if (d.getClientes()[c].getEmail().compareToIgnoreCase(email) == 0
					&& d.getClientes()[c].getSenha().compareTo(senha) == 0) {
				i = c;
				Cliente a = lerDadosCliente();
				if (i < d.getnClientes() && i >= 0) {
					d.setCliente(i, a);
					System.out.println("Dados editados com sucesso");
					return true;
				}
			} else {
				System.out.println("Dados incorretos. Tente novamente!");
				return false;
			}
		}
		return false;
	}
	
	static void removerAdmin(){
		int opc = -1;
		@SuppressWarnings("unused")
		String email, senha;

		clearBuffer(entrada);
		System.out.println("Confirme seu email: ");
		email = entrada.nextLine();
		System.out.println("Confirme sua senha: ");
		senha = entrada.nextLine();
		for (int i = 0; i < d.getnAdmin(); i++) {
			if (d.getAdministradores()[i].getEmail().compareToIgnoreCase(email) == 0) {
				System.out.println("A conta a ser removida é: " + d.getAdministradores()[i]);
				System.out.println("0 - Cancelar\n1 - Continuar");
				opc = entrada.nextInt();
				if (opc == 1) {
					if (i < d.getnAdmin() && i >= 0) {
						swapListaAdmin(i);
						d.setAdministrador(d.getnAdmin(), null);
						d.setnAdmin(d.getnAdmin() - 1);
						System.out.println("Administrador removido com sucesso!");
					}
				} else {
					System.out.println("Operação cancelada!");
				}
			}
		}
	}
	
	static void swapListaAdmin(int a){
		for (int i = a; i < d.getnAdmin() - 1; i++)
			d.setAdministrador(i, d.getAdministradores(i + 1));

	}

	public static void removerCliente() {
		int opc = -1;
		@SuppressWarnings("unused")
		String email, senha;

		clearBuffer(entrada);
		System.out.println("Confirme seu email: ");
		email = entrada.nextLine();
		System.out.println("Confirme sua senha: ");
		senha = entrada.nextLine();
		for (int i = 0; i < d.getnClientes(); i++) {
			if (d.getClientes()[i].getEmail().compareToIgnoreCase(email) == 0) {
				System.out.println("O cliente a ser removido é: " + d.getClientes()[i]);
				System.out.println("0 - Cancelar\n1 - Continuar");
				opc = entrada.nextInt();
				if (opc == 1) {
					if (i < d.getnClientes() && i >= 0) {
						swapListaClientes(i);
						d.setCliente(d.getnClientes(), null);
						d.setnClientes(d.getnClientes() - 1);
						System.out.println("Cliente removido com sucesso!");
					}
				} else {
					System.out.println("Operação cancelada!");
				}
			}
		}
	}

	public static void buscarRestaurante() {
		entrada.nextLine();
		System.out.println("Digite o nome do restaurante que deseja buscar: ");
		String nomeRestaurante = entrada.nextLine();

		List<Restaurante> restaurantesEncontrados = new ArrayList<>();

		for (int i = 0; i < d.getnRestaurantes(); i++) {
			if (d.getRestaurantes()[i].getNome().equalsIgnoreCase(nomeRestaurante)) {
				restaurantesEncontrados.add(d.getRestaurantes()[i]);
			}
		}

		if (!restaurantesEncontrados.isEmpty()) {
			System.out.println("Restaurantes encontrados:");
			for (Restaurante restaurante : restaurantesEncontrados) {
				System.out.println(restaurante.toString());
			}
		} else {
			System.out.println("Restaurante não encontrado.");
		}
	}

	public static void swapListaClientes(int a) {
		for (int i = a; i < d.getnClientes() - 1; i++)
			d.setCliente(i, d.getClientes(i + 1));
	}

	public static void listarRestaurantes() {
		for (int i = 0; i < d.getnRestaurantes(); i++)
			System.out.println(i + " -> " + d.getRestaurantes()[i].toString());

	}
	
	public static void removerItemCarrinho() {
		System.out.println("Escolha um dos itens a seguir para ser removido:\n");
		listarCarrinho();
		clearBuffer(entrada);
		int i = entrada.nextInt();
		if(i < d.getnItensCarrinho() && i >= 0) {
			swapListaCarrinho(i);
			d.setCarrinho(d.getnItensCarrinho(), null);
			d.setnItensCarrinho(d.getnItensCarrinho() - 1);
			System.out.println("Item removido com sucesso");
		} else {
			System.out.println("Voce escolheu um numero invalido!");
		}
		
	}
	
	public static void swapListaCarrinho(int a) {
		for(int i = a; i < d.getnItensCarrinho() - 1; i++) 
			d.setCarrinho(i, d.getCarrinho(i+1));
	}
	
	public static void listarCarrinho() {
		if(d.getnItensCarrinho() != 0) {
			for(int i = 0; i < d.getnItensCarrinho(); i++) {
				System.out.println(i + "->" + d.getCarrinhos()[i].toString());
			}
			System.out.println("\nVALOR TOTAL -> R$" + precoCarrinho() + "\n");
		}else {
			System.out.println("Carrinho vazio!\n");
		}
	}

	public static void listarClientes() {
		for (int i = 0; i < d.getnClientes(); i++)
			System.out.println(i + " -> " + d.getClientes()[i].toString());

	}

	public static void pagar(){
		listarCarrinho();
		clearBuffer(entrada);
		System.out.println("0 - Cancelar\n1- Confirmar\n");
		int opc = entrada.nextInt();
		switch (opc) {
		case 0:
			System.out.println("Operação cancelada.");
			break;
		case 1:
			boolean login = false;
			String email;
			String endereco = null;
			clearBuffer(entrada);
			System.out.println("Confirme seu email: ");
			email = entrada.nextLine();
			for(int i = 0; i < d.getnClientes(); i++) {
				if(d.getClientes()[i].getEmail().compareToIgnoreCase(email) == 0) {
					login = true;
					endereco = d.getClientes()[i].getEndereco();
				}
			}
			if(login == true) {
				for(int i = 0; i <= d.getnItensCarrinho() && i >= 0; i++) {
					swapListaCarrinho(i);
					d.setCarrinho(d.getnItensCarrinho(), null);
					d.setnItensCarrinho(d.getnItensCarrinho() - 1);
					System.out.println("APAGANDO");
				}
				System.out.println("Obrigado, pedido será entregue em " + endereco + "\nPagamento no ato da entrega.\n");
			}else {
				System.out.println("\nEmail inválido\n");
				break;
			}
			
			break;
		default:
			System.out.println("\nOpção inválida!\n");
			break;
		}
		
	}
	
	public static void listarAdministradores() {
		for (int i = 0; i < d.getnAdmin(); i++) {
			System.out.println(i + "->" + d.getAdministradores()[i].toString());
		}
	}

	private static void clearBuffer(Scanner scanner) {
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
	}
}
