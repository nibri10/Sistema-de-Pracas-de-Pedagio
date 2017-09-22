package br.unifae.poo.pedagio.views;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sound.midi.ControllerEventListener;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;

import br.unifae.poo.pedagio.constants.Menu;
import br.unifae.poo.pedagio.models.Comercial;
import br.unifae.poo.pedagio.models.Pedagio;
import br.unifae.poo.pedagio.models.UtilitarioPasseio;
import br.unifae.poo.pedagio.constants.*;
import br.unifae.poo.pedagio.controller.PedagioController;

public class TestaPedagio {

	private static PedagioController controller = new PedagioController();

	// faz a leitura das entradas no console
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	/**
	 * este metodo cria o menu principal
	 */
	private static void menu() {

		int op = 0;

		while (true) {

			System.out.println("\n1-Cadastrar Praça" + "\n2-Cadastrar Passeio"
					+ "\n3-Cadastrar Comercial" + "\n4-Exibir Relatório"
					+ "\n5-Pesquisar Veiculo" + "\n0-Sair");

			op = scan.nextInt();

			switch (op) {

			case Menu.CADASTRAR_PEDAGIO:
				cadastraPedagio();
				break;
			case Menu.CADASTRAR_PASSEIO_UTILITARIO:
				cadastrarPasseUtili();
				break;
			case Menu.CADASTRAR_COMERCIAL:
				cadastrarComercial();
				break;
			case Menu.EXIBIR_RELATORIO:
				faturamento();
				break;
			case Menu.PESQUISAR_VEICULO:
				buscarVeiculo();
				break;
			case Menu.SAIR:
				System.exit(0);
			default:

			}

		}

	}

	/**
	 * este metodo é responsavel por inserir os registros de praças de pedagios
	 */
	private static void cadastraPedagio() {

		double valorEixo = 0;

		System.out.println("\nDigite o nome da concessionária: ");
		String nome = scan.next();// faz a leitura no nome
		System.out.println("\nDigite o local do pedágio: ");
		String local = scan.next();// faz a leitura do local
		System.out.println("\nDigite o valor cobrado por eixo: ");
		try {
			valorEixo = scan.nextDouble();// faz aleitura do valor por eixo
		} catch (InputMismatchException e) {
			System.err.println("\nEste campo aceita somente numeros!");
			scan.next();
			cadastraPedagio();
			return;
		}

		// instancia e cria um novo objeto pedagio
		Pedagio pedagio = new Pedagio(nome, local, valorEixo);

		// verifica se a lista de pedagios está cheia ou não
		String message = controller.add(pedagio) ? "Pedágio Registrado!"
				: "Lista cheia!";
		System.out.println("\n" + message);

	}

	/**
	 * este metodo é responsavel por cadastrar os veiculos dos tipos
	 * Passeio/Utilitarios
	 */
	private static void cadastrarPasseUtili() {
		// variavel que armazena codigo do pedagio
		int codigo = 0;
		System.out.println("Digite o código do pedagio:");
		// verifica se o usuario digitou algo do tipo string
		try {
			codigo = scan.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("\nEste campo aceita somente numeros!");
			scan.next();
			cadastrarPasseUtili();
			return;
		}

		if (codigo == 0) {
			System.err.println("\nOs a serem buscados devem ser > 0\n");
			cadastrarPasseUtili();
			return;
		}

		Pedagio pedagio = controller.getById(codigo);

		// verifica se existe algum registro no repositorio
		if (!controller.isNull()) {
			// verifica se o registro buscado foi encontrado
			if (pedagio != null) {

				System.out.println("\nDigite as informações do veiculo:\n");
				System.out.println("Placa: ");
				String placa = scan.next();
				UtilitarioPasseio utilPass = new UtilitarioPasseio(placa);

				// insere na lista de veiculos do tipo util/pass
				boolean sucess = controller.addUtilitarioPasseio(pedagio,
						utilPass);

				// verifica e retorna a menssagem de sucesso ou falha na
				// inserção do veiculo
				String message = sucess ? "\nVeiculo adicionado com sucesso!\n"
						: "\nLista de veiculos cheia!\n";
				System.out.println(message);

				return;
			} else {
				// verifica se algo foi encontrado, se não exibe a menssagem
				// de de codigo não encontrado
				System.out.println("\nCódigo não encontrado!\n");
			}

		} else {

			// Esta condição indica que o repositorio de pedagios esta vazio
			System.out.println("\nvetor vazio!\n");
		}

	}
	//Cadastrando Veiculos de Tipo comercial
	private static void cadastrarComercial() {
		// variavel que armazena o codigo do pedagio
		int codigo = 0;
		System.out.println("Digite o código do pedagio:");
		// verifica se o usuario digitou algo do tipo string
		try {
			codigo = scan.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("\nEste campo aceita somente numeros!");
			scan.next();
			cadastrarComercial();
			return;
		}

		if (codigo == 0) {
			System.err.println("\nOs a serem buscados devem ser > 0\n");
			cadastrarPasseUtili();
			return;
		}

		Pedagio pedagio = controller.getById(codigo);

		// verifica se existe algum registro no repositorio
		if (!controller.isNull()) {
			// verifica se o registro buscado foi encontrado
			if (pedagio != null) {

				System.out.println("\nDigite as informações do veiculo:\n");
				System.out.println("Placa: ");
				String placa = scan.next();
				System.out.println("\nQuantidade de eixos: ");
				int eixos = scan.nextInt();

				Comercial comercial = new Comercial(placa, eixos);
				// insere na lista de veiculos do comercial
				boolean sucess = controller.addComercial(pedagio, comercial);
				// verifica e retorna a menssagem de sucesso
				// ou falha na inserção do veiculo
				String message = sucess ? "\nVeiculo adicionado com sucesso!\n"
						: "\nLista de veiculos cheia!\n";
				System.out.println(message);

				return;
			} else {
				// verifica se algo foi encontrado, se não exibe a menssagem
				// de de codigo não encontrado
				System.out.println("\nCódigo não encontrado!\n");
			}

		} else {

			// Esta condição indica que o repositorio de pedagios esta vazio
			System.out.println("\nvetor vazio!\n");
		}

	}

	private static void faturamento() {
		// armazena a soma total do faturamento
		double somaTotal = 0;
		// pega todos os pedagios registrados
		Pedagio[] pedagios = controller.getAll();

		for (Pedagio pedagio : pedagios) {
			// verifica se o indice do vetor contem um obbjeto do tipo pedagio
			if (pedagio != null) {

				// carrega a lista de veiculos utilitarios que
				// foram cadastrados para o pedagio
				UtilitarioPasseio[] utilPass = pedagio.getUtilitarioPasseio();
				// carrega a lista de veiculos comerciais que
				// foram cadastrados para o pedagio
				Comercial[] comercial = pedagio.getComercial();

				// exibe o codigo e o local da praça de pedagio
				System.out
						.println("---------------------------------------------------------");
				System.out.println("\nPraça de pedágio:\n");
				System.out.println(pedagio.toString());
				System.out
						.println("---------------------------------------------------------");
				// Exibe os veiculos da categoria 1 que passaram pela praça
				System.out.println("\nVeiculos categoria 1:\n");

				for (int x = 0; x < utilPass.length; x++) {

					if (utilPass[0] == null)
						System.out
								.println("\nNão existem registros da categoria 1!");

					if (utilPass[x] != null) {
						somaTotal += utilPass[x].getValorPago();
						System.out.println(utilPass[x].toString());
					} else {
						break;
					}
				}

				System.out
						.println("\n---------------------------------------------------------\n");

				// Exibe os veiculos da categoria 2 que passaram pela praça
				System.out.println("\nVeiculos categoria 2:\n");

				for (int x = 0; x < comercial.length; x++) {

					if (comercial[0] == null)
						System.out
								.println("\nNão existem registros da categoria 2!");

					if (comercial[x] != null) {
						somaTotal += comercial[x].getValorPago();
						System.out.println(comercial[x].toString());
					} else {
						break;
					}
				}
			}

		}

		if (controller.isNull()) {
			// verifica se algo foi encontrado, se não exibe a menssagem
			// de de codigo não encontrado
			System.out.println("\nNenhum pedagio cadastrado!\n");
			return;
		}

		System.out.println("\n----------------------------------------\n");
		// exibe a soma total do faturamento
		System.out.println("\n\nValor Total: " + somaTotal);
		// exibe o percentual que a prefeitura da cidade deve receber
		System.out.println("\nValor a ser recebido pela prefeitura: "
				+ ((somaTotal * 30) / 100));
		System.out.println("\n----------------------------------------\n");

	}

	private static void buscarVeiculo() {

		// pega todos os pedagios registrados
		Pedagio[] pedagios = controller.getAll();

		// armazena se algum registro foi encontrado do veiculo que foi buscado
		boolean encontrado = false;
		// armazena se o nome da praca de pedagio deve ser exibida ou
		// não para que não fique repetindo no loop
		boolean nomePrint = false;
		System.out.println("\nDigite a placa do veiculo:");
		String placa = scan.next();

		System.out.println("\n----------------------------------------\n");

		if (controller.isNull()) {
			System.out.println("\nSem pedagios cadastrados!\n");
		}

		for (Pedagio pedagio : pedagios) {
			// verifica se o indice do vetor contem um obbjeto do tipo pedagio
			if (pedagio != null) {

				// carrega a lista de veiculos utilitarios que foram
				// cadastrados para o pedagio
				UtilitarioPasseio[] utilPass = pedagio.getUtilitarioPasseio();

				// carrega a lista de veiculos comerciais que foram
				// cadastrados para o pedagio
				Comercial[] comercial = pedagio.getComercial();

				// exibe se o veiculo que se encaixar na categoria 1
				for (int x = 0; x < utilPass.length; x++) {
					if (utilPass[x] != null)
						if (utilPass[x].getPlaca().equalsIgnoreCase(placa)) {

							if (!nomePrint) {
								System.out.println("\nPedagio: "
										+ pedagio.getNome() + "\n");
								nomePrint = true;
							}
							System.out.println("\nHorario: "
									+ utilPass[x].getHora());

							System.out.println("\nData: "
									+ utilPass[x].getData());

							encontrado = true;
						}
				}

				// exibe se o veiculo que se encaixar na categoria 2
				for (int x = 0; x < comercial.length; x++) {
					if (comercial[x] != null)
						if (comercial[x].getPlaca().equalsIgnoreCase(placa)) {

							if (!nomePrint) {
								System.out.println("\nPedagio: "
										+ pedagio.getNome() + "\n");
								nomePrint = true;
							}
							System.out.println("\nHorario: "
									+ comercial[x].getHora());

							System.out.println("\nData: "
									+ comercial[x].getData());

							encontrado = true;
						}
				}

			} else {
				break;
			}

			System.out.println("\n----------------------------------------\n");

			nomePrint = false;

		}

		if (!encontrado)
			System.out.println("\nVeiculo não encontrado!\n");

	}

}
