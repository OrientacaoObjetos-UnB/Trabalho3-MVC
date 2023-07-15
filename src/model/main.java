// SISTEMA DESENVOLVIDO PARA USO PROMPT
// GERENCIADOR DE ACESSOS DE VEÍCULOS
// GRUPO:

// * DANIEL RODRIGUES DA ROCHA - 211061583;
// * BRUNO RICARDO DE MENEZES - ;
// * AMANDA DE MOURA DA SILVA - 221022220;
// * JÉSUS GABRIEL CARVALHO VENTURA - 211062956;
// * GABRIEL FENELON ROCHA GONÇALVES - 211061743.

// VERSÃO 1.0

package model;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;


public class main {
	

	public static void main(String[] args) {
		
		// VARIÁVEIS NECESSÁRIAS PARA O SISTEMA:
		List<Estacionamento> registros;
		List<AcessoEvento> registroE;
		
		
		// INSTÂNCIAS NECESSÁRIAS PARA O SISTEMA:
		registros = new LinkedList<Estacionamento>();
		registroE = new LinkedList<AcessoEvento>();
		
		// INÍCIO DO SISTEMA:
		exibirMenuPrincipal(registros, registroE);
		
		
		

	}
	
	// FUNÇÕES(métodos) NECESSÁRIAS PARA O FUNCIONAMENTO DO SISTEMA:
		public static void exibirMenuPrincipal(List<Estacionamento> banco, List<AcessoEvento> bancoE) {
			
			int escolha = 0;
			Scanner scanner = new Scanner(System.in);
			
			limparPrompt();
			System.out.println("==================================================\n   GERENCIADOR DE ACESSOS DE ESTACIONAMENTO:\n\n"
					+ "Digite a Opção desejada:\n\n" + "(1) Visualizar Estacionamentos;\n(2) Criar um Estacionamento\n"
					+ "(3) Criar um Acesso\n(4) Configurar Preços\n(5) Listar Eventos \n(6) Adicionar Evento \n\n================================================== \n\n");
			
				System.out.println("Digite: ");
				escolha = scanner.nextInt();
				distribuidoraDaEscolha(escolha, banco, bancoE);
		}
		
		public static void distribuidoraDaEscolha(int escolha, List<Estacionamento> banco, List<AcessoEvento> bancoE) {
			
			switch (escolha) {
			
				case 1:
					escolha1(banco, bancoE);
					break;
				
				case 2:
					escolha2(banco, bancoE);
					break;
					
				case 3:
					escolha3(banco, bancoE);
					break;
				case 4:
					escolha4(banco, bancoE);
					break;
				case 5:
					escolhaListarEvento(banco, bancoE);
					break;
				case 6:
					escolha5(banco, bancoE);
					
				default:
					limparPrompt();
					System.out.println("Digite somente o número, dentro das possibilidades mencionadas! \n\n Direcionando ao menu...");
					aplicarDelay(3000);
					limparPrompt();
					exibirMenuPrincipal(banco, bancoE);
			}
			
			
		}
		
		public static void escolha1(List<Estacionamento> banco, List<AcessoEvento> bancoE) {
			
			Scanner scanner = new Scanner(System.in);
			
			limparPrompt();
			System.out.println("==================================================\n         ESTACIONAMENTOS REGISTRADOS:\n========="
					+ "=========================================");
			
			if (banco.size() == 0) {
				System.out.println("\n\n");
				System.out.println("Registre Estacionamentos para Listá-los!");
				aplicarDelay(3000);
				limparPrompt();
				System.out.println("Redirecinando ao menu principal, Aguarde...");
				aplicarDelay(3000);
				exibirMenuPrincipal(banco, bancoE);
			}
			else {
				for (Estacionamento e: banco) {
					System.out.println("\n\n");
					System.out.println("Nome do Estacionamento: " + e.getNome() + "\nCapacidade: " + e.getAcessos().size() + "/" + e.getCapacidade()
					+ "\nPorcentagem de Retorno: " + e.getRetornoContratante() + "%\nHorário de Funcionamento: Das " +
					e.getHorarioFuncionamento().get(0).getHoraMinuto() + " até " + e.getHorarioFuncionamento().get(1).getHoraMinuto());
					
					System.out.println("\n\n LUCRO TOTAL: R$" +  e.calcularTotalContratante() + "\n\n\n==============="
					+ "===================================");
					
				}
				System.out.println("\n\n\n");
				System.out.println("Dê scroll para cima para visualizar os seus registros.\nAguarde...\n\n");
				aplicarDelay(5000);
				System.out.println("===================================\n\nEscolha uma das Opções:\n\n(1) Pesquisar Estacionamento\n(2) Verificar Acessos;\n(3) Apagar Estacionamento;\n"
				+ "(4) Voltar ao Menu Principal\n\nDigite: ");
				int resposta = 0; 
				
				resposta = scanner.nextInt();
				distribuicaoEscolha2(resposta, banco, bancoE);
				
				}
			}
		
		public static void distribuicaoEscolha2(int escolha, List<Estacionamento> banco, List<AcessoEvento> bancoE) {
			
			switch (escolha) {
				case 1:
					escolha0(banco, bancoE);
					break;
				case 2:
					escolha1_1(banco, bancoE);
					break;
				case 3:
				escolha1_2(banco, bancoE);
					break;
				case 4:
					limparPrompt();
					System.out.println("Redirecinando ao menu principal, Aguarde...");
					aplicarDelay(3000);
					exibirMenuPrincipal(banco, bancoE);
			}
			
		}

		public static void escolha0(List<Estacionamento> banco, List<AcessoEvento> bancoE) {
			
			Scanner scanner = new Scanner(System.in);

			String valorPesquisa;

			limparPrompt();
			System.out.println("Digite o nome do estacionamento de interesse:\n");
			valorPesquisa = scanner.next();

			for (Estacionamento e: banco) {
				if (e.getNome().equals(valorPesquisa)) {
					limparPrompt();
					System.out.println("Nome do Estacionamento: " + e.getNome() + "\nCapacidade: " + e.getAcessos().size() + "/" + e.getCapacidade()
					+ "\nPorcentagem de Retorno: " + e.getRetornoContratante() + "%\nHorário de Funcionamento: Das " +
					e.getHorarioFuncionamento().get(0).getHoraMinuto() + " até " + e.getHorarioFuncionamento().get(1).getHoraMinuto());
					
					System.out.println("\n\n LUCRO TOTAL: R$" +  e.calcularTotalContratante() + "\n\n");

					System.out.println("Aguarde...");
					aplicarDelay(4000);
					escolha1(banco, bancoE);
					return;
				}
			
			}
			limparPrompt();
			System.out.println("Estacionamento inexistente!");
			aplicarDelay(4000);
			escolha1(banco, bancoE);
			return;
		}
		
		public static void escolha1_1(List<Estacionamento> banco, List<AcessoEvento> bancoE) {
			
			// INSTÂNCIAS NECESSÁRIAS PARA A FUNÇÃO:
			Scanner scanner = new Scanner(System.in);
			
			limparPrompt();
			int resposta = 0;
			int contador = 0;
			
			while (resposta < 1 || resposta > contador) {
				contador ++;
				
				System.out.println("\n\n");
				System.out.println("Para qual estacionamento você gostaria de verificar os acessos?\n(Digite o número do estacionamento desejado)\n\n");
				
				
				for (Estacionamento e: banco) {
					System.out.println("(" + contador + ") " + e.getNome() + "\n");
					contador ++;
				}
					System.out.println("(" + contador + ") Retornar à Pagina anterior");

				System.out.println("\nDigite: ");
				resposta = scanner.nextInt();
				
				if (resposta == contador) {
					escolha1(banco, bancoE);
				}
				if (resposta < 1 || resposta > contador) {
					limparPrompt();
					System.out.println("Selecione dentre as opções listadas!");
					aplicarDelay(5000);
					limparPrompt();
					contador = 0;
				}

				
			}
			
			limparPrompt();
			System.out.println("==================================================\n         ACESSOS LIBERADOS:\n========="
					+ "=========================================");
			
			if (banco.get(resposta - 1).getAcessos().size() == 0) {
				System.out.println("\n\nSem Nenhum Acesso! Faça Acessos através do menu princial.");
				aplicarDelay(3000);
				escolha1(banco, bancoE);
			}
			else {
				for (Acesso v: banco.get(resposta -1).getAcessos()) {

					System.out.println("\n\nPlaca do veículo: " + v.getPlacaCarro() + "\n\n");
					System.out.println("==================================================");
				}
				
				int resposta2 = 0;
				System.out.println("\n\nDê scroll para cima para visualizar os seus registros.\nAguarde...\n");
				aplicarDelay(5000);
				
				while (resposta2 < 1 || resposta2 > 3) {
					System.out.println("===================================\n\nEscolha uma das Opções:\n\n(1) Apagar Acesso;\n(2) Voltar para a lista de Estacionamentos;\n"
					+ "(3) Voltar ao Menu Principal\n\nDigite: ");
					resposta2 = scanner.nextInt();

					if (resposta2 < 1 || resposta2 > 3) {
						limparPrompt();
						System.out.println("Escolha dentre as opções disponíveis!");
						aplicarDelay(3000);
					}
					else {
						switch (resposta2) {
							case 1:
								escolha1_1_1(banco, resposta - 1, bancoE);
								break;
							case 2:
								escolha1(banco, bancoE);
								break;
							case 3:
								exibirMenuPrincipal(banco, bancoE);
								break;
						}
					}
				}

			}
			
		}

		public static void escolha1_1_1(List<Estacionamento> banco, int referencia, List<AcessoEvento> bancoE) {
			
			limparPrompt();
			Scanner scanner = new Scanner(System.in);

			String resposta = "";
			int contador = 1;
			boolean inexistencia = true;

			while (inexistencia) {
				
				System.out.println("Qual acesso você gostaria de apagar?\n");
			
				for(Acesso v: banco.get(referencia).getAcessos()) {
					System.out.println("(" + contador + ") " + v.getPlacaCarro() + "\n");
					contador++;
				}
					System.out.println("(" + contador + ") Cancelar");

				System.out.println("\nDigite o nome da placa que deseja Apagar ou digite 'Cancelar' para voltar à página "
				 + "anterior:\n");
				resposta = scanner.next();
	
				if (resposta == "Cancelar" || resposta == "cancelar") {
					limparPrompt();
					escolha1_1(banco, bancoE);
					return;
				}
				
				for (Acesso v: banco.get(referencia).getAcessos()) {
					if (v.getPlacaCarro().equals(resposta)){
						inexistencia = false;
					}
				}
				if (inexistencia) {
					limparPrompt();
					System.out.println("Placa não registrada! Digite o nome da placa corretamente");
					aplicarDelay(3000);
					contador = 1;
					limparPrompt();
				}
			}

			banco.get(referencia).removeAcessos(resposta);
			limparPrompt();
			System.out.println("Acesso Apagado!");
			banco.get(referencia).setSituacaoCapacidade(true);
			aplicarDelay(3000);

			int resposta2 = 0;

			limparPrompt();

			while (resposta2 < 1 || resposta2 > 2) {

				System.out.println("===================================\n\nEscolha uma das Opções:\n\n(1) Voltar para o Menu Principals;\n(2) Voltar para a Lista de Estacionamentos\n"
				+ "\n\nDigite:");
				resposta2 = scanner.nextInt();

				if (resposta2 < 1 || resposta2 > 2) {
					limparPrompt();
					System.out.println("Escolha dentre as opções listadas!");
					aplicarDelay(3000);
				}
			}

			switch (resposta2) {
				case 1:
					limparPrompt();
					System.out.println("Redirecinando ao menu principal, Aguarde...");
					aplicarDelay(3000);
					exibirMenuPrincipal(banco, bancoE);
					break;
				case 2:
					escolha1(banco, bancoE);
					break;
			}
		}

		public static void escolha1_2(List<Estacionamento> banco, List<AcessoEvento> bancoE) {

			limparPrompt();
			// CLASSE PARA APAGAR UM ESTACIONAMENTO

			// INSTÂNCIAS NECESSÁRIAS PARA A FUNÇÃO:
			Scanner scanner = new Scanner(System.in);

			int resposta = 0;
			int contador = 0;

			while (resposta < 1 || resposta > contador) {
				contador++;

				System.out.println("Qual estacionamento você gostaria de apagar?\n");
			
				for(Estacionamento e: banco) {
					System.out.println("(" + contador + ") " + e.getNome());
					contador++;
				}
					System.out.println("\n(" + contador + ") Retornar à página anterior");
				System.out.println("\nDigite a sua opção:\n");
				resposta = scanner.nextInt();
	
				if (resposta == contador) {
					escolha1(banco, bancoE);
				}
				if (resposta < 1 || resposta > contador) {
					limparPrompt();
					System.out.println("Escolha dentre as opções listadas!");
					aplicarDelay(3000);
					contador = 0;
				}
				else {
					banco.remove(resposta - 1);
					limparPrompt();
					System.out.println("Estacionamento Apagado!");
					aplicarDelay(3000);

					resposta = 0;

					limparPrompt();

					while (resposta < 1 || resposta > 2) {

						System.out.println("===================================\n\nEscolha uma das Opções:\n\n(1) Voltar para o Menu Principals;\n(2) Voltar para a Lista de Estacionamentos\n"
						+ "\n\nDigite:");
						resposta = scanner.nextInt();

						if (resposta < 1 || resposta > 2) {
							limparPrompt();
							System.out.println("Escolha dentre as opções listadas!");
							aplicarDelay(3000);
						}
					}

					switch (resposta) {
						case 1:
							limparPrompt();
							System.out.println("Redirecinando ao menu principal, Aguarde...");
							aplicarDelay(3000);
							exibirMenuPrincipal(banco, bancoE);
							break;
						case 2:
							escolha1(banco, bancoE);
							break;
					}
				}
			}
			
		} 
			
		
		public static void escolha2(List<Estacionamento> banco, List<AcessoEvento> bancoE) {
			
			// INSTÂNCIAS NECESSÁRIAS PARA A FUNÇÃO:
			Scanner scanner = new Scanner(System.in);
			
			// VARIÁVEL DE DIRECIONAMENTO DO SISTEMA:
			int escolha = 1;
			
			while (escolha == 1) {
				// VARIÁVEIS DE CRIAÇÃO:
				String nome;
				String capacidade;
				double retorno;
				
				// VARIÁVEIS PARA CONFIGURAÇÃO:
				int hI = 0;
				int mI = 0;
				int hF = 0;
				int mF = 0;
				String horaCompleta = "";
				
				while(((hI < 0) || (hI > 23)) || ((mI < 0) || (mI > 59)) || ((hF < 0) || (hF > 23)) || ((mF < 0) || (mF > 59)) || !horaCompleta.contains(":")) {
				// INSTRUÇÕES AO USUÁRIO:
				limparPrompt();
				System.out.println("Qual será o nome do estacionamento?\n(Não use espaçamento)\n");
				nome = scanner.next();
				
				System.out.println("\n\nQual a capacidade deste estacionamento?\n(Digite somente os números)\n");
				capacidade = scanner.next();
				
				System.out.println("\n\nQual a taxa -em porcentagem- de retorno do lucro?\n(Digite somente os números)\n");
				retorno = scanner.nextDouble();
				
				
					
					System.out.println("\n\nQue horas o estacionamento abre?\n(Digite no Formato 'hora:minuto')\n");
					horaCompleta = scanner.next();
					
					if (! horaCompleta.contains(":")) {
						limparPrompt();
						System.out.println("Insira o horário no formato correto: hora:minutos\nRetornando ao menu Princinpal...");
						aplicarDelay(3000);
						exibirMenuPrincipal(banco, bancoE);
					}
					else {
						//Formatação da String:
						String[] partes = horaCompleta.split(":");
						String horaString = partes[0];  // Hora como string
						String minutoString = partes[1];  // Minuto como string
						
						hI = Integer.parseInt(horaString);  // Hora como int
						mI = Integer.parseInt(minutoString);  // Minuto como int
					}	
				
					horaCompleta = "";
				

					System.out.println("\n\nQue horas o estacionamento fecha?\n(Digite no Formato 'hora:minuto')\n");
					horaCompleta = scanner.next();
					
					if (! horaCompleta.contains(":")) {
						limparPrompt();
						System.out.println("Insira o horário no formato correto: hora:minutos\nRetornando ao menu Princinpal...");
						aplicarDelay(3000);
						exibirMenuPrincipal(banco, bancoE);
					}
					else {
						//Formatação da String:
						String[] partes = horaCompleta.split(":");
						String horaString = partes[0];  // Hora como string
						String minutoString = partes[1];  // Minuto como string
						
						hF = Integer.parseInt(horaString);  // Hora como int
						mF = Integer.parseInt(minutoString);  // Minuto como int
						
						try {
							Estacionamento criacao;
							criacao = new Estacionamento(nome, capacidade, retorno, hI, mI, hF, mF);
							banco.add(criacao);
						} catch (ValorAcessoInvalidoException e) {
							limparPrompt();
							System.out.println("\nOpa! Parece que há um erro nos dados que você inseriu! \n\n" + e.getMessage());
							aplicarDelay(5000);
							limparPrompt();
						} catch (DescricaoEmBrancoException e) {
							limparPrompt();
							System.out.println("\nOpa! Parece que há um erro nos dados que você inseriu! \n\n" + e.getMessage());
							aplicarDelay(5000);
							limparPrompt();
						}	
					}
				}
				
				limparPrompt();
				
				System.out.println("Estacionamento Criado!");
				aplicarDelay(2000);
				limparPrompt();
				System.out.println("==================================================\n Gostaria de criar outro"
						+ " estacionamento?\n\n Digite a opção desejada: \n\n(1) Sim; \n(2) Não"
						+ "\n==================================================\n\nDigite: ");
				escolha = scanner.nextInt();
				
				
				exibirMenuPrincipal(banco, bancoE);
			
		}
	}
		
		public static void escolha3(List<Estacionamento> banco, List<AcessoEvento> bancoE) {
			
			// INSTÂNCIAS NECESSÁRIAS PARA A FUNÇÃO:
			Scanner scanner = new Scanner(System.in);
						
			limparPrompt();
			System.out.println("==================================================\n         CRIAR NOVO ACESSO:\n========="
					+ "=========================================");
			
			if (banco.size() == 0) {
				System.out.println("\n\n");
				System.out.println("Registre Estacionamentos para criar Acessos!!");
				aplicarDelay(3000);
				limparPrompt();
				System.out.println("Redirecinando ao menu principal, Aguarde...");
				aplicarDelay(3000);
				exibirMenuPrincipal(banco, bancoE);
			}
			else {
				int resposta = 0;
				int contador = 0;
				boolean situacaoLotado = false;
				
				while (resposta < 1 || resposta > contador || situacaoLotado == false) {
					contador ++;
					
					System.out.println("\n\n");
					System.out.println("Para qual estacionamento você gostaria de autorizar o acesso?\n(Digite o número do estacionamento desejado)\n\n");
					
					
					for (Estacionamento e: banco) {
						System.out.println("(" + contador + ") " + e.getNome() + "\n");
						contador ++;
					}
						System.out.println("(" + contador + ") Voltar ao Menu Principal\n");
					
					System.out.println("Digite: ");
					resposta = scanner.nextInt();
					
					if (resposta < 1 || resposta > contador) {
						limparPrompt();
						System.out.println("Selecione dentre as opções listadas!");
						aplicarDelay(5000);
						limparPrompt();
						contador = 0;
					}

					if (resposta == contador) {
						limparPrompt();
						System.out.println("Redirecinando ao menu principal, Aguarde...");
						aplicarDelay(3000);
						exibirMenuPrincipal(banco, bancoE);
					}

					situacaoLotado = banco.get(resposta - 1).getSituacaoCapacidade();

					if (situacaoLotado == false) {
						limparPrompt();
						System.out.println("Estacionamento Lotado! Tente apagar algum Acesso");
						aplicarDelay(5000);
						limparPrompt();
						contador = 0;
					}
				}
				
				String placa;
				limparPrompt();
				System.out.println("Insira a placa do Carro:\n");
				placa = scanner.next();
				
				banco.get(resposta - 1).setAcessos(placa);
				
				if (banco.get(resposta - 1).getAcessos().size() == banco.get(resposta - 1).getCapacidade()) {
					banco.get(resposta - 1).setSituacaoCapacidade(false);
				}

				limparPrompt();
				System.out.println("Acesso Liberado!");
				aplicarDelay(3000);
				exibirMenuPrincipal(banco, bancoE);
				
			}
		}
		
		public static void escolha4(List<Estacionamento> banco, List<AcessoEvento> bancoE) {

		}

		public static void escolhaListarEvento(List<Estacionamento> banco, List<AcessoEvento> bancoE) {
			
			Scanner scanner = new Scanner(System.in);
			
			limparPrompt();
			System.out.println("==================================================\n         EVENTOS REGISTRADOS:\n========="
					+ "=========================================");
			
			if (bancoE.size() == 0) {
				System.out.println("\n\n");
				System.out.println("Registre Eventos para Listá-los!");
				aplicarDelay(3000);
				limparPrompt();
				System.out.println("Redirecinando ao menu principal, Aguarde...");
				aplicarDelay(3000);
				exibirMenuPrincipal(banco, bancoE);
			}
			else {
				for (AcessoEvento e: bancoE) {
					System.out.println("\n\n");
					System.out.println("Nome do Evento: " + e.getnomeEvento());
					
					System.out.println("\n\n PREÇO DE ENTRADA: R$" +  e.getvalor() + "\n\n\n==============="
					+ "===================================");
					
				}
				System.out.println("\n\n\n");
				System.out.println("Dê scroll para cima para visualizar os seus registros.\nAguarde...\n\n");
				aplicarDelay(5000);
				System.out.println("===================================\n\nEscolha uma das Opções:\n\n(1) Pesquisar Evento\n(2) Apagar Evento\n"
				+ "(3) Voltar ao Menu Principal\n\nDigite: ");
				int resposta = 0; 
				
				resposta = scanner.nextInt();
				distribuicaoEscolha3(resposta, banco, bancoE);
				
				}
			}

			public static void distribuicaoEscolha3(int escolha, List<Estacionamento> banco, List<AcessoEvento> bancoE) {
			
			switch (escolha) {
				case 1:
					escolhaPesquisarEvento(banco, bancoE);
					break;
				case 2:
					escolhaApagarEvento(banco, bancoE);
					break;
				case 3:
					limparPrompt();
					System.out.println("Redirecinando ao menu principal, Aguarde...");
					aplicarDelay(3000);
					exibirMenuPrincipal(banco, bancoE);
					break;
				default:
					limparPrompt();
					System.out.println("Selecione dentre as opções disponíveis!");
					aplicarDelay(3000);
					escolhaListarEvento(banco, bancoE);
			}
			
		}

		public static void escolhaApagarEvento(List<Estacionamento> banco, List<AcessoEvento> bancoE) {

			limparPrompt();
			// CLASSE PARA APAGAR UM EVENTO

			// INSTÂNCIAS NECESSÁRIAS PARA A FUNÇÃO:
			Scanner scanner = new Scanner(System.in);

			int resposta = 0;
			int contador = 0;
			AcessoEvento referencia;

			while (resposta < 1 || resposta > contador) {
				contador++;

				System.out.println("Qual evento você gostaria de apagar?\n");
			
				for(AcessoEvento e: bancoE) {
					System.out.println("(" + contador + ") " + e.getnomeEvento());
					contador++;
				}
					System.out.println("\n(" + contador + ") Retornar à página anterior");
				System.out.println("\nDigite a sua opção:\n");
				resposta = scanner.nextInt();
	
				if (resposta == contador) {
					escolhaListarEvento(banco, bancoE);
				}
				if (resposta < 1 || resposta > contador) {
					limparPrompt();
					System.out.println("Escolha dentre as opções listadas!");
					aplicarDelay(3000);
					contador = 0;
				}
				else {
					referencia = bancoE.get(resposta - 1);
					bancoE.remove(resposta - 1);
					limparPrompt();
					for (Estacionamento e: banco) {
						 for (AcessoEvento a: e.getValores().getEvento()){
							if (a.getnomeEvento() == referencia.getnomeEvento()) {
								e.getValores().removerEvento(referencia);
							}
						 }

						 }
				}
			}
					System.out.println("Evento Apagado!");
					aplicarDelay(3000);

					resposta = 0;

					limparPrompt();

					while (resposta < 1 || resposta > 2) {

						System.out.println("===================================\n\nEscolha uma das Opções:\n\n(1) Voltar para o Menu Principal;\n(2) Voltar para a Lista de Eventos\n"
						+ "\n\nDigite:");
						resposta = scanner.nextInt();

						if (resposta < 1 || resposta > 2) {
							limparPrompt();
							System.out.println("Escolha dentre as opções listadas!");
							aplicarDelay(3000);
						}
					}

					switch (resposta) {
						case 1:
							limparPrompt();
							System.out.println("Redirecinando ao menu principal, Aguarde...");
							aplicarDelay(3000);
							exibirMenuPrincipal(banco, bancoE);
							break;
						case 2:
							escolhaListarEvento(banco, bancoE);
							break;
					}
			}

			public static void escolhaPesquisarEvento(List<Estacionamento> banco, List<AcessoEvento> bancoE) {
			
			Scanner scanner = new Scanner(System.in);

			String valorPesquisa;

			limparPrompt();
			System.out.println("Digite o nome do evento de interesse:\n");
			valorPesquisa = scanner.next();

			for (AcessoEvento e: bancoE) {
				if (e.getnomeEvento().equals(valorPesquisa)) {
					limparPrompt();
					System.out.println("Nome do Evento: " + e.getnomeEvento());
					
					System.out.println("\n\n PREÇO DE ENTRADA: R$" +  e.getvalor() + "\n\n\n==============="
					+ "===================================");

					System.out.println("Aguarde...");
					aplicarDelay(4000);
					escolhaListarEvento(banco, bancoE);
					return;
				}
			
			}
			limparPrompt();
			System.out.println("Evento inexistente!");
			aplicarDelay(4000);
			escolha1(banco, bancoE);
			return;
		}
		
		public static void escolha5(List<Estacionamento> banco, List<AcessoEvento> bancoE) {
			
			Scanner scanner = new Scanner(System.in);
			
			limparPrompt();
			System.out.println("==================================================\n         REGISTRO DE EVENTOS:\n========="
					+ "=========================================");

			int escolha = 1;
					
			while (escolha == 1) {
				String nomeEvento = "";
				String valor = "";
				while (nomeEvento.isEmpty() || valor.isEmpty() || Double.valueOf(valor) < 0 || valor.contains(",")) {
					System.out.println("\n\n\nDigite o nome do evento:\n");
					nomeEvento = scanner.next();
					
					System.out.println("\n\nDigite o valor da entrada: (Use ponto para expressar a vírgula)");
					valor = scanner.next();
		
					try {
						AcessoEvento insercao;
						insercao = new AcessoEvento(nomeEvento, valor);

						bancoE.add(insercao);
					} catch (ValorAcessoInvalidoException e) {
						limparPrompt();
						System.out.println("\nOpa! Parece que há um erro nos dados que você inseriu! \n\n" + e.getMessage());
						aplicarDelay(5000);
						valor = "";
						limparPrompt();
					} catch (DescricaoEmBrancoException e) {
						limparPrompt();
						System.out.println("\nOpa! Parece que há um erro nos dados que você inseriu! \n\n" + e.getMessage());
						aplicarDelay(5000);
						valor = "";
						limparPrompt();
					}
				}
				
				limparPrompt();
				System.out.println("Evento Criado!");
				aplicarDelay(2000);
				limparPrompt();
				System.out.println("==================================================\n Gostaria de criar outro"
				+ " Evento?\n\n Digite a opção desejada: \n\n(1) Sim; \n(2) Não"
				+ "\n==================================================\n\nDigite: ");
				escolha = scanner.nextInt();
				limparPrompt();
			}
				
			exibirMenuPrincipal(banco, bancoE);

		}
		
		public static void limparPrompt() {
			 System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
		
		
		public static void aplicarDelay(int tempo) {
			 try {
		            Thread.sleep(tempo);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		}

}
