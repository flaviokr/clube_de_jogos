package gerenciadores;

import modelos.*;
import controladores.*;
import java.util.List;
import java.util.Scanner;

public class GerenciadorAtividade <A>{

	public boolean cadastrarAtividade() {
		boolean retorno = true;
		try {

			Scanner scan = new Scanner(System.in);
			System.out.println("Digite o nome da nova atividade");
			String nome = scan.nextLine();
			nome = nome.trim();
			for (Atividade n : Atividade.getListaDeAtividades()) {
				if (n.getNome().equals(nome)){
					System.out.println("Já existe atividade com esse nome");
					return false;
				}
			}

			System.out.println("Digite o nome do jogo");
			String nome_jogo = scan.nextLine();
			System.out.println("Selecione o tipo do jogo:");
			System.out.println("(1) Analógico");
			System.out.println("(2) Físico");
			String opcao_jogo = scan.nextLine();
			String tipo_jogo = "Analógico";
			if (opcao_jogo.trim().equals("2")) tipo_jogo = "Físico";
			Jogo jogo = new Jogo(nome_jogo, tipo_jogo);

			System.out.println("Digite a pontuação da atividade");
			String pontos_string = scan.nextLine();
			int pontos = Integer.parseInt(pontos_string);

			System.out.println("Selecione o tipo do local:");
			System.out.println("(1) Quadra");
			System.out.println("(2) Sala");
			String opcao = scan.nextLine();
			String tipo_local = "Quadra";
			if (opcao.trim().equals("2")) tipo_local = "Sala";

			System.out.println("Digite a data de realização da atividade (dd/mm/aaaa)");
			String data_string = scan.nextLine();
			String[] data_array = data_string.trim().split("/");
			Data data = new Data(Integer.parseInt(data_array[0]), Integer.parseInt(data_array[1]), Integer.parseInt(data_array[2]), true);

			System.out.println("Digite o horário de início da atividade (hh:mm)");
			String horario_string = scan.nextLine();
			String[] horario_array = horario_string.trim().split(":");
			Horario inicio = new Horario(Integer.parseInt(horario_array[0]), Integer.parseInt(horario_array[1]));

			System.out.println("Digite a duração (em horas) da atividade");
			String duracao_string = scan.nextLine();
			Horario duracao = new Horario(Integer.parseInt(duracao_string), 0);

			Horario fim = new Horario(inicio.getHoras() + duracao.getHoras(), inicio.getMinutos());

			Atividade a = new Atividade(jogo, pontos, data, inicio, fim, duracao);
			a.setNome(nome);
			a.setTipoLocal(tipo_local);

		} catch (Exception e) {
			System.out.println("Erro ao cadastrar nova atividade");
			GerenciamentoClubeJogosInterface g = new GerenciamentoClubeJogosInterface();
			g.gerenciaAtividade();
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Cadastra uma lista de atividades. Se j� houver uma atividade com o mesmo nome n�o realiza o cadastro daquela, as outras s�o
	 * cadastradas se n�o houver conflito.
	 * @param atividades - lista de atividades a serem cadastradas segundo sua implementa��o
	 * @return boolean - true se todas as atividades forem cadastradas ; false - caso
	 * uma ou mais atividades n�o tiverem sido cadastradas
	 */
	public boolean cadastrarNovasAtividade(List<A> atividades) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */
		return false;
	}

	public void visualizarAtividade(String nomeAtividade) {
		for (Atividade a : Atividade.getListaDeAtividades()) {
			if (a.getNome().equals(nomeAtividade)) {
				System.out.println("\nID: " + a.getId());
				System.out.println("Nome: " + a.getNome());
				System.out.println("Jogo: " + a.getJogo().getNome());
				System.out.println("Tipo do local: " + a.getTipoLocal());
				System.out.println("Data de realização: " + a.getData().getDia() + "/" + a.getData().getMes() + "/" + a.getData().getAno());
				System.out.println("Horário de início: " + a.getInicio().getHoras() + ":" + a.getInicio().getMinutos());
				System.out.println("Duração: " + a.getDuracao().getHoras() + " horas");
				return;
			}
		}
	}

	public void visualizarAtividade(int id) {
		for (Atividade a : Atividade.getListaDeAtividades()) {
			if (a.getId() == id) {
				System.out.println("\nID: " + a.getId());
				System.out.println("Nome: " + a.getNome());
				System.out.println("Jogo: " + a.getJogo().getNome());
				System.out.println("Tipo do local: " + a.getTipoLocal());
				System.out.println("Data de realização: " + a.getData().getDia() + "/" + a.getData().getMes() + "/" + a.getData().getAno());
				System.out.println("Horário de início: " + a.getInicio().getHoras() + ":" + a.getInicio().getMinutos());
				System.out.println("Duração: " + a.getDuracao().getHoras() + " horas");
				return;
			}
		}
	}

	public int visualizarTodasAtividades() {
		System.out.println("\nNúmero total de atividades: " + Atividade.getListaDeAtividades().size());
		for (Atividade a : Atividade.getListaDeAtividades()) {
			System.out.println("\nID: " + a.getId());
			System.out.println("Nome: " + a.getNome());
			System.out.println("Jogo: " + a.getJogo().getNome());
			System.out.println("Tipo do local: " + a.getTipoLocal());
			System.out.println("Data de realização: " + a.getData().getDia() + "/" + a.getData().getMes() + "/" + a.getData().getAno());
			System.out.println("Horário de início: " + a.getInicio().getHoras() + ":" + a.getInicio().getMinutos());
			System.out.println("Duração: " + a.getDuracao().getHoras() + " horas");
		}
		return Atividade.getListaDeAtividades().size();
	}


	/**
	 * Altera um ou mais campos da atividade passada como par�metro.
	 * @param nomeAtividade - nome da atividade a ser editada
	 *
	 */
	public void editarAtividade(String nomeAtividade) {
		for (Atividade a : Atividade.getListaDeAtividades()){
			if (a.getNome().equals(nomeAtividade)) {
				Scanner scan = new Scanner(System.in);

				System.out.println("Digite o novo nome da atividade (deixe em branco se não quiser alterar)");
				String nome = scan.nextLine();

				System.out.println("Digite o novo nome do jogo (deixe em branco se não quiser alterar)");
				String nome_jogo = scan.nextLine();

				System.out.println("Selecione o novo tipo do jogo (deixe em branco se não quiser alterar)");
				System.out.println("(1) Analógico");
				System.out.println("(2) Físico");
				String opcao = scan.nextLine();
				String tipo_jogo = "Analógico";
				if (opcao.trim().equals("2")) tipo_jogo = "Físico";

				if (!nome_jogo.trim().equals("")) a.getJogo().setNome(nome_jogo);
				if (!tipo_jogo.trim().equals("")) a.getJogo().setTipo(tipo_jogo);

				System.out.println("Digite a nova pontuação da atividade (deixe em branco se não quiser alterar)");
				String pontos_string = scan.nextLine();

				System.out.println("Selecione o novo tipo do local da atividade (deixe em branco se não quiser alterar)");
				System.out.println("(1) Quadra");
				System.out.println("(2) Sala");
				opcao = scan.nextLine();
				String tipo_local = "Quadra";
				if (opcao.trim().equals("2")) tipo_jogo = "Sala";

				if (!nome.trim().equals("")) a.setNome(nome);
				if (!pontos_string.trim().equals("")) a.setPontos(Integer.parseInt(pontos_string));
				if (!tipo_local.trim().equals("")) a.setTipoLocal(tipo_local);
			}
		}
	}

	/**
	 * Exibe todos os campos da atividade passado como par�metro e altera um ou mais campos.
	 * Os campos s�o preenchidos por meio de entrada do usu�rio.
	 * @param id - identificador da atividade a ser editada
	 *
	 */
	public void editarAtividade(int id) {
			for (Atividade a : Atividade.getListaDeAtividades()){
				if (a.getId() == id) {
					Scanner scan = new Scanner(System.in);

					System.out.println("Digite o novo nome da atividade (deixe em branco se não quiser alterar)");
					String nome = scan.nextLine();

					System.out.println("Digite o novo nome do jogo (deixe em branco se não quiser alterar)");
					String nome_jogo = scan.nextLine();

					System.out.println("Selecione o novo tipo do jogo (deixe em branco se não quiser alterar)");
					System.out.println("(1) Analógico");
					System.out.println("(2) Físico");
					String opcao = scan.nextLine();
					String tipo_jogo = "Analógico";
					if (opcao.trim().equals("2")) tipo_jogo = "Físico";

					if (!nome_jogo.trim().equals("")) a.getJogo().setNome(nome_jogo);
					if (!tipo_jogo.trim().equals("")) a.getJogo().setTipo(tipo_jogo);

					System.out.println("Digite a nova pontuação da atividade (deixe em branco se não quiser alterar)");
					String pontos_string = scan.nextLine();

					System.out.println("Selecione o novo tipo do local da atividade (deixe em branco se não quiser alterar)");
					System.out.println("(1) Quadra");
					System.out.println("(2) Sala");
					opcao = scan.nextLine();
					String tipo_local = "Quadra";
					if (opcao.trim().equals("2")) tipo_jogo = "Sala";

					if (!nome.trim().equals("")) a.setNome(nome);
					if (!pontos_string.trim().equals("")) a.setPontos(Integer.parseInt(pontos_string));
					if (!tipo_local.trim().equals("")) a.setTipoLocal(tipo_local);
				}
			}
	}

	public boolean removerAtividade(String nomeAtividade) {
		for (Atividade a : Atividade.getListaDeAtividades()){
			if (a.getNome().equals(nomeAtividade)) {
				System.out.println("\nID: " + a.getId());
				System.out.println("Nome: " + a.getNome());
				System.out.println("Jogo: " + a.getJogo().getNome());
				System.out.println("Tipo do local: " + a.getTipoLocal());
				System.out.println("Data de realização: " + a.getData().getDia() + "/" + a.getData().getMes() + "/" + a.getData().getAno());
				System.out.println("Horário de início: " + a.getInicio().getHoras() + ":" + a.getInicio().getMinutos());
				System.out.println("Duração: " + a.getDuracao().getHoras() + " horas");
				System.out.println("\nTem certeza que deseja remover essa atividade? (s/n)");
				Scanner scan = new Scanner(System.in);
				String resp = scan.nextLine();
				if (resp.equals("s")) {
					Atividade.getListaDeAtividades().remove(a);
					return true;
				}
			}
		}
		System.out.println("Atividade não removido");
		return false;
	}

	public boolean removerAtividade(int id) {
		for (Atividade a : Atividade.getListaDeAtividades()){
			if (a.getId() == id) {
				System.out.println("\nID: " + a.getId());
				System.out.println("Nome: " + a.getNome());
				System.out.println("Jogo: " + a.getJogo().getNome());
				System.out.println("Tipo do local: " + a.getTipoLocal());
				System.out.println("Data de realização: " + a.getData().getDia() + "/" + a.getData().getMes() + "/" + a.getData().getAno());
				System.out.println("Horário de início: " + a.getInicio().getHoras() + ":" + a.getInicio().getMinutos());
				System.out.println("Duração: " + a.getDuracao().getHoras() + " horas");
				System.out.println("\nTem certeza que deseja remover essa atividade? (s/n)");
				Scanner scan = new Scanner(System.in);
				String resp = scan.nextLine();
				if (resp.equals("s")) {
					Atividade.getListaDeAtividades().remove(a);
					return true;
				}
			}
		}
		System.out.println("Atividade não removido");
		return false;
	}

}
