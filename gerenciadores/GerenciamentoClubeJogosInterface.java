package gerenciadores;
import modelos.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GerenciamentoClubeJogosInterface {
	
	public void gerenciaUsuario() {
		GerenciadorUsuario<Usuario> g = new GerenciadorUsuario<Usuario>();
		System.out.println("\nO que deseja fazer?");
		System.out.println("(1) Cadastrar usuários antigos");
		System.out.println("(2) Exportar usuários sistema antigo");
		System.out.println("(3) Cadastrar novo usuário");
		System.out.println("(4) Cadastrar novos usuários");
		System.out.println("(5) Visualizar usuário (nome)");
		System.out.println("(6) Visualizar usuário (matrícula)");
		System.out.println("(7) Visualizar todos os usuários");
		System.out.println("(8) Editar usuário (nome)");
		System.out.println("(9) Editar usuário (matrícula)");
		System.out.println("(10) Remover usuário (nome)");
		System.out.println("(11) Remover usuário (matrícula)");
		Scanner scan = new Scanner(System.in);
		String opcao = scan.nextLine();
		String nome = "";
		String matricula = "";
		switch (opcao) {
			case "1":
				System.out.println("\nDigite o nome do arquivo");
				String arquivo = scan.nextLine();
				Path path = Paths.get(arquivo.trim());
				g.cadastraUsuariosAntigos(path);
			break;
			case "2":
				g.exportaUsuariosSistemaAntigo();
			break;
			case "3":
				g.cadastrarNovoUsuario();
			break;
			case "4":
				//g.cadastrarNovosUsuarios();
			break;
			case "5":
				System.out.println("Digite o nome do usuário que deseja buscar");
				nome = scan.nextLine();
				g.visualizarUsuario(nome.trim());
			break;
			case "6":
				System.out.println("Digite o número de matrícula do usuário que deseja buscar");
				matricula = scan.nextLine();
				g.visualizarUsuario(Integer.parseInt(matricula));
			break;
			case "7":
				g.visualizarTodosUsuarios();
			break;
			case "8":
				System.out.println("Digite o nome do usuário que deseja editar");
				nome = scan.nextLine();
				g.editarUsuario(nome.trim());
			break;
			case "9":
				System.out.println("Digite o número de matrícula do usuário que deseja editar");
				matricula = scan.nextLine();
				g.editarUsuario(Integer.parseInt(matricula));
			break;
			case "10":
				System.out.println("Digite o nome do usuário que deseja remover");
				nome = scan.nextLine();
				g.removerUsuario(nome);
			break;
			case "11":
				System.out.println("Digite o núemro da matrícula do usuário que deseja remover");
				matricula = scan.nextLine();
				g.removerUsuario(Integer.parseInt(matricula));
			break;
		}
	}

	public void gerenciaAtividade() {
		GerenciadorAtividade<Atividade> g = new GerenciadorAtividade<Atividade>();
		System.out.println("\nO que deseja fazer?");
		System.out.println("(1) Cadastrar nova atividade");
		System.out.println("(2) Cadastrar novas atividades");
		System.out.println("(3) Visualizar atividade (nome)");
		System.out.println("(4) Visualizar atividade (id)");
		System.out.println("(5) Visualizar todas as atividades");
		System.out.println("(6) Editar atividade (nome)");
		System.out.println("(7) Editar atividade (id)");
		System.out.println("(8) Remover atividade (nome)");
		System.out.println("(9) Remover atividade (id)");
		Scanner scan = new Scanner(System.in);
		String opcao = scan.nextLine();
		String nome = "";
		String id = "";
		switch (opcao) {
			case "1":
				g.cadastrarAtividade();
			break;
			case "2":
				// nao sabemos
			break;
			case "3":
				System.out.println("Digite o nome da atividade que deseja buscar");
				nome = scan.nextLine();
				g.visualizarAtividade(nome.trim());
			break;
			case "4":
				System.out.println("Digite o id da atividade que deseja buscar");
				id = scan.nextLine();
				g.visualizarAtividade(Integer.parseInt(id));
			break;
			case "5":
				g.visualizarTodasAtividades();
			break;
			case "6":
				System.out.println("Digite o nome da atividade que deseja editar");
				nome = scan.nextLine();
				g.editarAtividade(nome.trim());
			break;
			case "7":
				System.out.println("Digite o id da atividade que deseja editar");
				id = scan.nextLine();
				g.editarAtividade(Integer.parseInt(id));
			break;
			case "8":
				System.out.println("Digite o nome da atividade que deseja remover");
				nome = scan.nextLine();
				g.removerAtividade(nome.trim());
			break;
			case "9":
				System.out.println("Digite o id da atividade que deseja remover");
				id = scan.nextLine();
				g.removerAtividade(Integer.parseInt(id));
			break;
		}
	}

	public void gerenciaLocal() {
		GerenciadorLocal<Espaco> g = new GerenciadorLocal<Espaco>();
		System.out.println("\nO que deseja fazer?");
		System.out.println("(1) Cadastrar novo local");
		System.out.println("(2) Cadastrar novos locais");
		System.out.println("(3) Visualizar local (nome)");
		System.out.println("(4) Visualizar local (id)");
		System.out.println("(5) Visualizar todos os locais");
		System.out.println("(6) Editar local (nome)");
		System.out.println("(7) Editar local (id)");
		System.out.println("(8) Remover local (nome)");
		System.out.println("(9) Remover local (id)");
		Scanner scan = new Scanner(System.in);
		String opcao = scan.nextLine();
		String nome = "";
		String id = "";
		switch (opcao) {
			case "1":
				g.cadastrarNovoLocal();
			break;
			case "3":
				System.out.println("Digite o nome do local que deseja buscar");
				nome = scan.nextLine();
				g.visualizarLocal(nome.trim());
			break;
			case "4":
				System.out.println("Digite o id do local que deseja buscar");
				id = scan.nextLine();
				g.visualizarLocal(Integer.parseInt(id));
			break;
			case "5":
				g.visualizarTodosLocais();
			break;
			case "6":
				System.out.println("Digite o nome do local que deseja editar");
				nome = scan.nextLine();
				g.editarLocal(nome);
			break;
			case "7":
				System.out.println("Digite o número do id do local que deseja editar");
				id = scan.nextLine();
				g.editarLocal(Integer.parseInt(id));
			break;
			case "8":
				System.out.println("Digite o nome do local que deseja remover");
				nome = scan.nextLine();
				g.removerLocal(nome);
			break;
			case "9":
				System.out.println("Digite o número do id do local que deseja remover");
				id = scan.nextLine();
				g.removerLocal(Integer.parseInt(id));
			break;
		}
	}

	/**
	 * Cria uma inst�ncia do tipo GerenciaCalendarioInterface e exibe as op��es de
	 * gerenciamento.
	 * As op��es s�o escolhidas por meio de entrada do usu�rio.	 *
	 */
	public void gerenciaCalendario() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */
	}

	/**
	 * Exibe registros de intera��o com o sistema. Cada registro e composto por data, hor�rio
	 * e intera��o. As intera��es s�o a descri��o de alguma operacao do sistema (simbolizada por
	 *  cada m�todo presente nas interfaces) e o resultado daquela opera��o. As mensagens podem ser
	 *  configuradas mas devem conter a data e hor�rio, descri��o e resultado da opera��o. Deve garantir que
	 *  exista uma inst�ncia �nica de log no sistema.
	 */
	public void exibeLog() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */
	}


	/**
	 * Armazena todas as altera��es de turmas, calend�rio, atividades, locais, usu�rios, etc; assim como o log e
	 * qualquer intera��o realizada, para que o sistema possa ser continuado a cada execu��o. Garante o armazenamento dos
	 * dados apenas se esta op��o for escolhida. Esta opera��o tamb�m deve ser registrada no log.
	 */
	public void salvarEstadoSistema() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */
	}





}
