package controladores;
import modelos.*;

public class Cadastros {

  public static Usuario cadastrarPessoa(String nome) {
    return new Usuario("Pessoa", nome);
  }

  public static Usuario cadastrarEquipe(String nome) {
    return new Usuario("Equipe", nome);
  }

  public static Atividade criarAtividade(Jogo jogo, int pontos, Data data, Horario inicio, Horario fim, Horario duracao) {
    if (duracao.getHoras() < 2) return null;
    return new Atividade(jogo, pontos, data, inicio, fim, duracao);
  }

  public static Turma criarTurma(Atividade a, Espaco espaco, int duracao, Data inicio, Data fim) {
    if (a.getData().getAno() >= inicio.getAno() &&
        a.getData().getAno() <= fim.getAno() &&
        a.getData().getMes() >= inicio.getMes() &&
        a.getData().getMes() <= fim.getMes() &&
        a.getData().getDia() >= inicio.getDia() &&
        a.getData().getDia() <= fim.getDia()) {
          return new Turma(a, espaco, duracao, inicio, fim);
       }
    return null;
  }
}
