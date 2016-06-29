package modelos;
import java.util.ArrayList;

public class Atividade {

  private static ArrayList<Atividade> lista_de_atividades = new ArrayList<Atividade>();

  private static int numero_de_atividades = 1;

  private int id;

  private String nome;

  private Jogo jogo;

  private int pontos;

  private String tipo_local;

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
    this.id = numero_de_atividades;
    numero_de_atividades += 1;
    lista_de_atividades.add(this);
  }

  public static ArrayList<Atividade> getListaDeAtividades() {
    return lista_de_atividades;
  }

  public String getTipoLocal() {
    return this.tipo_local;
  }

  public void setTipoLocal(String tipo_local) {
    this.tipo_local = tipo_local;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getId() {
    return this.id;
  }

  public Jogo getJogo() {
    return this.jogo;
  }

  public int getPontos() {
    return this.pontos;
  }

  public void setPontos(int pontos) {
    this.pontos = pontos;
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
