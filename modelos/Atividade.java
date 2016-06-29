package modelos;

public class Atividade {

  private Jogo jogo;

  private int pontos;

  private Data data;

  private Horario duracao;

  private Horario inicio;

  private Horario fim;

  public Atividade(Jogo jogo, int pontos, Data data, Horario inicio, Horario fim, Horario duracao) {
    this.jogo = jogo;
    this.pontos = pontos;
    this.data = data;
    this.inicio = inicio;
    this.fim = fim;
    this.duracao = duracao;
  }

  public Jogo getJogo() {
    return this.jogo;
  }

  public int getPontos() {
    return this.pontos;
  }

  public Horario getDuracao() {
    return this.duracao;
  }

  public Horario getInicio() {
    return this.inicio;
  }

  public Horario getFim() {
    return this.fim;
  }

  public Data getData() {
    return this.data;
  }
}
