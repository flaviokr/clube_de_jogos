package gerenciadores;

import modelos.*;
import relatorios.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

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
		String op;
		String res;
		boolean ret;
		Log log = Log.getInstance();
		switch (opcao) {
			case "1":
				System.out.println("\nDigite o nome do arquivo");
				String arquivo = scan.nextLine();
				Path path = Paths.get(arquivo.trim());
				ret =  g.cadastraUsuariosAntigos(path);
				op = "Cadastrar usuários antigos";
				res = ret ? "Todos os cadastros realizados com sucesso" : "Alguns cadastros não realizados";
				log.logar(op, res);
			break;
			case "2":
				g.exportaUsuariosSistemaAntigo();
				op = "Exportar usuários sistema antigo";
				res = "Exportação realizada com sucesso";
				log.logar(op, res);
			break;
			case "3":
				ret = g.cadastrarNovoUsuario();
				op = "Cadastrar novo usuário";
				res = ret ? "Cadastro realizado com sucesso" : "Cadastro não realizado";
				log.logar(op, res);
			break;
			case "4":
				//g.cadastrarNovosUsuarios();
			break;
			case "5":
				System.out.println("Digite o nome do usuário que deseja buscar");
				nome = scan.nextLine();
				g.visualizarUsuario(nome.trim());
				op = "Visualizar usuário";
				res = "Visualizou o usuário " + nome.trim();
				log.logar(op, res);
			break;
			case "6":
				System.out.println("Digite o número de matrícula do usuário que deseja buscar");
				matricula = scan.nextLine();
				g.visualizarUsuario(Integer.parseInt(matricula));
				op = "Visualizar usuário";
				res = "Visualizou o usuário de matrícula" + matricula.trim();
				log.logar(op, res);
			break;
			case "7":
				g.visualizarTodosUsuarios();
				op = "Visualizar todos os usuários";
				res = "Visualizou todos os usuários com sucesso";
				log.logar(op, res);
			break;
			case "8":
				System.out.println("Digite o nome do usuário que deseja editar");
				nome = scan.nextLine();
				g.editarUsuario(nome.trim());
				op = "Editar usuário";
				res = "Editou o usuário " + nome.trim();
				log.logar(op, res);
			break;
			case "9":
				System.out.println("Digite o número de matrícula do usuário que deseja editar");
				matricula = scan.nextLine();
				g.editarUsuario(Integer.parseInt(matricula));
				op = "Editar usuário";
				res = "Editou o usuário de matrícula " + matricula.trim();
				log.logar(op, res);
			break;
			case "10":
				System.out.println("Digite o nome do usuário que deseja remover");
				nome = scan.nextLine();
				ret = g.removerUsuario(nome);
				op = "Remover usuário";
				res = ret ? "Usuário " + nome.trim() + " removido com sucesso" : "Usuário " + nome.trim() + " não removido";
				log.logar(op, res);
			break;
			case "11":
				System.out.println("Digite o número da matrícula do usuário que deseja remover");
				matricula = scan.nextLine();
				ret = g.removerUsuario(Integer.parseInt(matricula));
				op = "Remover usuário";
				res = ret ? "Usuário de matrícula " + matricula.trim() + " removido com sucesso" : "Usuário de matrícula " + matricula.trim() + " não removido";
				log.logar(op, res);
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
    String op;
    String res;
    boolean ret;
    Log log = Log.getInstance();
    switch (opcao) {
      case "1":
        ret = g.cadastrarAtividade();
        op = "Cadastrar uma nova atividade";
        res = ret ? "Cadastro realizado com sucesso" : "Cadastro não realizado";
        log.logar(op, res);
      break;
      case "2":
          // nao sabemos
      break;
      case "3":
        System.out.println("Digite o nome da atividade que deseja buscar");
        nome = scan.nextLine();
        g.visualizarAtividade(nome.trim());
        op = "Visualizar atividade";
        res = "Visualizou a atividade:" + nome.trim();
        log.logar(op, res);
      break;
      case "4":
        System.out.println("Digite o id da atividade que deseja buscar");
        id = scan.nextLine();
        g.visualizarAtividade(Integer.parseInt(id));
        op = "Visualizar atividade";
        res = "Visualizou a atividade de Id: " + id.trim();
        log.logar(op, res);
      break;
      case "5":
        g.visualizarTodasAtividades();
        op = "Visualizar todas as atividades";
        res = "Visualizou todas as atividades com sucesso";
        log.logar(op, res);
      break;
      case "6":
        System.out.println("Digite o nome da atividade que deseja editar");
        nome = scan.nextLine();
        g.editarAtividade(nome.trim());
        op = "Editou atividade";
        res = "Editou a atividade: " + nome.trim();
        log.logar(op, res);
      break;
      case "7":
        System.out.println("Digite o id da atividade que deseja editar");
        id = scan.nextLine();
        g.editarAtividade(Integer.parseInt(id));
        op = "Editar atividade";
        res = "Editou a atividade de Id: " + id.trim();
        log.logar(op, res);
      break;
      case "8":
        System.out.println("Digite o nome da atividade que deseja remover");
        nome = scan.nextLine();
        ret = g.removerAtividade(nome.trim());
        op = "Remover atividade";
        res = ret ? "Removeu a atividade " + nome.trim() : "Remoção não realizada";
        log.logar(op, res);
      break;
      case "9":
        System.out.println("Digite o id da atividade que deseja remover");
        id = scan.nextLine();
        ret = g.removerAtividade(Integer.parseInt(id));
        op = "Remover atividade";
        res = ret ? "Removeu a atividade de Id " + id.trim() : "Remoção não realizada";
        log.logar(op, res);
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
		String op;
		String res;
		boolean ret;
		Log log = Log.getInstance();
		switch (opcao) {
			case "1":
				ret = g.cadastrarNovoLocal();
				op = "Cadastrar novo local";
				res = ret ? "Local cadastrado com sucesso" : "Local não cadastrado";
				log.logar(op, res);
			break;
			case "3":
				System.out.println("Digite o nome do local que deseja buscar");
				nome = scan.nextLine();
				g.visualizarLocal(nome.trim());
				op = "Visualiazar local";
				res = "Visualizou local de nome " + nome.trim() + " com sucesso";
				log.logar(op, res);
			break;
			case "4":
				System.out.println("Digite o id do local que deseja buscar");
				id = scan.nextLine();
				g.visualizarLocal(Integer.parseInt(id));
				op = "Visualiazar local";
				res = "Visualizou local de id " + id.trim() + " com sucesso";
				log.logar(op, res);
			break;
			case "5":
				g.visualizarTodosLocais();
				op = "Visualizar todos os locais";
				res = "Visualizou todos os locais com sucesso";
				log.logar(op, res);
			break;
			case "6":
				System.out.println("Digite o nome do local que deseja editar");
				nome = scan.nextLine();
				g.editarLocal(nome);
				op = "Editar local";
				res = "Editou local de nome " + nome.trim() + " com sucesso";
				log.logar(op, res);
			break;
			case "7":
				System.out.println("Digite o número do id do local que deseja editar");
				id = scan.nextLine();
				g.editarLocal(Integer.parseInt(id));
				op = "Editar local";
				res = "Editou local de id " + id.trim() + " com sucesso";
				log.logar(op, res);
			break;
			case "8":
				System.out.println("Digite o nome do local que deseja remover");
				nome = scan.nextLine();
				ret = g.removerLocal(nome);
				op = "Remover local";
				res = ret ? "Local de nome " + nome.trim() + " removido com sucesso" : "Local de nome " + nome.trim() + " não removido";
				log.logar(op, res);
			break;
			case "9":
				System.out.println("Digite o número do id do local que deseja remover");
				id = scan.nextLine();
				ret = g.removerLocal(Integer.parseInt(id));
				op = "Remover local";
				res = ret ? "Local de id " + id.trim() + " removido com sucesso" : "Local de id " + id.trim() + " não removido";
				log.logar(op, res);
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
		try {
			BufferedReader reader = new BufferedReader(new FileReader("log.txt"));
			String input = reader.readLine();			
			System.out.println("\n");
			while (input != null) {
				System.out.println(input);
				input = reader.readLine();
			}
		} catch (Exception e) {
			System.out.println("\nErro na escrita do log");
		}
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
