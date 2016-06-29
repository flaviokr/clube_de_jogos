package gerenciadores;
import modelos.*;
import controladores.*;
import java.nio.file.Path;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class GerenciadorUsuario <U>{

		public boolean cadastraUsuariosAntigos(Path arquivo) {
			boolean retorno = true;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(arquivo.toString()));
				String input = reader.readLine();
				String[] registros = input.split("\\|");
				boolean skip = false;
				for (int i = 0; i < registros.length; i++) {
					String[] usuario = registros[i].split(",");
					for (Usuario n : Usuario.getListaDeUsuarios()) {
						if (n.getNome().equals(usuario[0]) && n.getEndereco().equals(usuario[1])) {
							System.out.println("Usuario " + n.getNome() + " já existe.");
							skip = true;
							retorno = false;
						}
					}
					if (!skip) {
						Usuario u = new Usuario("Pessoa", usuario[0]);
						u.setAtributosLegacy(usuario[1], usuario[2], usuario[3]);
					}
					skip = false;
				}
			} catch (Exception e) {
				System.out.println("\nNão existe nenhum arquivo com esse nome.");
				GerenciamentoClubeJogosInterface g = new GerenciamentoClubeJogosInterface();
				g.gerenciaUsuario();
			};
			return retorno;
		}

		public void exportaUsuariosSistemaAntigo() {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios_sistema_antigo.dat"));
				String output = "";
				for (Usuario u : Usuario.getListaDeUsuarios()) {
					output += u.getNome() + "," + u.getIdade() + "," + u.getEndereco() + "," + u.getTelefone() + "|";
				}
				writer.write(output);
				writer.close();
			} catch (Exception e) {
				System.out.println("\nErro na escrita do arquivo.");
				GerenciamentoClubeJogosInterface g = new GerenciamentoClubeJogosInterface();
				g.gerenciaUsuario();
			}
		}

		public boolean cadastrarNovoUsuario() {
			boolean retorno = true;
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("Digite o nome do novo usuário");
				String nome = scan.nextLine();
				for (Usuario n : Usuario.getListaDeUsuarios()) {
					if (n.getNome().equals(nome)) return false;
				}
				System.out.println("Digite a idade do novo usuário");
				String idade = scan.nextLine();
				System.out.println("Digite o sexo do novo usuário");
				String sexo = scan.nextLine();
				System.out.println("Digite o endereço do novo usuário");
				String endereco = scan.nextLine();
				System.out.println("Digite o telefone do novo usuário");
				String telefone = scan.nextLine();
				Usuario u = new Usuario("Pessoa", nome);
				u.setAtributosLegacy(idade, endereco, telefone);
				u.setSexo(sexo);
			} catch (Exception e) {
				System.out.println("Erro ao cadastrar novo usuário");
				GerenciamentoClubeJogosInterface g = new GerenciamentoClubeJogosInterface();
				g.gerenciaUsuario();
				retorno = false;
			}
			return retorno;
		}


		public boolean cadastrarNovosUsuarios(List<U> usuarios) {
			// Não entendemos
			return false;
		}


		public void visualizarUsuario(String nomeUsuario) {
			for (Usuario u : Usuario.getListaDeUsuarios()){
				if (u.getNome().equals(nomeUsuario)) {
					System.out.println("\nNome: " + u.getNome());
					System.out.println("Idade: " + u.getIdade());
					System.out.println("Endereço: " + u.getEndereco());
					System.out.println("Telefone: " + u.getTelefone());
					ArrayList<Turma> turmas = u.getTurmas();
					if (turmas != null) {
						for (Turma t : turmas) {
							Atividade a = t.getAtividade();
							Jogo j = a.getJogo();
							Espaco e = t.getEspaco();
							Horario h = a.getInicio();
							System.out.println("Jogo: " + j.getNome());
							System.out.println("Local: " + e.getTipo());
							System.out.println("Horário: " + h.getHoras() + ":" + h.getMinutos());
						}
					}
				}
			}
		}

		public void visualizarUsuario(int nMatricula) {
			for (Usuario u : Usuario.getListaDeUsuarios()){
				if (u.getMatricula() == nMatricula) {
					System.out.println("\nNome: " + u.getNome());
					System.out.println("Idade: " + u.getIdade());
					System.out.println("Endereço: " + u.getEndereco());
					System.out.println("Telefone: " + u.getTelefone());
					ArrayList<Turma> turmas = u.getTurmas();
					if (turmas != null) {
						for (Turma t : turmas) {
							Atividade a = t.getAtividade();
							Jogo j = a.getJogo();
							Espaco e = t.getEspaco();
							Horario h = a.getInicio();
							System.out.println("Jogo: " + j.getNome());
							System.out.println("Local: " + e.getTipo());
							System.out.println("Horário: " + h.getHoras() + ":" + h.getMinutos());
						}
					}
				}
			}
		}

		public int visualizarTodosUsuarios() {
			System.out.println("\nNúmero total de usuários cadastrados: " + Usuario.getListaDeUsuarios().size());
			for (Usuario u : Usuario.getListaDeUsuarios()){
				System.out.println("\nNome: " + u.getNome());
				System.out.println("Idade: " + u.getIdade());
				System.out.println("Endereço: " + u.getEndereco());
				System.out.println("Telefone: " + u.getTelefone());
				ArrayList<Turma> turmas = u.getTurmas();
				if (turmas != null) {
					for (Turma t : turmas) {
						Atividade a = t.getAtividade();
						Jogo j = a.getJogo();
						Espaco e = t.getEspaco();
						Horario h = a.getInicio();
						System.out.println("Jogo: " + j.getNome());
						System.out.println("Local: " + e.getTipo());
						System.out.println("Horário: " + h.getHoras() + ":" + h.getMinutos());
					}
				}
			}
			return Usuario.getListaDeUsuarios().size();
		}

		public void editarUsuario(String nomeUsuario) {
			for (Usuario u : Usuario.getListaDeUsuarios()){
				if (u.getNome().equals(nomeUsuario)) {
					Scanner scan = new Scanner(System.in);
					System.out.println("Digite o novo nome do usuário (deixe em branco se não quiser alterar)");
					String nome = scan.nextLine();
					System.out.println("Digite a nova idade do usuário (deixe em branco se não quiser alterar)");
					String idade = scan.nextLine();
					System.out.println("Digite o novo endereco do usuário (deixe em branco se não quiser alterar)");
					String endereco = scan.nextLine();
					System.out.println("Digite o novo telefone do usuário (deixe em branco se não quiser alterar)");
					String telefone = scan.nextLine();
					if (!nome.trim().equals("")) u.setNome(nome);
					if (!idade.trim().equals("")) u.setIdade(idade);
					if (!endereco.trim().equals("")) u.setEndereco(endereco);
					if (!telefone.trim().equals("")) u.setTelefone(telefone);
				}
			}
		}

		public void editarUsuario(int nMatricula) {
			for (Usuario u : Usuario.getListaDeUsuarios()){
				if (u.getMatricula() == nMatricula) {
					Scanner scan = new Scanner(System.in);
					System.out.println("Digite o novo nome do usuário (deixe em branco se não quiser alterar)");
					String nome = scan.nextLine();
					System.out.println("Digite a nova idade do usuário (deixe em branco se não quiser alterar)");
					String idade = scan.nextLine();
					System.out.println("Digite o novo endereco do usuário (deixe em branco se não quiser alterar)");
					String endereco = scan.nextLine();
					System.out.println("Digite o novo telefone do usuário (deixe em branco se não quiser alterar)");
					String telefone = scan.nextLine();
					if (!nome.trim().equals("")) u.setNome(nome);
					if (!idade.trim().equals("")) u.setIdade(idade);
					if (!endereco.trim().equals("")) u.setEndereco(endereco);
					if (!telefone.trim().equals("")) u.setTelefone(telefone);
				}
			}
		}

		public boolean removerUsuario(String nomeUsuario) {
			for (Usuario u : Usuario.getListaDeUsuarios()){
				if (u.getNome().equals(nomeUsuario)) {
					System.out.println("\nNome: " + u.getNome());
					System.out.println("Idade: " + u.getIdade());
					System.out.println("Endereço: " + u.getEndereco());
					System.out.println("Telefone: " + u.getTelefone());
					ArrayList<Turma> turmas = u.getTurmas();
					if (turmas != null) {
						for (Turma t : turmas) {
							Atividade a = t.getAtividade();
							Jogo j = a.getJogo();
							Espaco e = t.getEspaco();
							Horario h = a.getInicio();
							System.out.println("Jogo: " + j.getNome());
							System.out.println("Local: " + e.getTipo());
							System.out.println("Horário: " + h.getHoras() + ":" + h.getMinutos());
						}
					}
					System.out.println("\nTem certeza que deseja remover esse usuário? (s/n)");
					Scanner scan = new Scanner(System.in);
					String resp = scan.nextLine();
					if (resp.equals("s")) {
						Usuario.getListaDeUsuarios().remove(u);
						return true;
					}
				}
			}
			System.out.println("Usuário não removido");
			return false;
		}

		public boolean removerUsuario(int nMatricula) {
			for (Usuario u : Usuario.getListaDeUsuarios()){
				if (u.getMatricula() == nMatricula) {
					System.out.println("\nNome: " + u.getNome());
					System.out.println("Idade: " + u.getIdade());
					System.out.println("Endereço: " + u.getEndereco());
					System.out.println("Telefone: " + u.getTelefone());
					ArrayList<Turma> turmas = u.getTurmas();
					if (turmas != null) {
						for (Turma t : turmas) {
							Atividade a = t.getAtividade();
							Jogo j = a.getJogo();
							Espaco e = t.getEspaco();
							Horario h = a.getInicio();
							System.out.println("Jogo: " + j.getNome());
							System.out.println("Local: " + e.getTipo());
							System.out.println("Horário: " + h.getHoras() + ":" + h.getMinutos());
						}
					}
					System.out.println("\nTem certeza que deseja remover esse usuário? (s/n)");
					Scanner scan = new Scanner(System.in);
					String resp = scan.nextLine();
					if (resp.equals("s")) {
						Usuario.getListaDeUsuarios().remove(u);
						return true;
					}
				}
			}
			System.out.println("Usuário não removido");
			return false;
		}

}
