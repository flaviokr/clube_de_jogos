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

import java.util.List;

public class GerenciadorLocal<L> {

	public boolean cadastrarNovoLocal() {
		boolean retorno = true;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Digite o nome do novo local");
			String nome = scan.nextLine();
			for (Espaco n : Espaco.getListaDeEspacos()) {
				if (n.getNome().equals(nome)) return false;
			}
			System.out.println("Selecione o tipo do local:");
			System.out.println("(1) Quadra");
			System.out.println("(2) Sala");
			String opcao = scan.nextLine();
			String tipo = "Quadra";
			if (opcao.trim().equals("2")) tipo = "Sala";
			Espaco e = new Espaco(tipo);
			e.setNome(nome);
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar novo local");
			GerenciamentoClubeJogosInterface g = new GerenciamentoClubeJogosInterface();
			g.gerenciaLocal();
			retorno = false;
		}
		return retorno;
	}

	public void cadastrarNovosLocais(List<L> locais) {
		// Não entendemos
	}

	public void visualizarLocal(String nomeLocal) {
		for (Espaco e : Espaco.getListaDeEspacos()){
			if (e.getNome().equals(nomeLocal)) {
				System.out.println("\nID: " + e.getId());
				System.out.println("Nome: " + e.getNome());
				System.out.println("Tipo: " + e.getTipo());
			}
		}
	}

	public void visualizarLocal(int id) {
		for (Espaco e : Espaco.getListaDeEspacos()) {
			if (e.getId() == id) {
				System.out.println("\nID: " + e.getId());
				System.out.println("Nome: " + e.getNome());
				System.out.println("Tipo: " + e.getTipo());
			}
		}
	}

	public int visualizarTodosLocais() {
		System.out.println("\nNúmero total de locais cadastrados: " + Espaco.getListaDeEspacos().size());
		for (Espaco e : Espaco.getListaDeEspacos()) {
			System.out.println("\nID: " + e.getId());
			System.out.println("Nome: " + e.getNome());
			System.out.println("Tipo: " + e.getTipo());
		}
		return Espaco.getListaDeEspacos().size();
	}

	public void editarLocal(String nomeLocal) {
		for (Espaco e : Espaco.getListaDeEspacos()){
			if (e.getNome().equals(nomeLocal)) {
				Scanner scan = new Scanner(System.in);
				System.out.println("Digite o novo nome do local (deixe em branco se não quiser alterar)");
				String nome = scan.nextLine();
				System.out.println("Selecione o novo tipo do local (deixe em branco se não quiser alterar)");
				System.out.println("(1) Quadra");
				System.out.println("(2) Sala");
				String opcao = scan.nextLine();
				String tipo = "Quadra";
				if (opcao.trim().equals("2")) tipo = "Sala";
				if (!nome.trim().equals("")) e.setNome(nome);
				if (!tipo.trim().equals("")) e.setTipo(tipo);
			}
		}
	}

	public void editarLocal(int id) {
		for (Espaco e : Espaco.getListaDeEspacos()){
			if (e.getId() == id) {
				Scanner scan = new Scanner(System.in);
				System.out.println("Digite o novo nome do local (deixe em branco se não quiser alterar)");
				String nome = scan.nextLine();
				System.out.println("Selecione o novo tipo do local (deixe em branco se não quiser alterar)");
				System.out.println("(1) Quadra");
				System.out.println("(2) Sala");
				String opcao = scan.nextLine();
				String tipo = "Quadra";
				if (opcao.trim().equals("2")) tipo = "Sala";
				if (!nome.trim().equals("")) e.setNome(nome);
				if (!tipo.trim().equals("")) e.setTipo(tipo);
			}
		}
	}

	public boolean removerLocal(String nomeLocal) {
		for (Espaco e : Espaco.getListaDeEspacos()){
			if (e.getNome().equals(nomeLocal)) {
				System.out.println("\nID: " + e.getId());
				System.out.println("Nome: " + e.getNome());
				System.out.println("Tipo: " + e.getTipo());
				System.out.println("\nTem certeza que deseja remover esse local? (s/n)");
				Scanner scan = new Scanner(System.in);
				String resp = scan.nextLine();
				if (resp.equals("s")) {
					Espaco.getListaDeEspacos().remove(e);
					return true;
				}
			}
		}
		System.out.println("Local não removido");
		return false;
	}

	public boolean removerLocal(int id) {
		for (Espaco e : Espaco.getListaDeEspacos()){
			if (e.getId() == id) {
				System.out.println("\nID: " + e.getId());
				System.out.println("Nome: " + e.getNome());
				System.out.println("Tipo: " + e.getTipo());
				System.out.println("\nTem certeza que deseja remover esse local? (s/n)");
				Scanner scan = new Scanner(System.in);
				String resp = scan.nextLine();
				if (resp.equals("s")) {
					Espaco.getListaDeEspacos().remove(e);
					return true;
				}
			}
		}
		System.out.println("Local não removido");
		return false;
	}

}
